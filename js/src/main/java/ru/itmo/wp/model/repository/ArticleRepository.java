package ru.itmo.wp.model.repository;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAll();
    void save(Article article);
    Article find(long id);
    void swapHidden(long id, boolean hidden);
}
