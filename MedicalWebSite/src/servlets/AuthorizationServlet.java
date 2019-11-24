package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.*;
import utills.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("authorization.jsp").forward(req, resp);
        Logger.green_write("Get method from Authorization Servlet is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new UserDAO().getUserByLogin(new Email(login));

        if(user == null) {
            Logger.red_write("User is not exists");
            req.setAttribute("errorMessage", "Error");

            this.getServletContext().getRequestDispatcher("authorization.jsp").forward(req, resp);
            return;
        }

        else {

            if(user.getPassword().equals(new Password(password).getPassword())) {

                Logger.green_write("Right password!");

                AppUtils.storeLoginedUser(req.getSession(), user);

                AppUtils.auth(req, resp, user);

                req.getSession().setAttribute("loginedUser", user);

            }

            else {
                Logger.red_write("Wrong password!");
                resp.sendRedirect("/authorization");
            }
        }
    }
}
