package com.anisimov.denis.spring.cloud.enteties;

import com.anisimov.denis.spring.cloud.dto.ProductDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "price")
    private int price;

    public OrderItem(ProductDto p) {
        this.productId = p.getId();
        this.quantity = 1;
        this.price = p.getPrice();
        this.pricePerProduct = p.getPrice();
    }
}
