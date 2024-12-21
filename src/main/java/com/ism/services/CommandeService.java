package com.ism.services;

import com.ism.data.entites.Article;
import com.ism.data.entites.Client;
import com.ism.data.entites.Commande;

import java.util.List;

public interface CommandeService {
    Commande getDetailById(int id);             
    List<Commande> getAllDetails();               
    void addDetail(Commande detail);              
    void removeDetail(int id);
    void saveCommande(Commande commande);
    Article getAllArticles();
    void addLigneCommande(Commande commande, Article article, int quantite);
    Object findAll();
    void createCommande(Client saisir);                  
}
 
