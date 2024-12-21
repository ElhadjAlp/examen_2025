package com.ism.services.Impl;


import java.util.List;

import com.ism.data.entites.Client;
import com.ism.data.repository.ClientRepository;
import com.ism.services.ClientService;

public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public void createClient(Client client) {
        clientRepository.insert(client);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.selectAll();
    }

    @Override
    public Client searchClient(String telephone) {
        return clientRepository.selectByTelephone(telephone);
    }

    @Override
    public Client findById(int clientId) {
        return clientRepository.selectById(clientId);
    }
    
    @Override
    public Client findById(List<Client> clients, int clientId) {
        return clients.stream().filter(cl -> cl.getId() == clientId).findFirst().orElse(null);
    }

    @Override
    public Client findOrCreateClient(String telephone, String string, String string2, String string3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOrCreateClient'");
    }
}