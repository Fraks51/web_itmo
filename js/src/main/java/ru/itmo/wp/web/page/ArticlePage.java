package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ArticlePage {
    private final ArticleService articleService = new ArticleService();

    private void createArticle(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setText(request.getParameter("text"));
        article.setHidden(false);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            throw new ValidationException("User not login");
        article.setUserId(user.getId());
        articleService.create(article);
        request.getSession().setAttribute("message", article.getTitle() + " has been created");

        throw new RedirectException("/index");
    }

    private void action(HttpServletRequest request, Map<String, Object> view) {
        // No operations.
    }
}
