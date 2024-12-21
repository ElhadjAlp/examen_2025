package com.ism.core.factory;

import com.ism.Controllers.Impl.ArticleView;
import com.ism.Controllers.Impl.ClientView;


public interface FactoryView {
    ClientView getInstanceClientView();
    ArticleView getInstanceArticleView();
    ClientView getInstanceCommandeView(); 

}

