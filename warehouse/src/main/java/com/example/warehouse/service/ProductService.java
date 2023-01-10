package com.example.warehouse.service;

import com.example.warehouse.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product updateProduct(Product product);

    String deleteProduct(Long id);
}
