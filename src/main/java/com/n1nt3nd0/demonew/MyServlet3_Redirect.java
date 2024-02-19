package com.n1nt3nd0.demonew;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet3_Redirect", value = "/MyServlet3_Redirect")
public class MyServlet3_Redirect extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("redirect")!=null){
            response.sendRedirect("https://youtube.com/");
        }else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("redirect don't work and you come in servlet 3");
            writer.println("</body></html>");
        }
    }
}
