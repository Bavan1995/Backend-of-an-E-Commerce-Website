package com.sievehq.demo_project.service;

import com.sievehq.demo_project.dto.TransferIDTO;
import com.sievehq.demo_project.dto.WishIDTO;
import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.models.WishList;
import org.springframework.stereotype.Component;

import java.util.List;


public interface WishService {
    public void addToWishlist(WishIDTO idto);
    public void removeFromWishlist(Long id, Long productId);
    public List<Product> getAllProducts(Long id);
    public List<WishList> findByUsername(String username);
    public void addToCartFromWishlist(TransferIDTO idto);
}
