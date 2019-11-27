package servlets;

import some_usefull_classes.Logger;
import utills.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("LogoutServlet get method is called");

        new CookieUtil().clearCookie(req, resp);

        req.getSession().removeAttribute("loginedUser");
        resp.sendRedirect("/authorization");
    }
}