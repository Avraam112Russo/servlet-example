package com.n1nt3nd0.demonew;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet4", value = "/servlet4")
public class Servlet_Html extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.write("<html>" +
                "<head></head>" +
                "<body>" +
                "<form action='servlet' method='post'>" +
                "<textarea name='name'></textarea>" +
                "<input type='submit' name='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
