package com.aggregator.microservice.ecommerceaggregator.model;

public record AggregatedData(Order order, Payment payment) {

    public record Order(Long orderId, String name, double price) {

    }

    public record Payment(Long orderId, String status) {

    }
}
