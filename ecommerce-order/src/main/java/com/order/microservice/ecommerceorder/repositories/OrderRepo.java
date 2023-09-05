package com.order.microservice.ecommerceorder.repositories;

import com.order.microservice.ecommerceorder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
