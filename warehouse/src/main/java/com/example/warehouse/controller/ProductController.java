package com.example.warehouse.controller;

import com.example.warehouse.adapter.ProductAdapter;
import feignClientDemo.front.api.WhApi;
import feignClientDemo.front.dto.ProductPostDto;
import feignClientDemo.front.dto.ProductResultDto;
import feignClientDemo.front.dto.ProductUpdateDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"product"})
@RequiredArgsConstructor
public class ProductController implements WhApi {

    private final ProductAdapter productAdapter;
    @Override
    public ResponseEntity<ProductResultDto> addProduct(ProductPostDto productPostDto) {
        return ResponseEntity.ok(productAdapter.addProduct(productPostDto));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        return ResponseEntity.ok(productAdapter.deleteProduct(id));
    }

    @Override
    public ResponseEntity<List<ProductResultDto>> getAllProducts() {
        return ResponseEntity.ok(productAdapter.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductResultDto> getProductById(Long id) {
        return ResponseEntity.ok(productAdapter.getProduct(id));
    }

    @Override
    public ResponseEntity<ProductResultDto> updateProduct(ProductUpdateDto productUpdateDto) {
        return ResponseEntity.ok(productAdapter.updateProduct(productUpdateDto));
    }
}
