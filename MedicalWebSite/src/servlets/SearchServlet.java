package servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import some_usefull_classes.Logger;
import utills.FreeMarker;
import utills.SearchUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from SearchServlet Servlet is called");

        ServletContext servletContext = getServletContext();
        Configuration cfg = new FreeMarker().getCfg(servletContext);

        cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

        Map root = new HashMap();

        if(req.getAttribute("price") == null || ((String) req.getAttribute("price")).length() == 0) {
            root.put("buildings", new SearchUtil().getBuildingsByDescription(((String) req.getAttribute("search"))));
        }

        else {
            String par = (String) req.getAttribute("price");

            if(par.charAt(0) != '>' && par.charAt(0) != '<') {
                Logger.red_write("Error input");
                resp.sendRedirect("search");
            }

            else {
                root.put("buildings", new SearchUtil().getBuildingsByDescriptionWithPrice(
                        (String) req.getAttribute("search"), (String) req.getAttribute("price")));
            }
        }

        Template t = cfg.getTemplate("listOfClinics.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from SearchServlet Servlet is called");

        req.setAttribute("search", req.getParameter("search"));

        req.setAttribute("price", req.getParameter("price"));

        doGet(req,resp);

    }

}
