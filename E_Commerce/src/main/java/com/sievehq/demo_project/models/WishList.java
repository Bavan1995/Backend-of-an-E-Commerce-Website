package com.sievehq.demo_project.models;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "WishList.findByUsername", query = "SELECT w FROM WishList w WHERE LOWER(w.userName) = LOWER(?1)")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;

    @OneToMany
    private List<Product> product;

    public WishList(String userName, List<Product> product) {
        this.userName = userName;
        this.product = product;
    }

    public WishList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
