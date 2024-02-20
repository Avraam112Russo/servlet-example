package com.n1nt3nd0.demonew.servlet.mvc;

import com.n1nt3nd0.demonew.servlet.model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "mvc", value = "/mvc")
public class MVC_Servlet_Example extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employeeFromRequest = new Employee("employeeFromRequest", 1);
        Employee employeeFromSession = new Employee("employeeFromSession", 2);
        Employee employeeFromContext = new Employee("employeeFromContext", 3);


        req.getSession().setAttribute("employeeFromSession", employeeFromSession);
        req.setAttribute("employeeFromRequest", employeeFromRequest);
        req.getServletContext().setAttribute("employeeFromContext", employeeFromContext);

        List<String> stringList = new ArrayList<>(List.of("Sasha", "Vasya"));
        req.setAttribute("ArrayListFromRequestAttributes", stringList);

        Map<String, String> map = new HashMap<>();
        map.put("Petya", "Molodec");
        map.put("Garik", "Silniy");
        req.setAttribute("ourHashMapFromRequestAttributes", map);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/demo2.jsp");
        requestDispatcher.forward(req, resp);

    }
}
