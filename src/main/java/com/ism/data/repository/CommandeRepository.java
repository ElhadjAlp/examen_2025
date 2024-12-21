package com.ism.data.repository;

import com.ism.data.entites.Commande;

import java.util.List;

public interface CommandeRepository {
    Commande selectById(int id);
    List<Commande> selectAll();
    void insert(Commande detail);
    void delete(int id); 

}

