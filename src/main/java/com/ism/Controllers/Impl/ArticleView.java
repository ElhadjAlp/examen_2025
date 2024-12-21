package com.ism.Controllers.Impl;

import java.util.List;

import com.ism.Controllers.IArticleView;
import com.ism.data.entites.Article;
import com.ism.services.ArticleService;

public class ArticleView extends View<Article> implements IArticleView {

    @Override
    public Article saisir(ArticleService articleService) {
        Article article = new Article();
        System.out.print("Entrez le libellé : ");
        article.setLibelle(scanner.nextLine());
        System.out.print("Entrez la quantité en stock : ");
        article.setQuantite(scanner.nextInt());
        System.out.print("Entrez le prix : ");
        article.setPrix(scanner.nextDouble());
        scanner.nextLine();
        return article;
    }

    @Override
    public void afficher(List<Article> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'afficher'");
    }
}
