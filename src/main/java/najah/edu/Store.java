package najah.edu;

import java.util.Vector;

public class Store {
    private Vector<Product> products = new Vector<>();
    private String role;
    private int check = 0;
    public int getCheck() {
        return check;
    }
    public void setCheck(int c) {
        check = c;
    }
    public boolean addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                setCheck(0);
                return false;
            }
        }
        products.add(product);
        setCheck(1);
        return true;
    }
    public Product getProduct(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    public boolean updateProduct(String name, int newPrice, int newNumAvailable, String newDescription, String newRecipes, int newCost, int newDiscount) {
        Product product = getProduct(name);
        if (product == null) {
            return false;
        }
        if (newPrice < 0 || newNumAvailable < 0 || newDescription.isEmpty() || newDiscount < 0 || newRecipes.isEmpty() || newCost < 0) {
            return false;
        }
        product.setPrice(newPrice);
        product.setNumAvailable(newNumAvailable);
        product.setDescription(newDescription);
        product.setCost(newCost);
        product.setRecipes(newRecipes);
        product.setDiscount(newDiscount);
        return true;
    }

    public boolean removeProduct(String name) {
        Product product = getProduct(name);
        if (product == null) {
            return false;
        }
        products.remove(product);
        return true;
    }
}

