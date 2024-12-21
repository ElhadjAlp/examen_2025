package com.ism.core.factory;

import com.ism.data.repository.ArticleRepository;
import com.ism.data.repository.ClientRepository;
import com.ism.data.repository.CommandeRepository; 

public interface FactoryRepository {
    ClientRepository getInstanceClientRepository();
    ArticleRepository getInstanceArticleRepository();
    CommandeRepository getInstanceDetailRepository();
}


