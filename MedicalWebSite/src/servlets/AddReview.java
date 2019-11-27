package servlets;

import DAO.ReviewDaO;
import ORM.Review;
import ORM.ServiceBuildinng;
import ORM.User;
import some_usefull_classes.Logger;
import some_usefull_classes.Text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addReview")
public class AddReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addReview.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from AddReview servlet is called");

        String text = req.getParameter("text");
        Date date = new Date();

        User user = (User) req.getSession().getAttribute("loginedUser");

        ServiceBuildinng serviceBuildinng = (ServiceBuildinng) req.getSession().getAttribute("serviceBuilding");

        Review review = new Review();
        review.setUser_name(user.getFirstName());
        review.setText(new Text(user.getId(), text, date));
        review.setBuilding_service_id(serviceBuildinng.getService_id());

        new ReviewDaO().add(review);

        resp.sendRedirect("/service?id=" + serviceBuildinng.getService_id());

        System.out.println(user.getId());
    }
}
