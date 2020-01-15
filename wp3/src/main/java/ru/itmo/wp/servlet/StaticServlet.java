package ru.itmo.wp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StaticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] filesUri = request.getRequestURI().split("\\+");
        ArrayList<File> files = new ArrayList<>();
        boolean allUriCorrect = true;
        for (int i = 0; i < filesUri.length; i++) {
            if (filesUri[i].charAt(0) != '/') {
                filesUri[i] = "/" + filesUri[i];
            }
            File file = findUri(filesUri[i]);
            if (file.isFile()) {
                files.add(file);
            } else {
                allUriCorrect = false;
                break;
            }
        }
        if (allUriCorrect) {
            response.setContentType(getContentTypeFromName(filesUri[0]));
            OutputStream outputStream = response.getOutputStream();
            for (File file : files) {
                Files.copy(file.toPath(), outputStream);
            }
            outputStream.flush();
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private File findUri (String uri) {
        File file = new File(getServletContext().getRealPath("."), Paths.get("../../src/main/webapp/static", uri).toString());
        if (!file.isFile()) {
            file = new File(getServletContext().getRealPath("/static" + uri));
        }
        return file;
    }

    private String getContentTypeFromName(String name) {
        name = name.toLowerCase();

        if (name.endsWith(".png")) {
            return "image/png";
        }

        if (name.endsWith(".jpg")) {
            return "image/jpeg";
        }

        if (name.endsWith(".html")) {
            return "text/html";
        }

        if (name.endsWith(".css")) {
            return "text/css";
        }

        if (name.endsWith(".js")) {
            return "application/javascript";
        }

        throw new IllegalArgumentException("Can't find content type for '" + name + "'.");
    }
}
