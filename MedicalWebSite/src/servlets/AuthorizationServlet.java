package servlets;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;
import utills.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            Logger.green_write("User is exists");

            if(user.getPassword().equals(new Password(password).getPassword())) {
                Logger.green_write("Right password!");
                AppUtils.storeLoginedUser(req.getSession(), user);

                int redirectId = -1;

                try {
                    redirectId = Integer.parseInt(req.getParameter("redirectId"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);

                if (requestUri != null) {
                    resp.sendRedirect(requestUri);
                } else {

                    resp.sendRedirect(req.getContextPath() + "/profile");
                }

                HttpSession session = req.getSession();
                session.setAttribute("auth", true);

            }

            else {
                Logger.red_write("Wrong password!");
                resp.sendRedirect("/authorization");
            }
        }
    }
}
