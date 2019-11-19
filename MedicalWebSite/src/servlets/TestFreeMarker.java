package servlets;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import freemarker.template.Configuration;

import freemarker.template.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class TestFreeMarker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        // изменить в коде примера: нам нужно получать путь из ServletContext
        ServletContext servletContext = getServletContext();
        cfg.setServletContextForTemplateLoading(servletContext,"");

        // дальше всё так же
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        // модель
        Map root = new HashMap();
        root.put("head", "The header");
        List items = new ArrayList<Integer>();
        for (int i=0; i<5; i++) {
            items.add(Math.random());
        }
        root.put("items", items);

        // соединяем модель и шаблон
        Template t = cfg.getTemplate("t.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
