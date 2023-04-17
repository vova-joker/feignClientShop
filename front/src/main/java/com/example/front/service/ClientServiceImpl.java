package com.example.front.service;

import com.example.front.mapper.ClientMapper;
import com.example.front.repository.ClientRepository;
import feignClientShop.front.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Override
    public ClientGetResultDto getClientById(Long id) {
        return clientMapper.mapClientToClientGetResultDto(
                clientRepository.findById(id).orElseThrow(
                        () -> new RuntimeException(
                                "Client with id = "+ id +" is not found"
                        )
                )
        );
    }

    @Override
    public List<ClientGetResultDto> getAllClients() {
        return clientMapper.mapClientsToListOfClientGetResultDto(
                clientRepository.findAll()
        );
    }

    @Override
    public ClientPostResultDto addClient(ClientPostDto clientPostDto) {
        return clientMapper.mapClientToClientPostResultDto(
                clientRepository.saveAndFlush(
                        clientMapper.mapClientPostDtoToClient(
                                clientPostDto
                        )
                )
        );
    }

    @Override
    public ClientUpdateResultDto updateClient(ClientUpdateDto clientUpdateDto) {
        return clientMapper.mapClientToClientUpdateResultDto(
                clientRepository.saveAndFlush(
                        clientMapper.mapClientUpdateDtoToClient(clientUpdateDto
                        )
                )
        );
    }

    @Override
    public String deleteClient(Long id) {
        ClientGetResultDto clientGetResultDto = getClientById(id);
        if(clientGetResultDto != null)
            clientRepository.delete(clientMapper.mapClientGetResultDtoToClient(getClientById(id)));
        else return "Client with id = "+id+" was not found!";
        return "Client with name " + clientGetResultDto.getName() + " was successfully deleted!";
    }
}
