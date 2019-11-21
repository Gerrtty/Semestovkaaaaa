package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;
import some_usefull_classes.Phone;
import utills.AppUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SetPhotoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Logger.green_write("SetPhotoServlet get method is called");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Logger.green_write("Post method from Upload Servlet");

        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String pass = req.getParameter("pass");
        String confirm_pass = req.getParameter("confirm_pass");
        String phone = req.getParameter("phone");

        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(pass);
        System.out.println(confirm_pass);
        System.out.println(phone);

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
                System.out.println("Creating");
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

//        InputStream inputStream = new ImgUtil().getInputStream(req);

    }

}