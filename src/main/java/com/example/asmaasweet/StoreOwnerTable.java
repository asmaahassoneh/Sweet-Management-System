package com.example.asmaasweet;

public class StoreOwnerTable {



   int PriceINTable;
   String  Product_Name;
   String Product_id;
   String dateTable;
   String  discriptionTable;
   int StockTable;
   Boolean  allergy;

    public Boolean getAllergy() {
        return allergy;
    }

    public void setAllergy(Boolean allergy) {
        this.allergy = allergy;
    }

    String imagePath;

    public StoreOwnerTable(int price, String product_Name, String product_id, String dateTable, String discriptionTable, int stockTable, String imagepath, Boolean allergys) {
        PriceINTable = price;
        Product_Name = product_Name;
        Product_id = product_id;
        this.dateTable = dateTable;
        this.discriptionTable = discriptionTable;
        StockTable = stockTable;
        imagePath=imagepath;
        allergy=allergys;
    }

    public int getPrice() {
        return PriceINTable;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getProduct_id() {
        return Product_id;
    }

    public String getDateTable() {
        return dateTable;
    }

    public String getDiscriptionTable() {
        return discriptionTable;
    }

    public int getStockTable() {
        return StockTable;
    }


    public void setStockTable(int stockTable) {
        StockTable = stockTable;
    }

    public void setPriceINTable(int priceINTable) {
        PriceINTable = priceINTable;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }

    public void setDateTable(String dateTable) {
        this.dateTable = dateTable;
    }

    public void setDiscriptionTable(String discriptionTable) {
        this.discriptionTable = discriptionTable;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
