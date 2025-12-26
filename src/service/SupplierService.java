package service;
import model.Supplier;

import java.util.List;
import java.util.ArrayList;

public class SupplierService {
    private List<Supplier> suppliers = new ArrayList<>();

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);

    }

    public Supplier getSupplierById(int id) {
        for (Supplier supplier : suppliers) {
            if (supplier.getId() == id) {
                return supplier;
            }
        }
        return null;

    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }
}
