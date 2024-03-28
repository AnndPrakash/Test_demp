package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}