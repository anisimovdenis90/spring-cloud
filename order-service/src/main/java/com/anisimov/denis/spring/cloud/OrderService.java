package com.anisimov.denis.spring.cloud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    private final Function<Order, OrderDto> mapOrderToDto = (o) -> {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(o.getId());
        orderDto.setPrice(o.getPrice());
        orderDto.setItems(o.getItems().stream().map(this::mapOrderItemToDto).collect(Collectors.toList()));
        return orderDto;
    };

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(mapOrderToDto).collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Long id) {
        return orderRepository.findById(id).map(mapOrderToDto);
    }

    public void createOrder(Long... productIds) {
        List<OrderItem> orderItems = productService.getProductsByIds(productIds).stream().map(OrderItem::new).collect(Collectors.toList());
        Order order = new Order(orderItems);
        orderRepository.save(order);
    }

    private OrderItemDto mapOrderItemToDto(OrderItem oi) {
        OrderItemDto orderItemDto = new OrderItemDto();
        ProductDto productDto = productService.getProductById(oi.getProductId());
        orderItemDto.setId(oi.getId());
        orderItemDto.setPrice(oi.getPrice());
        orderItemDto.setPricePerProduct(oi.getPricePerProduct());
        orderItemDto.setProductId(oi.getProductId());
        orderItemDto.setQuantity(oi.getQuantity());
        orderItemDto.setProductTitle(productDto.getTitle());
        return orderItemDto;
    }
}
