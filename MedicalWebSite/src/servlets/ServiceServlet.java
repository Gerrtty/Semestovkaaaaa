package servlets;

import DAO.ReviewDaO;
import DAO.ServiceBuildingDAO;
import ORM.Building;
import ORM.Service;
import ORM.ServiceBuildinng;
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

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ServiceServlet servlet is called");

        int id = Integer.parseInt(req.getParameter("id"));

        ServletContext servletContext = getServletContext();
        Configuration cfg = new FreeMarker().getCfg(servletContext);

        Building building = (Building) req.getSession().getAttribute("building");

        cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

        Map root = new HashMap();

        ServiceBuildinng serviceBuildinng = new ServiceBuildingDAO().getServiceBuilding(id);
        serviceBuildinng.setService_id(id);

        List reviews = new ReviewDaO().getAllByID(serviceBuildinng);

        req.getSession().setAttribute("serviceBuilding", serviceBuildinng);

        root.put("serviceBuilding", serviceBuildinng);

        root.put("building", building);

        root.put("reviews", reviews);

        Template t = cfg.getTemplate("service.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from ServiceServlet servlet is called");
    }
}
