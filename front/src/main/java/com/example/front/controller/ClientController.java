package com.example.front.controller;

import com.example.front.adapter.ClientAdapterToDto;
import com.example.front.mapper.ClientMapper;
import com.example.front.service.ClientService;
import feignClientDemo.front.api.SimpleApi;
import feignClientDemo.front.dto.*;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"client"})
@RequiredArgsConstructor
public class ClientController implements SimpleApi {

    private final ClientAdapterToDto clientAdapterToDto;

    @Override
    public ResponseEntity<ClientPostResultDto> addClient(ClientPostDto clientPostDto) {
        return ResponseEntity.ok(clientAdapterToDto.addClient(clientPostDto));
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        return ResponseEntity.ok(clientAdapterToDto.deleteClient(id));
    }

    @Override
    public ResponseEntity<List<ClientGetResultDto>> getAll() {
        return ResponseEntity.ok(clientAdapterToDto.getAllClients());
    }

    @Override
    public ResponseEntity<ClientGetResultDto> getById(Long id) {
        return ResponseEntity.ok(clientAdapterToDto.getClient(id));
    }

    @Override
    public ResponseEntity<ClientUpdateResultDto> updateClient(ClientUpdateDto clientUpdateDto) {
        return ResponseEntity.ok(clientAdapterToDto.updateClient(clientUpdateDto));
    }
}
