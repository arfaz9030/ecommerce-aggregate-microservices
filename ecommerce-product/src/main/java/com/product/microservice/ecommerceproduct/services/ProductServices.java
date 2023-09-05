package com.product.microservice.ecommerceproduct.services;


import com.product.microservice.ecommerceproduct.entities.Product;
import com.product.microservice.ecommerceproduct.payloads.ProductDto;
import com.product.microservice.ecommerceproduct.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepo productRepository;

    public void addProductDto(ProductDto product) {

        var productEntity = new Product();
        productEntity.setName(product.name());
        productEntity.setPrice(product.price());

        productRepository.save(productEntity);
    }

    public ProductDto updateProductDto(Long id, ProductDto product) {

        Product retrievedProductDto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductDto with id " + id + " does not exist."));

        retrievedProductDto.setName(product.name());
        retrievedProductDto.setPrice(product.price());

        var updatedProductDto = productRepository.save(retrievedProductDto);

        return new ProductDto(id, updatedProductDto.getName(), updatedProductDto.getPrice());
    }

    public List<ProductDto> getAllProductDto() {

        var productsEntityList = productRepository.findAll();

        List<ProductDto> products = new ArrayList<ProductDto>();

        productsEntityList.forEach(productEntity -> {
            var product = new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
            products.add(product);
        });

        return products;
    }

    public Product getProductDtoById(Long id) {

        return productRepository.findById(id).orElseGet(null);
    }

    public void deleteById(Long id) {
        Product retrievedProductDto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductDto with id " + id + " does not exist."));

        productRepository.delete(retrievedProductDto);

    }

}
/*
*/