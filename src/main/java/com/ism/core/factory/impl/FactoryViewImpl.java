package com.ism.core.factory.impl;

import com.ism.Controllers.Impl.ArticleView;
import com.ism.Controllers.Impl.ClientView;
import com.ism.core.factory.FactoryService;
import com.ism.core.factory.FactoryView;


public class FactoryViewImpl implements FactoryView {
    private ClientView clientView;
    private ArticleView articleView;
    private final FactoryService factoryServiceImpl;

    public FactoryViewImpl(FactoryService factoryServiceImpl) {
        this.factoryServiceImpl = factoryServiceImpl;
    }

    @Override
    public ClientView getInstanceClientView() {
        if (clientView == null) {
            clientView = new ClientView();
        }
        return clientView;
    }

    

    @Override
    public ArticleView getInstanceArticleView() {
        if (articleView == null) {
            articleView = new ArticleView();
        }
        return articleView; 
    }

    @Override
    public ClientView getInstanceCommandeView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceCommandeView'");
    }


  

    }

