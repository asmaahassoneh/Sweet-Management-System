package com.example.asmaasweet;

public class StariscsTable {
    String Product_Name;
    String Product_id;
    String Stock;
    String Date;
    double Price;

    public StariscsTable(String product_name, String product_id, String stock, String date, double price) {
        this.Product_Name = product_name;
        Product_id = product_id;
        Stock = stock;
        this.Date = date;
        this.Price = price;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.Product_Name = product_Name;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }
}