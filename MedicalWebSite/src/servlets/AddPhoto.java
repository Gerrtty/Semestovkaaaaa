package servlets;

import DAO.BuildingDAO;
import ORM.Building;

import some_usefull_classes.Logger;
import utills.Loader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPhoto")
public class AddPhoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from AddPhoto servlet is called");
        req.getRequestDispatcher("addPhoto.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from AddPhoto servlet is called");

        Building building = (Building) req.getSession().getAttribute("building");

        if(building != null) {
            String fileName =  new Loader(building).load(req);
            String path = "images/building/" + fileName;
            building.setPath(path);

            BuildingDAO buildingDAO = new BuildingDAO();
            buildingDAO.setPath(building);

            Logger.green_write("Added photo");

            resp.sendRedirect("addService");
        }

        else {
            Logger.red_write("Building = null");
        }

    }
}
