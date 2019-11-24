package utills;

import ORM.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public void addCookie(HttpServletResponse resp, User user) {
        Cookie cookieToken = new Cookie("token", user.getToken());
        Cookie cookieId = new Cookie("id", String.valueOf(user.getId()));
        cookieToken.setMaxAge(2592000);
        cookieId.setMaxAge(2592000);
        resp.addCookie(cookieId);
        resp.addCookie(cookieToken);
    }

    public void clearCookie(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        Cookie cookieId = new Cookie("token", "");
        Cookie cookieToken = new Cookie("id", "");
        cookieId.setMaxAge(0);
        cookieToken.setMaxAge(0);
        resp.addCookie(cookieId);
        resp.addCookie(cookieToken);
    }
}
