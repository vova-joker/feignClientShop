package com.example.warehouse.mapper;

import com.example.warehouse.entity.Product;
import feignClientDemo.front.dto.ProductPostDto;
import feignClientDemo.front.dto.ProductResultDto;
import feignClientDemo.front.dto.ProductUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResultDto mapProductToProductResultDto(Product product);

    Product mapProductUpdateDtoToProduct(ProductUpdateDto productUpdateDto);

    Product mapProductPostDtoToProduct(ProductPostDto productPostDto);

    List<ProductResultDto> mapProductListToProductResultList(List<Product> productList);
}
