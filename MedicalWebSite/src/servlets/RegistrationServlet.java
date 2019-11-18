package servlets;

import DAO.UserDAO;
import ORM.User;

import some_usefull_classes.Logger;
import some_usefull_classes.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    Logger logger = Logger.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("registration.jsp");
        view.forward(req, resp);
        logger.green_write("Get method is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.green_write("Post method is called");

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("email");
        String password = req.getParameter("pass");
        String confirm_password = req.getParameter("confirm_pass");
        String gender = req.getParameter("sex");

        User user = null;

        if(!password.equals(confirm_password)) {
            logger.red_wrie("Passwords not matching");
            resp.sendRedirect("registration");
        }

        else {
            user = new User(firstname, lastname, login, new Password(password));
            user.setGender(gender);
            logger.green_write("User is created");
            UserDAO.add(user);
        }


    }
}
