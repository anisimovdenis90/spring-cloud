package com.anisimov.denis.spring.cloud;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private int price;
    private String address;
    private String phone;
    private String username;
    private List<OrderItemDto> items;
}