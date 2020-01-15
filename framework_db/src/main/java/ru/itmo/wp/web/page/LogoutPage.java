package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.web.exception.RedirectException;
import ru.itmo.wp.model.service.EventService;


import javax.servlet.http.HttpServletRequest;

/** @noinspection unused*/
public class LogoutPage extends Page {
    private final EventService eventService = new EventService();


    private void action(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Event event = new Event();
        event.setUserId(user.getId());
        eventService.logout(event);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("message", "Good bye. Hope to see you soon!");
        throw new RedirectException("/index");
    }
}
