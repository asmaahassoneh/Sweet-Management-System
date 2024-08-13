package com.example.najehfxsoftware;

public class AdminMYbillTAble {

private String Price;

private String Product_name;
private  String quantity;

    public AdminMYbillTAble(String price, String product_name, String quantity) {
        Price = price;
        Product_name = product_name;
        this.quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
