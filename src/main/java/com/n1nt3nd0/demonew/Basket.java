package com.n1nt3nd0.demonew;

import java.util.List;

public class Basket {
    private List<Product>listOfProducts;

    public Basket(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public Basket() {
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "listOfProducts=" + listOfProducts +
                '}';
    }
}
