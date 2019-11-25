import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Email;

public class Main {
    public static void main(String[] args) {
        User user = new UserDAO().getUserByLogin(new Email("yulu.2000@mail.ru"));
        UserDAO userDAO = new UserDAO(user);

    }
}
