package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

    public static final String USER = "user";
    public static final String ADMIN = "admin";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {


        List<String> urlPatternsUser = new ArrayList<String>();

        urlPatternsUser.add("/registration");
        urlPatternsUser.add("/authorization");
        urlPatternsUser.add("/mainPage");
        urlPatternsUser.add("/setPhoto");
        urlPatternsUser.add("/forum");
        urlPatternsUser.add("/listOfClinics");
        urlPatternsUser.add("/profile");
        urlPatternsUser.add("/uploadServlet");

        mapConfig.put(USER, urlPatternsUser);

        // Конфигурация для роли "MANAGER".
        List<String> urlPatternsAdmin = new ArrayList<String>();

        urlPatternsAdmin.add("/registration");
        urlPatternsAdmin.add("/authorization");
        urlPatternsAdmin.add("/mainPage");
        urlPatternsAdmin.add("/setPhoto");
        urlPatternsAdmin.add("/forum");
        urlPatternsAdmin.add("/listOfClinics");
        urlPatternsAdmin.add("/profile");
        urlPatternsAdmin.add("/uploadServlet");
        urlPatternsAdmin.add("/addClinic");

        mapConfig.put(ADMIN, urlPatternsAdmin);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}