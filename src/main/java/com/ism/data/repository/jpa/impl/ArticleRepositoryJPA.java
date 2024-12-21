package com.ism.data.repository.jpa.impl;

import com.ism.core.Repository.impl.RepositoryJPAImp;
import com.ism.data.entites.Article;
import com.ism.data.repository.ArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class ArticleRepositoryJPA extends RepositoryJPAImp<Article> implements ArticleRepository {

    @PersistenceContext
    private EntityManager em; // Déclarez et injectez l'EntityManager

    public ArticleRepositoryJPA() {
        super(Article.class); 
    }

    @Override
    public Article selectById(int id) {
        // Utilisez em (EntityManager) pour trouver l'article
        return em.find(Article.class, id);
    }

    @Override
    public Article findByArticle(Article article) {
        // Créez une requête JPQL pour trouver l'article par libelle
        TypedQuery<Article> query = em.createQuery(
                "SELECT a FROM Article a WHERE a.libelle = :libelle", Article.class);
        query.setParameter("libelle", article.getLibelle());

        return query.getResultStream()
                .findFirst()
                .orElse(null);
    }
}
