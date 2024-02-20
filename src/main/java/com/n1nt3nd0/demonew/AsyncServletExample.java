package com.n1nt3nd0.demonew;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "async", value = "/async", asyncSupported = true)
public class AsyncServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(()->{
            for (int i = 0; i < 10; i++){
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                resp.getWriter().write("<html>" +
                        "<body>" +
                        "<h1>async thread finished</h1>>" +
                        "</body>" +
                        "</html>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        asyncContext.complete();
        System.out.println("Main thread here");
    }
}
