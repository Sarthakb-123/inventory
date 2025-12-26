package service;
import model.Product;
import model.CategoryType;
import java.util.List;
import java.util.ArrayList;

public class InventoryService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> filterByCategory(CategoryType category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory() == category) {
                result.add(p);
            }
        }
        return result;

    }

    public List<Product> filterByMinprice(int minPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() >= minPrice) {

                result.add(p);
            }
        }
        return result;
    }

    public boolean productIdexists(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;

            }

        }
        return false;
    }

}