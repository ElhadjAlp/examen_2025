package com.ism.data.repository.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ism.core.Repository.impl.RepositoryJPAImp;
import com.ism.data.entites.Client;
import com.ism.data.repository.ClientRepository;

public class ClientRepositoryJPA extends RepositoryJPAImp<Client> implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ClientRepositoryJPA() {
        super(Client.class);
    }

    // Recherche d'un client par son téléphone
    @Override
    public Client selectByTelephone(String telephone) {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT c FROM Client c WHERE c.telephone = :telephone", Client.class);
        query.setParameter("telephone", telephone);
        return query.getResultStream().findFirst().orElse(null);
    }

    // Recherche d'un client par son ID
    @Override
    public Client selectById(int clientId) {
        return entityManager.find(Client.class, clientId);
    }
}
