package com.n1nt3nd0.demonew.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MYServlet extends HttpServlet {
    private String message;
    public void init(){
        message="Hello, bro";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        PrintWriter printWriter = response.getWriter();
//        Map<String, String[]> map=request.getParameterMap();
//
//        response.setContentType("text/html");
//        printWriter.println("<html><body>");
//        printWriter.println("<h1>"+message+"<h1>");
//        printWriter.println("<h1> Name: "+Arrays.toString(map.get("name"))+"<h1>");
//        printWriter.println("<h1> surname: "+ Arrays.toString(map.get("surname")) +"<h1>");
//        Iterator<String>stringIterator=request.getParameterNames().asIterator();
//        while (stringIterator.hasNext()){
//            printWriter.println("<h1> params key: "+stringIterator.next()+"<h1>");
//        }
//        printWriter.println("<h1> params values: "+ Arrays.toString(request.getParameterValues("name"))+"<h1>");
//        printWriter.println("</body></html>");

        PrintWriter printWriter = response.getWriter();
        Map<String, String[]> parameterMap = request.getParameterMap();
        response.setContentType("text/html");
        printWriter.write("<html><body>");
        for (Map.Entry entry:parameterMap.entrySet()){
            printWriter.write("<h1>" + ((String)entry.getKey()) + " : " + Arrays.toString((String[])entry.getValue()) + "</h1>");
        }
        printWriter.write("<h1>" + request.getQueryString()+ "</h1>");
        printWriter.write("</body></html>");



    }
    public void destroy(){
        System.out.println("Destroy method was call");
    }
}
