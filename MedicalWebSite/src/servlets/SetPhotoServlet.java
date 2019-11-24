package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.*;
import utills.AppUtils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/uploadServlet")
public class SetPhotoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Logger.green_write("SetPhotoServlet get method is called");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Logger.green_write("Post method from SetPhotoServlet");

        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String confirm_pass = req.getParameter("confirm_pass");
        String phone = req.getParameter("phone");

        String errorString = "";

        Email login = new Email(email);
        Phone user_phone = new Phone(phone);

        if(!pass.equals(confirm_pass) || !login.isCorrect() || !user_phone.isCorrect()) {
            if(!pass.equals(confirm_pass)) {
                errorString += "passwords not matching ";
            }
            if(!login.isCorrect()) {
                errorString += "email is not correct ";
            }
            if(!user_phone.isCorrect()) {
                errorString += "phone is not correct";
            }
        }

        else {
            UserDAO userDAO = new UserDAO();

            if(userDAO.getUserByLogin(login) != null) {
                Logger.red_write("This user is already exists!");

                errorString += " User is already exists";
            }

            else {
                System.out.println("Creating user");

                User user = new AppUtils().createUser(userDAO,
                           req.getParameter("firstName"),
                           req.getParameter("lastName"),
                           login,
                           new Password(pass),
                           user_phone);

                Logger.green_write("User is created");

                errorString = "ok";

                HttpSession session = req.getSession();
                session.setAttribute("loginedUser", user);
            }
        }

        resp.getWriter().write(errorString);

    }

}