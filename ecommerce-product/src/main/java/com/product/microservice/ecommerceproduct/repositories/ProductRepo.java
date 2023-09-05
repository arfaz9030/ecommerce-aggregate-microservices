package com.product.microservice.ecommerceproduct.repositories;

import com.product.microservice.ecommerceproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
