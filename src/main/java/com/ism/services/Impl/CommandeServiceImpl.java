package com.ism.services.Impl;

import com.ism.data.entites.Article;
import com.ism.data.entites.Client;
import com.ism.data.entites.Commande;
import com.ism.data.repository.CommandeRepository;
import com.ism.services.CommandeService;

import java.util.List;

public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository detailRepository;

    public CommandeServiceImpl(CommandeRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public Commande getDetailById(int id) {
        return detailRepository.selectById(id);
    }

    @Override
    public List<Commande> getAllDetails() {
        return detailRepository.selectAll();
    }

    @Override
    public void addDetail(Commande detail) {
        detailRepository.insert(detail);
    }

    @Override
    public void removeDetail(int id) {
        detailRepository.delete(id);
    }

    @Override
    public void saveCommande(Commande commande) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCommande'");
    }

    @Override
    public Article getAllArticles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllArticles'");
    }

    @Override
    public void addLigneCommande(Commande commande, Article article, int quantite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLigneCommande'");
    }

    @Override
    public Object findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void createCommande(Client saisir) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCommande'");
    }
}

