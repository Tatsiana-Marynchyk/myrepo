package com.epam.infra.controller;

import com.epam.infra.operation.SimpleOperation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OperationController", urlPatterns = {"/doOperation"})
public class OperationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CONFIG_PATH = "/WEB-INF/config.properties";

    public OperationController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String param1 = request.getParameter("parameterA");
        String param2 = request.getParameter("parameterB");
        int result = 0;
        try {
            Integer a = Integer.valueOf(param1);
            Integer b = Integer.valueOf(param2);
            result = doOperation(a, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("parameterA", param1);
        session.setAttribute("parameterB", param2);
        session.setAttribute("result", result);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private int doOperation(Integer a, Integer b) throws IOException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {

        Properties prop = loadPropertiesFile();
        String className = prop.getProperty("operation.class");
        Class clazz = Class.forName(className);
        return ((SimpleOperation<Integer>)clazz.newInstance()).doOperation(a, b);
    }

    private Properties loadPropertiesFile() throws IOException {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getServletContext().getResourceAsStream(CONFIG_PATH)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            throw new IOException("Unable to load properties file : " + CONFIG_PATH, e);
        }
        return prop;
    }

}
