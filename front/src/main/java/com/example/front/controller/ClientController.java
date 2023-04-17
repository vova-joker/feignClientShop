package com.example.front.controller;

import com.example.front.service.ClientService;
import feignClientShop.front.api.ClientApi;
import feignClientShop.front.dto.*;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(tags = {"client"})
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientPostResultDto> addClient(ClientPostDto clientPostDto) {
        return ResponseEntity.ok(clientService.addClient(clientPostDto));
    }


    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        return ResponseEntity.ok(clientService.deleteClient(id));
    }

    @Override
    public ResponseEntity<List<ClientGetResultDto>> getAll() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Override
    public ResponseEntity<ClientGetResultDto> getById(Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @Override
    public ResponseEntity<ClientUpdateResultDto> updateClient(ClientUpdateDto clientUpdateDto) {
        return ResponseEntity.ok(clientService.updateClient(clientUpdateDto));
    }
}
