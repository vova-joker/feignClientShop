package com.example.warehouse.adapter;

import com.example.warehouse.entity.Product;
import com.example.warehouse.mapper.ProductMapper;
import com.example.warehouse.service.ProductService;
import feignClientDemo.front.dto.ProductPostDto;
import feignClientDemo.front.dto.ProductResultDto;
import feignClientDemo.front.dto.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductAdapterImpl implements ProductAdapter {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @Override
    public ProductResultDto getProduct(Long id) {
        return productMapper.mapProductToProductResultDto(productService.getProductById(id));
    }

    @Override
    public List<ProductResultDto> getAllProducts() {
        return productMapper.mapProductListToProductResultList(productService.getAllProducts());
    }

    @Override
    public ProductResultDto addProduct(ProductPostDto postDto) {
        Product product = productMapper.mapProductPostDtoToProduct(postDto);
        return productMapper.mapProductToProductResultDto(productService.addProduct(product));
    }

    @Override
    public ProductResultDto updateProduct(ProductUpdateDto updateDto) {
        Product product = productMapper.mapProductUpdateDtoToProduct(updateDto);
        return productMapper.mapProductToProductResultDto(productService.updateProduct(product));
    }

    @Override
    public String deleteProduct(Long id) {
        return productService.deleteProduct(id);
    }
}
