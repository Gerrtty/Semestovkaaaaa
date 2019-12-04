package servlets;

import DAO.AnswerDAO;
import ORM.Answer;
import ORM.User;
import some_usefull_classes.Logger;
import some_usefull_classes.Text;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    private int id = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Get method from AnswerServlet servlet is called");

        id = Integer.parseInt(req.getParameter("theme_id"));


        req.getRequestDispatcher("add_answer.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.green_write("Post method from AnswerServlet servlet is called");
        User user = (User) req.getSession().getAttribute("loginedUser");

        Answer answer = new Answer();

        Text text = new Text();
        text.setUser_id(user.getId());
        text.setText(req.getParameter("text"));
        answer.setText(text);
        answer.setThemeId(id);
        AnswerDAO answerDAO = new AnswerDAO();

        answerDAO.add(answer);

        resp.sendRedirect("/theme?theme_id=" + answer.getThemeId());
    }

}
