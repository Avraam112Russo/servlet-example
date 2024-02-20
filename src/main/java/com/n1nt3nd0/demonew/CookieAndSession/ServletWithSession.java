package com.n1nt3nd0.demonew.CookieAndSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletWithSession", value = "/ServletWithSession")
public class ServletWithSession extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count==null){
            session.setAttribute("count", 1);
            System.out.println("if loop");
        }
            else {
            System.out.println("else loop");
                session.setAttribute("count", count+1);
        }
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<h1>Your current count: "+count+"</h1>");
        printWriter.println("</body></html>");
    }
}
