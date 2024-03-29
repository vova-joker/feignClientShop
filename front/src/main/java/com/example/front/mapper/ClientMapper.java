package com.example.front.mapper;

import com.example.front.entity.Client;
import feignClientShop.front.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientGetResultDto mapClientToClientGetResultDto(Client client);

    Client mapClientGetResultDtoToClient(ClientGetResultDto client);

    List<ClientGetResultDto> mapClientsToListOfClientGetResultDto(List<Client> clientList);

    ClientPostResultDto mapClientToClientPostResultDto(Client client);

    Client mapClientPostDtoToClient(ClientPostDto client);

    ClientUpdateResultDto mapClientToClientUpdateResultDto(Client client);

    Client mapClientUpdateDtoToClient(ClientUpdateDto client);


}
