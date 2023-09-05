package com.order.microservice.ecommerceorder.payloads;

public record OrderDto(Long orderId, String name, double price) {

}
