package production_cods;

public class Product {
    private String productName;
    private String description;
    private String id;
    private String date;
    private int quantity;
    private double price;
    private boolean allergies;
    private String imagePath;

    // Private constructor to enforce object creation through Builder
    private Product(ProductBuilder builder) {
        this.productName = builder.productName;
        this.description = builder.description;
        this.id = builder.id;
        this.date = builder.date;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.allergies = builder.allergies;
        this.imagePath = builder.imagePath;
    }

    // Getters for the Product class fields
    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAllergies() {
        return allergies;
    }

    public String getImagePath() {
        return imagePath;
    }
    public static class ProductBuilder {
        private String productName;
        private String description;
        private String id;
        private String date;
        private int quantity;
        private double price;
        private boolean allergies;
        private String imagePath;

        public ProductBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setAllergies(boolean allergies) {
            this.allergies = allergies;
            return this;
        }

        public ProductBuilder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
