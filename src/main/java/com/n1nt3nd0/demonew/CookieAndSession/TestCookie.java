package com.n1nt3nd0.demonew.CookieAndSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "testCookie", value = "/testCookie")
public class TestCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getCookies()!=null){
            Cookie[] cookies = request.getCookies();
            Arrays.stream(cookies)
                    .forEach(c-> System.out.println(c.getName() + " | " +c.getValue()));
            Arrays.stream(cookies)
                    .forEach((cookie) -> {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    });
        }
        else {
            response.getWriter().write("<html>" +
                    "<body>" +
                    "<h1>empty(</h1>>" +
                    "</body>" +
                    "</html>");
        }
    }
}
