package com.ism.core.factory;

import com.ism.services.ArticleService;
import com.ism.services.ClientService;
import com.ism.services.CommandeService;





public interface FactoryService {
    ClientService getInstanceClientService();
    ArticleService getInstanceArticleService();
    CommandeService getInstanceCommandeService();

}



