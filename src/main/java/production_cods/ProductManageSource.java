package production_cods;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;

public class ProductManageSource {
    private static final Logger logger = Logger.getLogger(ProductManageSource.class.getName());
    ArrayList<Product> prod = new ArrayList<>();
    private int check = 1;
    private int checkDup = 0;
    String filePath = "Products.txt";

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getCheckDup() {
        return checkDup;
    }

    public void setCheckDup(int checkDup) {
        this.checkDup = checkDup;
    }

    public boolean addNewProduct(Product product) {
        if (isInvalidProduct(product)) {
            return false;
        }

        prod.add(product);

        return writeProductsToFile(prod, filePath);
    }

    private boolean isInvalidProduct(Product product) {
        return product.getProductName() == null ||
                product.getId() == null ||
                product.getDescription() == null ||
                product.getDate() == null ||
                product.getQuantity() <= 0 ||
                product.getPrice() <= 0;
    }

    private boolean writeProductsToFile(ArrayList<Product> products, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Product p : products) {
                writer.write(formatProduct(p));
                writer.newLine();
            }
            products.clear();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String formatProduct(Product product) {
        return String.join(",",
                product.getProductName(),
                product.getId(),
                product.getDescription(),
                product.getDate(),
                String.valueOf(product.getQuantity()),
                String.valueOf(product.getPrice()),
                String.valueOf(product.isAllergies()),
                product.getImagePath());
    }

    public void duplicateId(String productId) throws ProductNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8 && parts[1].equals(productId)) {
                    logger.info("Duplicate ID found");
                    setCheckDup(1);
                    throw new ProductNotFoundException("Duplicate product ID found: " + productId);
                }
            }
        } catch (IOException ex) {throw new ProductNotFoundException("Product ID " + productId + " not found.");}
    }




    public boolean updateProduct(Product product) {
        StringBuilder contentBuilder = new StringBuilder();

        boolean productUpdated = updateProductContent(product, contentBuilder);

        return productUpdated && writeContentToFile(contentBuilder.toString(), filePath);
    }

    private boolean updateProductContent(Product product, StringBuilder contentBuilder) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean updated = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(product.getId())) {
                    line = formatProduct(product);
                    updated = true;
                }
                contentBuilder.append(line).append(System.lineSeparator());
            }
            return updated;
        } catch (IOException e) {return false;
        }
    }

    private boolean writeContentToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean removeProduct(String prodId) {
        StringBuilder contentBuilder = new StringBuilder();
        boolean productFound = findAndRemoveProduct(prodId, contentBuilder);

        if (productFound) {
            return writeContentToFile(contentBuilder.toString(), "PuarchedProduct.txt");
        } else {
            setCheck(0);
            return false;
        }
    }

    private boolean findAndRemoveProduct(String prodId, StringBuilder contentBuilder) {
        try (BufferedReader reader = new BufferedReader(new FileReader("PuarchedProduct.txt"))) {
            String line;
            boolean foundDelete = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",|\\s+");

                if (parts.length > 2 && parts[2].equals(prodId)) {
                    foundDelete = true;
                } else {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            }
            return foundDelete;
        } catch (IOException e) {
            return false;
        }
    }
}
