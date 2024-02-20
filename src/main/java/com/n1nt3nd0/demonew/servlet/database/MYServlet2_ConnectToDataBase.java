package com.n1nt3nd0.demonew.servlet.database;

import com.n1nt3nd0.demonew.servlet.database.DataBaseRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet2", value = "/servlet333")
public class MYServlet2_ConnectToDataBase extends HttpServlet {
    private String message;
    public void init(){
        message="hello from servlet 2";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        response.setContentType("text/html");
        printWriter.println("<html><body>");
        printWriter.println("<h1>"+message+"<h1>");
        printWriter.println("<h1>"+dataBaseRepository.getPersonList()+"<h1>");
        printWriter.println("</body></html>");
    }
    public void destroy(){
        System.out.println("Destroy method was call");
    }
}
