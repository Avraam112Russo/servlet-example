package com.n1nt3nd0.demonew.CookieAndSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "testSession", value = "/testSession")
public class TestSession extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer count =(Integer) session.getAttribute("count");
        if (count==null){
            session.setAttribute("count", 1);
        }else {
            session.setAttribute("count", count+1);
        }
        response.setContentType("text/html");
        response.getWriter()
                .write("<html><body>" +
                        "count: " +count +
                        "</body></html>");
    }
}
