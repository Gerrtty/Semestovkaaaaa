package servlets;

import DAO.AnswerDAO;
import DAO.ThemeDAO;
import ORM.Answer;
import ORM.Theme;
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

@WebServlet("/theme")
public class ThemeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ThemeServlet servlet is called");

        int id = Integer.parseInt(req.getParameter("theme_id"));

        Theme theme = new ThemeDAO().get(id);

        List<Answer> answers = new AnswerDAO().getAll(id);

        ServletContext servletContext = getServletContext();
        Configuration cfg = new FreeMarker().getCfg(servletContext);

        cfg.setServletContextForTemplateLoading(servletContext,"/WEB-INF/templates");

        Map root = new HashMap();

        root.put("answers", answers);
        root.put("theme", theme);

        Template t = cfg.getTemplate("theme.ftlh");
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
