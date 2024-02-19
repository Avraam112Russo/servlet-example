package com.n1nt3nd0.demonew;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class MYServlet extends HttpServlet {
    private String message;
    public void init(){
        message="Hello, bro";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        response.setContentType("text/html");
        printWriter.println("<html><body>");
        printWriter.println("<h1>"+message+"<h1>");
        printWriter.println("<h1>"+name+" "+surname+"<h1>");
        printWriter.println("</body></html>");


    }
    public void destroy(){
        System.out.println("Destroy method was call");
    }
}
