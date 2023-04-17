package com.example.front.service;

import com.example.front.feignClient.WarehouseFeignClient;
import feignClientShop.front.dto.ProductResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final WarehouseFeignClient warehouseFeignClient;

    @Override
    public List<ProductResultDto> getAllProducts() {
        return warehouseFeignClient.getAllProducts().getBody();
    }

    @Override
    public ProductResultDto getProductById(Long id) {
        return warehouseFeignClient.getProductById(id).getBody();
    }
}
