package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.ConnectionToDataBase;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("authorization.jsp");
        view.forward(req, resp);
        Logger.green_write("Get method from Authorization Servlet is called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        Logger.green_write(login);
        Logger.green_write(password);

        User user = new UserDAO().getUserByLogin(new Email(login));


        if(user == null) {
            Logger.red_write("User is not exists");
        }

        else {
            Logger.green_write("User is exists");

            if(user.getPassword().equals(new Password(password).getPassword())) {
                Logger.green_write("Right password!");
            }
            else {
                Logger.red_write("Wrong password!");
            }
        }
    }
}
