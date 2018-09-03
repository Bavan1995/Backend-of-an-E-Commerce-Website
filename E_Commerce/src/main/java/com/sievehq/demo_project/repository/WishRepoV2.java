package com.sievehq.demo_project.repository;

import com.sievehq.demo_project.models.WishList;
import org.springframework.stereotype.Component;

import java.util.List;

public interface WishRepoV2 {
    public WishList findById(Long id);
    public List<WishList> findByUsername(String name);
    public void removeWishlist(String username);
    public void removeProductFromWishlist(Long id, Long productId);
}
