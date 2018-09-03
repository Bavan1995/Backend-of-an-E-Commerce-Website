package com.sievehq.demo_project.dao;

import com.sievehq.demo_project.models.WishList;

import java.util.List;

public interface WishListDAO {

    public WishList findById(Long id);
    public List<WishList> findByUsername(String username);
    public void removeWishlist(String username);
    public void removeProductFromWishlist(Long id, Long productId);
}
