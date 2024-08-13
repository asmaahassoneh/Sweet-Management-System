package production_cods;

import java.io.*;
import java.util.Vector;

public class ProductManageSource {


    Vector<Product> prod = new Vector<>();
    boolean IdFound = false;
    boolean ProductUpdate = false;
    private boolean FoundDelte = false;
    private int check;

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public Vector<Product> getProd() {
        return prod;
    }

    public void setProd(Vector<Product> prod) {
        this.prod = prod;
    }

    public boolean addNewProduct(String productName, String productId, String description, String date, int quantity, int price, boolean aller, String imagPath) {

        System.out.println(productId);
        if (productName == null ||
                productId == null ||
                description == null ||
                date == null ||
                quantity <= 0 ||
                price <= 0) {
            System.out.println("wrong");
            return false;
        }

        Product o = new Product(productName, productId, description, date, quantity, price, aller, imagPath);
        prod.add(o);


        // Append the new product to the file
        String filePath = "Products.txt";
        File file = new File(filePath);


        // Use try-with-resources to ensure the file is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' to open in append mode

            for (int i = 0; i < prod.size(); i++) {
                writer.write(prod.get(i).getProduct_name() + "," + prod.get(i).getID() + "," + prod.get(i).getDescription()
                        + "," + prod.get(i).getDate() + "," + prod.get(i).getQuantity() + "," + prod.get(i).getPrice() + "," + prod.get(i).isAllerges() + "," + prod.get(i).getImagePath());
                writer.newLine();
            }
            prod.clear();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public void DuplicateID(String Product_id) {

        // Specify the file name and path
        String filePath = "Products.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");
                // Check if the line has the correct number of parts
                if (parts.length == 8) {

                    // Check if the username matches and if the password matches the username
                    if (parts[1].equals(Product_id)) {
                        System.out.println("done");
                        IdFound = true;
                    } else {
                        IdFound = false;
                    }
                    break;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }


    public boolean isIdFound() {
        return IdFound;
    }


    public boolean UpdateProduct(String product_name, String product_id, String description, String date, int quantity, int price, boolean aller, String imagePth) {

        String filePath = "Products.txt";
        File file = new File(filePath);

        ProductUpdate = false;
        StringBuilder contentBuilder = new StringBuilder();

        // Read the file and build the updated content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(product_id)) {
                    String[] parts = line.split(",");
                    if (parts.length == 8) {
                        parts[0] = product_name;
                        parts[1] = product_id;
                        parts[2] = description;
                        parts[3] = String.valueOf(date);
                        parts[4] = String.valueOf(quantity);
                        parts[5] = String.valueOf(price);
                        parts[6] = String.valueOf(aller);
                        parts[7] = imagePth;
                        line = String.join(",", parts); // Update the line with the new email
                    }
                    ProductUpdate = true;
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Write the updated content back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return ProductUpdate;


    }

    public boolean removeProduct(String Prod_id) {
        String filePath = "PuarchedProduct.txt";
        File file = new File(filePath);
        System.out.println(Prod_id);
        StringBuilder contentBuilder = new StringBuilder();
        boolean FoundDelete = false;

// Read the file and build the content without the line containing the search string
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by spaces after splitting by commas to get individual components
                String[] parts = line.split(",|\\s+");

                if (parts.length > 2 && parts[2].equals(Prod_id)) {
                    FoundDelete = true;
                    // If the product ID matches, skip this line (i.e., don't add it to contentBuilder)
                } else {
                    // If the product ID doesn't match, add the line to contentBuilder
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            setCheck(0);
            return false;
        }

// Write the modified content back to the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            setCheck(0);
            return false;
        }
        setCheck(1);
        return FoundDelete;
    }
}









































