package ru.itmo.wp.web.page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/** @noinspection unused*/
public class IndexPage {
    private void action(HttpServletRequest request, Map<String, Object> view) {
        view.put("name", "Mike");
    }
}
