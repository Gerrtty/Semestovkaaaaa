package utills;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    public static void storeLoginedUser(HttpSession session, User loginedUser) {

        session.setAttribute("loginedUser", loginedUser);
    }

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

    public User createUser(UserDAO userDAO,
                            String firstName,
                            String lastName,
                            Email email,
                            Password password,
                            Phone phone) {

        User user = new User(firstName, lastName, email, password.getPassword());

        // This fields is not mandatory, can be null
        user.setPhone(phone);

        System.out.println(phone.getPhone());

        userDAO.add(user);

        Logger.green_write("User is created");

        return user;
    }

    public static void auth(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException {
        AppUtils.storeLoginedUser(req.getSession(), user);

        int redirectId = -1;

        try {
            if(req.getParameter("redirectId") != null) {
                redirectId = Integer.parseInt(req.getParameter("redirectId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);

        if (requestUri != null) {
            resp.sendRedirect(requestUri);
        } else {
            resp.sendRedirect(req.getContextPath() + "/profile");
        }

        HttpSession session = req.getSession();
        session.setAttribute("auth", true);
    }

}