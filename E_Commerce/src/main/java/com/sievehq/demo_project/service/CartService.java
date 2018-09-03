package com.sievehq.demo_project.service;

import com.sievehq.demo_project.dto.CartIDTO;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartService {


    public void addToCart(CartIDTO idto);
    public void removeFromCart(Long id);
    public List<Cart> getAllCarts();
    public List<Product> getAllProducts(Long id);
    void flushCart(CartIDTO cartIDTO);
    void removeProductFromCart(Long id,Long productId);
}
