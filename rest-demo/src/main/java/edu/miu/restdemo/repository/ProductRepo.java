package edu.miu.restdemo.repository;

import edu.miu.restdemo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop", 1000));
        products.add(new Product(2, "Mobile", 500));
        products.add(new Product(3, "Tablet", 300));
    }

    public void save(Product p) {
        products.add(p);
    }

    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id && !p.isDeleted())
                .findFirst().get();
    }
    public void delete(int id) {
        products.stream()
                .filter(p -> p.getId() == id)
                .findFirst().get().setDeleted(true);
    }

}
