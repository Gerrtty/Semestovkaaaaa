import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("registration.html");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "pass");
        String z = "select num from semestrovka.User";
        PreparedStatement pr = connection.prepareStatement(z);
        ResultSet resultSet = pr.executeQuery();
        resultSet.next();

        String firstname = req.getParameter("firstname");
        String lasttname = req.getParameter("lasttname");

        connection.close();
    }


}
