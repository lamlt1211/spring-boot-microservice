package com.example.orderservice.model;

import com.example.orderservice.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long orderId;
    private String product;
    private Double price;
    private UserDto user;

}
