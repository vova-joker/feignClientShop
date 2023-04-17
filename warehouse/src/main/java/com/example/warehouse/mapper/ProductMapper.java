package com.example.warehouse.mapper;

import com.example.warehouse.entity.Product;
import feignClientShop.front.dto.ProductPostDto;
import feignClientShop.front.dto.ProductResultDto;
import feignClientShop.front.dto.ProductUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResultDto mapProductToProductResultDto(Product product);

    Product mapProductResultDtoToProduct(ProductResultDto productResultDto);

    Product mapProductUpdateDtoToProduct(ProductUpdateDto productUpdateDto);

    Product mapProductPostDtoToProduct(ProductPostDto productPostDto);

    List<ProductResultDto> mapProductListToProductResultList(List<Product> productList);
}
