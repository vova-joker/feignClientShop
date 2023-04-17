package com.example.front.feignClient;


import feignClientShop.front.api.WarehouseApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "${warehouse-app-name}",
        url = "${warehouse-url}"
)
public interface WarehouseFeignClient extends WarehouseApi {
}
