package servlets;

import DAO.ThemeDAO;
import ORM.Theme;
import ORM.User;
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

@WebServlet("/forum_main")
public class ForumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ForumServlet servlet is called");

        if(req.getSession().getAttribute("loginedUser") == null) {
            resp.getWriter().write("User is not auth");
            resp.sendRedirect("/authorization");
        }
        else {

            List<Theme> themes = new ThemeDAO().getAll();

            ServletContext servletContext = getServletContext();
            Configuration cfg = new FreeMarker().getCfg(servletContext);

            cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

            Map root = new HashMap();

            root.put("themes", themes);

            Template t = cfg.getTemplate("forum.ftlh");
            try {
                t.process(root, resp.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from ForumServlet servlet is called");

    }
}
