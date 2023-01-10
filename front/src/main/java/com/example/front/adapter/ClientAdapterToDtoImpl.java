package com.example.front.adapter;

import com.example.front.entity.Client;
import com.example.front.mapper.ClientMapper;
import com.example.front.service.ClientService;
import feignClientDemo.front.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientAdapterToDtoImpl implements ClientAdapterToDto{

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @Override
    public ClientGetResultDto getClient(Long id) {
        Client client = clientService.getClientById(id);
        ClientGetResultDto clientGetResultDto = clientMapper.mapClientToClientGetResultDto(client);
        return clientGetResultDto;
    }

    @Override
    public List<ClientGetResultDto> getAllClients() {
        List<Client> clientList = clientService.getAllClient();
        List<ClientGetResultDto> clientGetResultDtoList = clientMapper.mapClientsToListOfClientGetResultDto(clientList);
        return clientGetResultDtoList;
    }

    @Override
    public ClientPostResultDto addClient(ClientPostDto clientPostDto) {
        Client client = clientMapper.mapClientPostDtoToClient(clientPostDto);
        Client client1 = clientService.addClient(client);
        return clientMapper.mapClientToClientPostResultDto(client1);
    }

    @Override
    public ClientUpdateResultDto updateClient(ClientUpdateDto clientUpdateDto) {
        Client client = clientMapper.mapClientUpdateDtoToClient(clientUpdateDto);
        Client client1 = clientService.updateClient(client);
        return clientMapper.mapClientToClientUpdateResultDto(client1);
    }

    @Override
    public String deleteClient(Long id) {
        return clientService.deleteClient(id);
    }
}
