package com.ism.core.factory.impl;

import com.ism.core.factory.FactoryRepository;
import com.ism.data.repository.ArticleRepository;
import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.CommandeRepository;
import com.ism.data.repository.jpa.impl.ArticleRepositoryJPA;
import com.ism.data.repository.jpa.impl.ClientRepositoryJPA;
import com.ism.data.repository.jpa.impl.CommandeRepositoryJPA;


public class FactoryRepositoryImpl implements FactoryRepository {
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private CommandeRepository detailRepository;


    @Override
    public ClientRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryJPA();
        }
        return clientRepository;
    }

  

    @Override
    public ArticleRepository getInstanceArticleRepository() {
        if (articleRepository == null) {
            articleRepository = new ArticleRepositoryJPA();
        }
        return articleRepository;
    }

  

    @Override
    public CommandeRepository getInstanceDetailRepository() {
        if (detailRepository == null) {
            detailRepository = new CommandeRepositoryJPA(); 
        }
        return detailRepository;
    }
}


