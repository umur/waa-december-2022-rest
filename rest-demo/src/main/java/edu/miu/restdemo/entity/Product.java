package edu.miu.restdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    private int id;

    private String name;

    private int price;

    private boolean deleted;

    private List<Review> reviews;

    public Product() {

    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
