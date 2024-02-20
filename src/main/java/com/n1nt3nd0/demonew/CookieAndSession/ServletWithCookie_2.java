package com.n1nt3nd0.demonew.CookieAndSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletWithCookie_2", value = "/ServletWithCookie_2")
public class ServletWithCookie_2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        for (Cookie cookie:cookies){
            printWriter.println("your cookie: "+cookie.getName() + " : " +cookie.getValue());
        printWriter.println("</body></html>");
        }
    }
}
