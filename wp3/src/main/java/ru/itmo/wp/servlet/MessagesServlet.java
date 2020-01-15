package ru.itmo.wp.servlet;


import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class MessagesServlet extends HttpServlet {
    Gson gson = new Gson();
    List<Message> messages = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] uri = request.getRequestURI().split("/");
        response.setContentType("application/json");
        String json;
        switch (uri[2]) {
            case "auth": {
                json = auth(request);
                break;
            }
            case "findAll": {
                json = gson.toJson(messages);
                break;
            }
            case "add": {
                json = add(request);
                break;
            }
            default: {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        }
        response.getWriter().print(json);
        response.getWriter().flush();
    }

    private String auth(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return gson.toJson(request.getSession().getAttribute("user"));
        }
        String userName = request.getParameter("user");
        if (userName != null) {
            request.getSession().setAttribute("user", userName);
        } else {
            userName = "";
        }
        return gson.toJson(userName);
    }

    private String add(HttpServletRequest request) {
        Message added = new Message((String) request.getSession().getAttribute("user"), request.getParameter("text"));
        messages.add(added);
        return "";
    }

    private class Message {
        private String user;
        private String text;

        Message(String user, String text) {
            this.user = user;
            this.text = text;
        }
    }


}
