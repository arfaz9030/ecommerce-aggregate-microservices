package com.order.microservice.ecommerceorder.services;

import com.order.microservice.ecommerceorder.payloads.OrderDto;
import com.order.microservice.ecommerceorder.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepository;

    public OrderDto getOrder(Long id) {

        var orderDetails = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id " + id + " does not exist."));

        return new OrderDto(id, orderDetails.getName(), orderDetails.getPrice());

    }

}

