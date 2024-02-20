package com.n1nt3nd0.demonew;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet(name = "header", value = "/header")
public class Servlet_Header extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            System.out.println(header+ " = " + request.getHeader(header ));
        }
        System.out.println("++++");
//        response.setHeader("Refresh", "1");
//        refresh page every 1 seconds
        response.setHeader("Refresh", "5;http://youtube.com/");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
