package com.ism.core.factory.impl;

import com.ism.core.factory.FactoryRepository;
import com.ism.core.factory.FactoryService;
import com.ism.services.ArticleService;
import com.ism.services.ClientService;
import com.ism.services.CommandeService;
import com.ism.services.Impl.ArticleServiceImpl;
import com.ism.services.Impl.ClientServiceImpl;
import com.ism.services.Impl.CommandeServiceImpl;


public class FactoryServiceImpl implements FactoryService {
    private ClientService clientService;
    private ArticleService articleService;
    private CommandeService detailService;
    private FactoryRepository factoryRepository;

    public FactoryServiceImpl(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Override
    public ClientService getInstanceClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImpl(factoryRepository.getInstanceClientRepository());
        }
        return clientService;
    }



    @Override
    public ArticleService getInstanceArticleService() {
        if (articleService == null) {
            articleService = new ArticleServiceImpl(factoryRepository.getInstanceArticleRepository());
        }
        return articleService;
    }

    @Override
    public CommandeService getInstanceCommandeService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceCommandeService'");
    }

}
