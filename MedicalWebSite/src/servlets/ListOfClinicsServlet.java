package servlets;

import DAO.BuildingDAO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import some_usefull_classes.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@WebServlet("/listOfClinics")
public class ListOfClinicsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ListOfClinicsServlet servlet is called");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        ServletContext servletContext = getServletContext();
        cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

        // дальше всё так же
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        Map root = new HashMap();
        root.put("head", "List of clinics");

        BuildingDAO buildingDAO = new BuildingDAO();
        List buildings = buildingDAO.getAll();

        root.put("buildings", buildings);

        // соединяем модель и шаблон
        Template t = cfg.getTemplate("listOfClinics.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from ListOfClinicsServlet servlet is called");
    }
}
