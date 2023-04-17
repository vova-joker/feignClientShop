package com.example.front.service;


import feignClientShop.front.dto.ProductResultDto;

import java.util.List;

public interface StoreService {

    List<ProductResultDto> getAllProducts();

    ProductResultDto getProductById(Long id);
}
