package servlets;

import DAO.BuildingDAO;
import ORM.Building;
import some_usefull_classes.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clinic")
public class ClinicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from ClinicServlet servlet is called");
        int id = Integer.parseInt(req.getParameter("id"));
        Building building = new BuildingDAO().getByID(id);
        req.getSession().setAttribute("building", building);
        req.getRequestDispatcher("clinic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from ClinicServlet servlet is called");
    }
}
