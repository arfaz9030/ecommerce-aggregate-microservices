package com.aggregator.microservice.ecommerceaggregator.controllers;

import com.aggregator.microservice.ecommerceaggregator.service.AggregatorService;
import com.aggregator.microservice.ecommerceaggregator.model.AggregatedData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/aggregate-service")
@RequiredArgsConstructor
public class AggregatorController {

    private final AggregatorService orderService;

    @GetMapping("/order/payment/{orderId}")
    public AggregatedData getAggregateData(@PathVariable Long orderId) {

        return orderService.getAggregateData(orderId);

    }


}
