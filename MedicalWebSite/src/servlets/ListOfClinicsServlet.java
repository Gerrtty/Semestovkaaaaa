package servlets;

import some_usefull_classes.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListOfClinicsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ListOfClinicsServlet servlet is called");
        req.getRequestDispatcher("list_of_clinics.ftlh").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from ListOfClinicsServlet servlet is called");
    }
}
