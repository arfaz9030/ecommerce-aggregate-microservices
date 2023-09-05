package com.product.microservice.ecommerceproduct.controllers;

import com.product.microservice.ecommerceproduct.payloads.ProductDto;
import com.product.microservice.ecommerceproduct.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/product-service")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDto product) {

        productService.addProductDto(product);

    }

    @GetMapping("/product")
    public List<ProductDto> getAllProduct() {

        return productService.getAllProductDto();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {

        var updatedProduct = productService.updateProductDto(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {

        var productDetails = productService.getProductDtoById(id);

        if (productDetails != null) {

            var product = new ProductDto(id, productDetails.getName(), productDetails.getPrice());
            return ResponseEntity.ok(product);
        } else
            return new ResponseEntity<ProductDto>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBookById(@PathVariable Long id) {

        productService.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}

