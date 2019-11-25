package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Logger;
import utills.Loader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edith")
public class EdithProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("edith.jsp").forward(req, resp);
        Logger.green_write("Get method from EdithProfileServlet Servlet is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from EdithProfileServlet Servlet is called");

        User user = (User) req.getSession().getAttribute("loginedUser");

        String fileName =  new Loader(user).load(req);
        String path = "images/user/" + fileName;

        user.setPath(path);

        UserDAO userDAO = new UserDAO(user);
        userDAO.setPath();

        req.getSession().setAttribute("loginedUser", user);

        User u = (User) req.getSession().getAttribute("loginedUser");
        System.out.println(u.getPath());

        resp.sendRedirect("/profile");
    }
}
