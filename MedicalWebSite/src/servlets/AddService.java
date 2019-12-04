package servlets;

import DAO.ServiceBuildingDAO;
import DAO.ServiceDAO;
import ORM.Building;
import ORM.ServiceBuildinng;
import some_usefull_classes.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addService")
public class AddService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from AddService servlet is called");
        req.getRequestDispatcher("addService.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from AddService servlet is called");

        String service = req.getParameter("service");

        int price = Integer.parseInt(req.getParameter("price"));

        int service_id = new ServiceDAO().getIdByDescription(service);

        int building_id = ((Building) req.getSession().getAttribute("building")).getId();

        ServiceBuildinng serviceBuildinng = new ServiceBuildinng(service_id, building_id, price);


        ServiceBuildingDAO serviceBuildingDAO = new ServiceBuildingDAO();
        serviceBuildingDAO.add(serviceBuildinng);

        resp.sendRedirect("/addService");
    }
}
