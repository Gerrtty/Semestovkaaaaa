package some_usefull_classes;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import DAO.UserDAO;
import ORM.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import some_usefull_classes.Email;
import some_usefull_classes.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import freemarker.template.Configuration;

import freemarker.template.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;

public class FreeMarkerConfiguration extends HttpServlet {

    public void cfg() {
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//
//        ServletContext servletContext = getServletContext();
//        cfg.setServletContextForTemplateLoading(servletContext,"");
//
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setLogTemplateExceptions(false);
//        cfg.setWrapUncheckedExceptions(true);
    }
}
