package servlets;

import DAO.UserDAO;
import ORM.User;

import com.sun.deploy.net.HttpResponse;
import freemarker.cache.FileTemplateLoader;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("registration.jsp");
        view.forward(req, resp);
        Logger.green_write("Get method from Registration Servlet is called");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from Registration servlet is called");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("email");
        String password = req.getParameter("pass");
        String confirm_password = req.getParameter("confirm_pass");
        String gender = req.getParameter("sex");

        Email email = new Email(login);

        String s = "";


        if(!password.equals(confirm_password)) {
            Logger.red_write("Passwords not matching");
        }

        if(!email.isCorrect()) {
            Logger.red_write("Email is not correct!");
            s = "Email is not correct!";
        }

        else {
            UserDAO userDAO = new UserDAO();

            if(userDAO.getUserByLogin(email) != null) {
                Logger.green_write("This user is already exists!");
                resp.sendRedirect("registration");
            }

            else {
                User user = new User(firstName, lastName, email, new Password(password).getPassword());
                user.setGender(gender);
                userDAO.add(user);
                Logger.green_write("User is created and registrated");
            }

        }

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(s);
    }
}
