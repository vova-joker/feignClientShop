package com.example.warehouse.service;

import com.example.warehouse.entity.Product;
import feignClientShop.front.dto.ProductPostDto;
import feignClientShop.front.dto.ProductResultDto;
import feignClientShop.front.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {

    ProductResultDto getProductById(Long id);

    List<ProductResultDto> getAllProducts();

    ProductResultDto addProduct(ProductPostDto productPostDto);

    ProductResultDto updateProduct(ProductUpdateDto productUpdateDto);

    String deleteProduct(Long id);
}
