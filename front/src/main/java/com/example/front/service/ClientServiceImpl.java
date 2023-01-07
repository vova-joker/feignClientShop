package com.example.front.service;

import com.example.front.entity.Client;
import com.example.front.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public String deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
        return "Client with name " + client.getName() + " was successfully deleted!";
    }
}
