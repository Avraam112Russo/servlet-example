package com.n1nt3nd0.demonew.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "MyServlet_Forward", value = "/MyServlet_Forward")
public class MyServlet_Forward extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
        request.getRequestDispatcher("/MyServlet3_Redirect").forward(request, response);
        }catch (IOException | ServletException exception){
            System.out.println(exception.getMessage());
        }
    }
}
