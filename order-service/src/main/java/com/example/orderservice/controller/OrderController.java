package com.example.orderservice.controller;

import com.example.orderservice.UserClient;
import com.example.orderservice.UserDto;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderResponse;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;


    private final UserClient userClient;


    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        UserDto user = userClient.getUserById(order.getUserId());
        return new OrderResponse(order.getId(), order.getProduct(), order.getPrice(), user);
    }


    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
