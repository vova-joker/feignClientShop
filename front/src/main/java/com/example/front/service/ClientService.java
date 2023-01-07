package com.example.front.service;


import com.example.front.entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id);
    List<Client> getAllClient();
    Client addClient(Client client);
    Client updateClient(Client client);
    String deleteClient(Long id);
}
