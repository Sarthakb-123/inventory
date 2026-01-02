package app;

import service.InventoryService;
import service.SupplierService;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class project1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryService service = new InventoryService();
        SupplierService service2 = new SupplierService();

        Supplier s1 = new Supplier(1, "9034", "Suresh");
        Supplier s2 = new Supplier(2, "8123", "Ramesh");

        service2.addSupplier(s1);
        service2.addSupplier(s2);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));
            int id;
            while (true) {
                System.out.println("id :");
                id = sc.nextInt();
                sc.nextLine();
                if (service.productIdexists(id)) {
                    System.out.println("product id already exist . try again .");

                } else {
                    break;
                }

            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            int price;
            while (true) {
                System.out.print("price : ");
                price = sc.nextInt();
                sc.nextLine();

                if (price <= 0) {
                    System.out.println("price must be greater than 0");
                } else {
                    break;
                }
            }

            int quantity;
            while (true) {
                System.out.print("quantity : ");
                quantity = sc.nextInt();
                sc.nextLine();

                if (quantity < 0) {
                    System.out.println("quantity must be greater than 0 ");

                } else {
                    break;
                }
            }

            // System.out.print("Category (electronics/sports/household): ");

            CategoryType selectedCategory = null;
            while (selectedCategory == null) {
                System.out.print("Category (electronics/sports/household): ");
                String input = sc.nextLine().trim().toLowerCase();

                if (input.equals("electronics") || input.equals("e")) {
                    selectedCategory = CategoryType.ELECTRONICS;

                } else if (input.equals("sports") || input.equals("s")) {
                    selectedCategory = CategoryType.SPORTS;
                } else if (input.equals("household") || input.equals("h")) {
                    selectedCategory = CategoryType.HOUSEHOLD;
                } else {
                    System.out.println("invalid !!!");
                }

                /*
                 * try {
                 * selectedCategory = CategoryType.valueOf(input);
                 * 
                 * } catch (IllegalArgumentException e) {
                 * System.out.println("try again !!!");
                 * }/*
                 */

            }

            Supplier selectedSupplier = null;
            while (selectedSupplier == null) {
                System.out.println("Supplier ID :");
                int supplierid = sc.nextInt();
                sc.nextLine();

                selectedSupplier = service2.getSupplierById(supplierid);
                if (selectedSupplier == null) {
                    System.out.println("invalid id . try again");

                }
            }

            Product p = new Product(id, name, price, quantity, selectedCategory, selectedSupplier);
            service.addProduct(p);

        }

        //new quantity
        System.out.println("enter product id to update : ");
        int updateID = sc.nextInt();

        int newqty;
        while (true) {
            System.out.println("enter new quantity");
            newqty = sc.nextInt();

            if (newqty >= 0) {
                break;
            }
            System.out.println("enter number >= 0");
        }

        boolean updated = service.updateProductQuantity(updateID, newqty);

        if (updated) {
            System.out.println("quantity updated successfully");
        } else {
            System.out.println("product not found");
        }

        //lowstock
        System.out.print("Enter low stock threshold: ");
        int threshold = sc.nextInt();

        List<Product> lowStockProducts = service.getLowStockProducts(threshold);

        if (lowStockProducts.isEmpty()) {
            System.out.println("No low stock items.");
        } else {
            System.out.println("⚠ LOW STOCK ITEMS:");
            for (Product p : lowStockProducts) {
                System.out.println("⚠ " + p.getProductName() + " (qty=" + p.getQuantity() + ")");
            }
        }
        // delete product by id

        System.out.println("enter product id to delete");
        int deleteId = sc.nextInt();

        boolean deleted = service.deleteProductById(deleteId);
        if(deleted){
            System.out.println("product deleted succesfully ");
        }
        else{
            System.out.println("product not found");
        }

        // Filter by category
        for (CategoryType category : CategoryType.values()) {
            List<Product> ProductByCategoryType = service.filterByCategory(category);
            System.out.println(category + "Product :");
            for (Product p : ProductByCategoryType) {
                System.out.println(p);

            }
        }
        // Filter by price
        List<Product> expensiveProducts = service.filterByMinprice(3000);
        System.out.println("\nExpensive products:");
        for (Product p : expensiveProducts) {
            System.out.println(p);
        }
        sc.close();
    }
}
