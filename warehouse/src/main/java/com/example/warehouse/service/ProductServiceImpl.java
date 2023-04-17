package com.example.warehouse.service;

import com.example.warehouse.entity.Product;
import com.example.warehouse.mapper.ProductMapper;
import com.example.warehouse.repository.ProductRepository;
import feignClientShop.front.dto.ProductPostDto;
import feignClientShop.front.dto.ProductResultDto;
import feignClientShop.front.dto.ProductUpdateDto;
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

    private final ProductMapper productMapper;
    @Override
    public ProductResultDto getProductById(Long id) {
        return productMapper.mapProductToProductResultDto(
                productRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Product with id = "+ id + " is not found")
                )
        );
    }

    @Override
    public List<ProductResultDto> getAllProducts() {
        return productMapper.mapProductListToProductResultList(productRepository.findAll());
    }

    @Override
    public ProductResultDto addProduct(ProductPostDto productPostDto) {
        return productMapper.mapProductToProductResultDto(
                productRepository.saveAndFlush(
                        productMapper.mapProductPostDtoToProduct(productPostDto)
                )
        );
    }

    @Override
    public ProductResultDto updateProduct(ProductUpdateDto productUpdateDto) {
        return productMapper.mapProductToProductResultDto(
                productRepository.saveAndFlush(
                        productMapper.mapProductUpdateDtoToProduct(productUpdateDto)
                )
        );
    }

    @Override
    public String deleteProduct(Long id) {
        ProductResultDto productResultDto = getProductById(id);
        if(productResultDto != null)
            productRepository.delete(productMapper.mapProductResultDtoToProduct(productResultDto));
        else return "Product with id = "+id+" was not found!";
        return "Product with name " + productResultDto.getName() + " was successfully deleted!";
    }
}
