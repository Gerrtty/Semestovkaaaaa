package servlets;

import DAO.ThemeDAO;
import ORM.Theme;
import ORM.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTheme")
public class AddTheme extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addTheme.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThemeDAO themeDAO = new ThemeDAO();

        User user = (User) req.getSession().getAttribute("loginedUser");

        Theme theme = new Theme();

        theme.setUser_id(user.getId());
        theme.setTitle(req.getParameter("title"));
        theme.setContent(req.getParameter("content"));

        themeDAO.add(theme);

        resp.sendRedirect("/forum_main");
    }
}
