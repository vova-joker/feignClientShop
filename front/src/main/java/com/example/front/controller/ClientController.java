package com.example.front.controller;

import com.example.front.mapper.ClientMapper;
import com.example.front.service.ClientService;
import feignClientDemo.front.api.SimpleApi;
import feignClientDemo.front.dto.ClientGetResultDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"client"})
@RequiredArgsConstructor
public class ClientController implements SimpleApi {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @Override
    public ResponseEntity<ClientGetResultDto> getById(Long id) {
        return ResponseEntity.ok(clientMapper.mapClientToClientGetResultDto(clientService.getClientById(id)));
    }
}
