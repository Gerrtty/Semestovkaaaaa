import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("registration.html");
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = new Password(req.getParameter("pwd")).getPassword();

        addToDataBase(firstname, lastname, email, password);
    }

    private void addToDataBase(String firstname, String lastname, String email, String password) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "pass");
        } catch (SQLException e) {
            System.out.println("Connection to data base failed");
            e.printStackTrace();
        }


        String query = " insert into semestrovka.User (first_name, last_name, date_created, is_admin, num_points)"
                + " values (?, ?, ?, ?, ?)";

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
