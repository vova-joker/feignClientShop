package com.example.front.service;

import feignClientShop.front.dto.*;
import java.util.List;

public interface ClientService {
    ClientGetResultDto getClientById(Long id);
    List<ClientGetResultDto> getAllClients();
    ClientPostResultDto addClient(ClientPostDto clientPostDto);
    ClientUpdateResultDto updateClient(ClientUpdateDto clientUpdateDto);
    String deleteClient(Long id);
}
