package com.n1nt3nd0.demonew.CookieAndSession;

import com.n1nt3nd0.demonew.Basket;
import com.n1nt3nd0.demonew.Product;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ServletWithSession_2", value = "/ServletWithSession_2")
public class ServletWithSession_2 extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Basket sessionBasket = (Basket) session.getAttribute("basket");
        String productName = request.getParameter("productName");
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        Product product = new Product(productName, quantity);
        if (sessionBasket == null){
            sessionBasket = new Basket();
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            sessionBasket.setListOfProducts(productList);
            session.setAttribute("basket", sessionBasket);
        }else {
            List<String> listOfProductsNames = sessionBasket.getListOfProducts().stream()
                            .map(prod-> prod.getName()).collect(Collectors.toList());
            if (listOfProductsNames.contains(productName)){
                Integer index = listOfProductsNames.indexOf(productName);
                Product savedProduct = sessionBasket.getListOfProducts().get(index);
                savedProduct.setQuantity(savedProduct.getQuantity()+quantity);
            }else {
            sessionBasket.getListOfProducts().add(product);
            }
            session.setAttribute("basket", sessionBasket);
        }
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<h1>Your current count: "+sessionBasket+"</h1>");
        printWriter.println("</body></html>");
    }
}
