package com.example.front.controller;


import com.example.front.service.StoreService;
import feignClientShop.front.api.StoreApi;
import feignClientShop.front.dto.ProductResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreController implements StoreApi {

    private final StoreService storeService;
    @Override
    public ResponseEntity<List<ProductResultDto>> getAll() {
        return ResponseEntity.ok(storeService.getAllProducts());
    }


}