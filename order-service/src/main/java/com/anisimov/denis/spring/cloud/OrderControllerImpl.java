package com.anisimov.denis.spring.cloud;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderControllerImpl {
    private final OrderService orderService;

    @GetMapping(produces = "application/json")
    public List<OrderDto> showOrders() {
        return orderService.findAll();
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewOrder(@RequestParam Long[] productsId) {
        orderService.createOrder(productsId);
    }
}
