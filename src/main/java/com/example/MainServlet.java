package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/tomcat"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parms = req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String parm = String.join(" and ", entry.getValue());
                    return entry.getKey() + " = " + parm;
                })
                .collect(Collectors.joining("\n"));

        resp.getWriter().write("Method doGet\n" + "\nParms:\n" + parms);
    }
}
