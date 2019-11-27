package servlets;

import DAO.ServiceBuildingDAO;
import ORM.Building;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import some_usefull_classes.Logger;
import utills.FreeMarker;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/services")
public class ServicesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ServicesServlet servlet is called");

        Building building = (Building) req.getSession().getAttribute("building");


        ServletContext servletContext = getServletContext();
        Configuration cfg = new FreeMarker().getCfg(servletContext);

        cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

        Map root = new HashMap();

        List services = new ServiceBuildingDAO().getAllyBuildingID(building);

        root.put("services", services);
        root.put("building", building);

        Template t = cfg.getTemplate("services.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
