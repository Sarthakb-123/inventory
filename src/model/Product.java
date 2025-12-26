package model;


 public class Product {
    private int id;
    private int price;
    private int quantity;
    private String productName;
    private CategoryType category;
    private Supplier supplier;

    public Product(int id, String productName, int price, int quantity, CategoryType cat, Supplier supplier) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = cat;
        this.supplier = supplier;

    }

    public CategoryType getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", supplier='" + supplier.getFullname() + '\'' +
                '}';
    }

}