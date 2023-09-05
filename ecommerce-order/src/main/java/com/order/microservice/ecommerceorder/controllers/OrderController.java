package com.order.microservice.ecommerceorder.controllers;

import com.order.microservice.ecommerceorder.payloads.OrderDto;
import com.order.microservice.ecommerceorder.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{id}")
    public OrderDto getOrder(@PathVariable Long id) {

        return orderService.getOrder(id);

    }


}

