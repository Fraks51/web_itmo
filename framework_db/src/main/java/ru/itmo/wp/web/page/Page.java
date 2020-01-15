package ru.itmo.wp.web.page;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Page {
    private final UserService userService = new UserService();
    private HttpServletRequest _request;

    private void setUser(Map<String, Object> view) {
        User user = (User) _request.getSession().getAttribute("user");
        if (user != null) {
            view.put("user", user);
        }
    }

    private User getUser() {
        return (User) _request.getSession().getAttribute("user");
    }

    private void setMessage(Map<String, Object> view) {
        String message = (String) _request.getSession().getAttribute("message");
        if (!Strings.isNullOrEmpty(message)) {
            view.put("message", message);
            _request.getSession().removeAttribute("message");
        }
    }

    private void action() {
        // No operations.
    }

    void before(HttpServletRequest request, Map<String, Object> view) {
        _request = request;
        view.put("userCount", userService.findCount());
        setUser(view);
        setMessage(view);
    }

    void after(HttpServletRequest request, Map<String, Object> view) {}

}
