package servlets;

import DAO.BuildingDAO;
import ORM.Address;
import ORM.Building;
import some_usefull_classes.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from AddServlet servlet is called");
        req.getRequestDispatcher("addClinic.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from AddServlet servlet is called");

        Building building = new Building(new Address(req.getParameter("town"), req.getParameter("district"),
                req.getParameter("street"), Integer.parseInt(req.getParameter("number"))));

        building.setName(req.getParameter("name"));

        BuildingDAO buildingDAO = new BuildingDAO();
        buildingDAO.add(building);

        building.setId(buildingDAO.id);

        req.getSession().setAttribute("building", building);

        resp.sendRedirect("addPhoto");
    }
}
