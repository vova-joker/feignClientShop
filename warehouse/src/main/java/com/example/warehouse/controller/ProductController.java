package com.example.warehouse.controller;



import com.example.warehouse.service.ProductService;
import feignClientShop.front.api.WarehouseApi;
import feignClientShop.front.dto.ProductPostDto;
import feignClientShop.front.dto.ProductResultDto;
import feignClientShop.front.dto.ProductUpdateDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@Api(tags = {"product"})
@RequiredArgsConstructor
public class ProductController implements WarehouseApi {

    private final ProductService productService;
    @Override
    public ResponseEntity<ProductResultDto> addProduct(ProductPostDto productPostDto) {
        return ResponseEntity.ok(productService.addProduct(productPostDto));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @Override
    public ResponseEntity<List<ProductResultDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductResultDto> getProductById(Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @Override
    public ResponseEntity<ProductResultDto> updateProduct(ProductUpdateDto productUpdateDto) {
        return ResponseEntity.ok(productService.updateProduct(productUpdateDto));
    }
}
