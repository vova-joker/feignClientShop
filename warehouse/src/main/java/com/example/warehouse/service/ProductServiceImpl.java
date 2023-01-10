package com.example.warehouse.service;

import com.example.warehouse.entity.Product;
import com.example.warehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product getProductById(Long id) {
        System.out.println("Before optional");
        Optional<Product> optionalProduct = productRepository.findById(id);
        System.out.println("After optional");
        return optionalProduct.orElseThrow(() -> new RuntimeException("Product with id = "+ id + " is not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = getProductById(id);
        String name = product.getName();
        productRepository.delete(product);
        return "Product with id = " + id + " and name = " + name + " was successfully deleted!";
    }
}
