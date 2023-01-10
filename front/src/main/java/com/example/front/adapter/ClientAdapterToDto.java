package com.example.front.adapter;

import com.example.front.entity.Client;
import feignClientDemo.front.dto.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface ClientAdapterToDto {
    ClientGetResultDto getClient(Long id);
    List<ClientGetResultDto> getAllClients();

    ClientPostResultDto addClient(ClientPostDto client);
    ClientUpdateResultDto updateClient(ClientUpdateDto Client);
    String deleteClient(Long id);
}
