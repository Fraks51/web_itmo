package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MyArticlesPage {
    private final ArticleService articleService = new ArticleService();

    private void action(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        List<Article> articleList = articleService.findAll();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            throw new ValidationException("User not login");
        long id = user.getId();
        articleList.removeIf(article -> article.getUserId() != id);
        view.put("articles", articleList);
    }

    private void change(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        long id = Long.parseLong(request.getParameter("id"));
        boolean hidden = Boolean.parseBoolean(request.getParameter("hidden"));
        articleService.changeHidden(id, hidden);
    }
}
