package com.ism.Controllers;

import com.ism.data.entites.Article;
import com.ism.services.ArticleService;

public interface IArticleView extends IView<Article> {
    Article saisir(ArticleService articleService); 
}

