package najah.edu;

public class Product {
    private String name;
    private int price;
    private int cost;
    private int numAvailable;
    private String description;
    private String recipes;
    private int discount;
    private int discountPrice;

    public Product(String name, int price, int numAvailable, String description, String recipes, int cost, int discount) {
            this.name = name;
            this.price = price;
            this.numAvailable = numAvailable;
            this.description = description;
            this.cost = cost;
            this.discount = discount;
            this.recipes = recipes;
            this.discountPrice = price - ((discount/ 100) * price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getRecipes() {
        return recipes;
    }

    public void setRecipes(String recipes) {
        this.recipes = recipes;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
