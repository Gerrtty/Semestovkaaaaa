package servlets;

import DAO.UserDAO;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;
import some_usefull_classes.Phone;
import utills.AppUtils;
import utills.ImgUtil;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetPhotoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Logger.green_write("SetPhotoServlet get method is called");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        Email email = new Email(req.getParameter("email"));
        System.out.println(email.getEmail());
        String s = "Ok";
        System.out.println(email.getEmail() == null);
        if (email.getEmail() == null) {
            s = "not ok";
        }
//        if(email == null) {
//            s = "not ok";
//        }
//        else if(!email.isCorrect() ) {
//            s = "not ok";
//        }

        response.getWriter().write(s);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Logger.green_write("Post method from Upload Servlet");

        String login = req.getParameter("email");
        String password = req.getParameter("pass");
        String phone = req.getParameter("phone");

        Email email = new Email(login);
        Phone user_phone = new Phone(phone);

        InputStream inputStream = new ImgUtil().getInputStream(req);

        if(correctParams(password, req.getParameter("confirm_pass"), email, user_phone)) {

            UserDAO userDAO = new UserDAO();

            if(userDAO.getUserByLogin(email) != null) {
                Logger.red_write("This user is already exists!");
                resp.getWriter().write("User is already exists");
            }

            else {
                System.out.println("Creating");
                new AppUtils().createUser(userDAO,
                           req.getParameter("firstName"),
                           req.getParameter("lastName"),
                           email,
                           new Password(password),
                           req.getParameter("sex"),
                           user_phone,
                           inputStream);

                Logger.green_write("User is created");
                resp.sendRedirect("profile");
            }

        }

        else {
//            resp.getWriter().write("Incorrect email or phone or passwords not matching");
            doGet(req, resp);
        }

    }




    private boolean correctParams(String password,
                                  String confirm_password,
                                  Email email,
                                  Phone phone) {

        if(!password.equals(confirm_password) || !email.isCorrect() || !phone.isCorrect()) {
            if(!password.equals(confirm_password)) {
                Logger.red_write("Passwords not matching");
            }

            if(!email.isCorrect()) {
                Logger.red_write("Email is not correct!");
            }

            if(!phone.isCorrect()) {
                Logger.red_write("Phone is not correct!");
            }

            return false;
        }

        return true;
    }

}