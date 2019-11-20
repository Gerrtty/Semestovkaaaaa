package utills;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import ORM.User;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;
import some_usefull_classes.Password;
import some_usefull_classes.Phone;

public class AppUtils {

    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

    // Сохранить информацию пользователя в Session.
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        // На JSP можно получить доступ через ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // Получить информацию пользователя, сохраненную в Session.
    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = uri_id_map.get(requestUri);

        if (id == null) {
            id = REDIRECT_ID++;

            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = id_uri_map.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }

    public void createUser(UserDAO userDAO,
                            String firstName,
                            String lastName,
                            Email email,
                            Password password,
                            String gender,
                            Phone phone,
                            InputStream inputStream) {

        User user = new User(firstName, lastName, email, password.getPassword());

        // This fields is not mandatory, can be null
        user.setGender(gender);
        user.setPhone(phone);
        user.setPhoto(inputStream);
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(inputStream);

        userDAO.add(user);

        Logger.green_write("User is created");
    }

}