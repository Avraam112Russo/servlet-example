package com.n1nt3nd0.demonew.CookieAndSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

@WebServlet(name = "ServletWithCookie", value = "/ServletWithCookie")
public class ServletWithCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("some_cookie", "123");
        Cookie cookie2 = new Cookie("some_cookie_2", "456");
        Cookie[] cookies = {cookie, cookie2};
        Arrays.stream(cookies).forEach((c)-> {
            c.setMaxAge(60*60*24);
            response.addCookie(c);
        });
    }
}
