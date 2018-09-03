package com.sievehq.demo_project.dao;

import com.sievehq.demo_project.models.Cart;

import java.util.List;

public interface CartDao  {

    List<Cart> findById(Long id);
    Cart findByUsername(String username);
    public void removeCart(Long id);
    public void removeProductFromCart(Long id, Long productId);
}
