package production_cods;

public class Product {

   private String Product_name;
    private String Description;

    private  String ID;
    private String date ;

    private int Quantity;

    private double price;

    private boolean allerges;
   private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Product(String product_name, String description, String ID, String date, int quantity, double price, boolean allerges, String image) {
        Product_name = product_name;
        Description = description;
        this.ID = ID;
        this.date = date;
        Quantity = quantity;
        this.price = price;
        this.allerges = allerges;
        imagePath=image;
    }

    public String getProduct_name() {
        return Product_name;
    }
    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }
    public String getDescription() {
        return Description;
    }
    public String getID() {
        return ID;
    }
    public String getDate() {
        return date;
    }
    public int getQuantity() {
        return Quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAllerges() {
        return allerges;
    }

}
