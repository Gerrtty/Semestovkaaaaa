package servlets;

import DAO.BuildingDAO;
import ORM.Building;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/t")
public class T extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BuildingDAO buildingDAO = new BuildingDAO();
        List<Building> arrayList = buildingDAO.getAll();
        req.getSession().setAttribute("list", arrayList);

        req.getRequestDispatcher("t.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}