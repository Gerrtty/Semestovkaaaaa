package servlets;

import DAO.UserDAO;
import ORM.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user_profile.ftlh").forward(req, resp);
        Logger.green_write("Get method from UserProfile Servlet is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void showInfo() {
        UserDAO userDAO = new UserDAO();
        User user =  userDAO.getUserByLogin(new Email(""));


//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//
//        ServletContext servletContext = getServletContext();
//        cfg.setServletContextForTemplateLoading(servletContext,"");
//
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setLogTemplateExceptions(false);
//        cfg.setWrapUncheckedExceptions(true);
//
//        // модель
//        Map root = new HashMap();
//        root.put("head", "The header");
//        List items = new ArrayList<Integer>();
//        for (int i=0; i<5; i++) {
//            items.add(Math.random());
//        }
//        root.put("items", items);
//
//        // соединяем модель и шаблон
//        Template t = cfg.getTemplate("t.ftlh");
//        try {
//            t.process(root, .getWriter());
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
    }
}
