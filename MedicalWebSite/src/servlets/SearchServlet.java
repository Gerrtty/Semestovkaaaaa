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
import java.util.List;
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

        root.put("buildings", get((String) req.getAttribute("search")));

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

        String search = req.getParameter("search");

        req.setAttribute("search", search);

        doGet(req,resp);

//        SearchUtil searchUtil = new SearchUtil();
//        List buildings = searchUtil.getBuildingsByDescription(search);
    }


    public List get(String s) {
        return new SearchUtil().getBuildingsByDescription(s);
    }
}
