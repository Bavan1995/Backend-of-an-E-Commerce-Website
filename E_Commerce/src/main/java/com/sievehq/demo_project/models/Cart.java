package com.sievehq.demo_project.models;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Cart.findByUsername", query = "SELECT c FROM Cart c WHERE LOWER(c.userName) = LOWER(?1)")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String userName;
    @OneToMany
    List<Product> products;

    public Cart() {
    }

    public Cart(String userName, List<Product> products) {
        this.userName = userName;
        this.products = products;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }
}