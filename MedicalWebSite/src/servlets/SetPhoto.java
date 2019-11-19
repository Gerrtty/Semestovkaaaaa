package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;
import some_usefull_classes.Phone;

import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class SetPhoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        Logger.green_write("Post method from Upload Servlet");

        String login = req.getParameter("email");
        String password = req.getParameter("pass");
        String phone = req.getParameter("phone");

        Email email = new Email(login);
        Phone user_phone = new Phone(phone);

        InputStream inputStream = getInputStream(req);


        if(correctParams(password, req.getParameter("confirm_pass"), email, user_phone)) {

            UserDAO userDAO = new UserDAO();

            if(userDAO.getUserByLogin(email) != null) {
                Logger.red_write("This user is already exists!");
                resp.getWriter().write("User is already exists");
            }

            else {
                System.out.println("Creating");
                createUser(userDAO,
                           req.getParameter("firstName"),
                           req.getParameter("lastName"),
                           email,
                           new Password(password),
                           req.getParameter("sex"),
                           user_phone,
                           inputStream);

                Logger.green_write("User is created");
                resp.getWriter().write("");
                resp.sendRedirect("profile");
            }

        }

        else {
            resp.getWriter().write("Incorrect email or phone or passwords not matching");
        }

    }

    private InputStream getInputStream(HttpServletRequest request) {

        InputStream inputStream = null;

        // obtains the upload file part in this multipart request
        Part filePart = null;

        try {
            filePart = request.getPart("photo");

            if(filePart != null) {
                inputStream = filePart.getInputStream();
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        return inputStream;
    }

    private void createUser(UserDAO userDAO,
                            String firstName,
                            String lastName,
                            Email email,
                            Password password,
                            String gender,
                            Phone phone,
                            InputStream inputStream) {

        User user = new User(firstName, lastName, email, password.getPassword());

        // This fields is not mandatory, can be null
        user.setGender(gender);
        user.setPhone(phone);
        user.setPhoto(inputStream);
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(inputStream);

        userDAO.add(user);

        Logger.green_write("User is created");
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