package com.example.warehouse.adapter;

import feignClientDemo.front.dto.ProductPostDto;
import feignClientDemo.front.dto.ProductResultDto;
import feignClientDemo.front.dto.ProductUpdateDto;

import java.util.List;

public interface ProductAdapter {

    ProductResultDto getProduct(Long id);

    List<ProductResultDto> getAllProducts();

    ProductResultDto addProduct(ProductPostDto postDto);

    ProductResultDto updateProduct(ProductUpdateDto updateDto);

    String deleteProduct(Long id);
}
