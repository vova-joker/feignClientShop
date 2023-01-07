package com.example.front.mapper;

import com.example.front.entity.Client;
import feignClientDemo.front.dto.ClientGetResultDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientGetResultDto mapClientToClientGetResultDto(Client client);
}
