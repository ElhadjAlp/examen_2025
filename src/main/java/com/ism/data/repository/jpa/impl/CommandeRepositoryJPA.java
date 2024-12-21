package com.ism.data.repository.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ism.core.Repository.impl.RepositoryJPAImp;
import com.ism.data.entites.Commande;
import com.ism.data.repository.CommandeRepository;




public class CommandeRepositoryJPA extends RepositoryJPAImp<Commande> implements CommandeRepository {
    @PersistenceContext
    private  EntityManager entityManager;

    public CommandeRepositoryJPA() {
        super(Commande.class);
    }

    @Override
    public Commande selectById(int id) {
        return entityManager.find(Commande.class, id);
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Commande detail = entityManager.find(Commande.class, id);
            if (detail != null) {
                entityManager.remove(detail);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}

