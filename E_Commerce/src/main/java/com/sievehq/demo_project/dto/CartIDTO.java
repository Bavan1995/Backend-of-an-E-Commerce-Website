package com.sievehq.demo_project.dto;

public class CartIDTO {

    private String username;
    private Long productId;

    public CartIDTO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

