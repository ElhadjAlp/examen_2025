package com.ism.services;

import java.util.List;

import com.ism.data.entites.Client;

public interface ClientService {
    void createClient(Client client);

    List<Client> findAllClient();
    Client searchClient(String telephone);
    Client findById(int clientId);
    Client findById(List<Client> clients, int clientId);

    Client findOrCreateClient(String telephone, String string, String string2, String string3);
}
