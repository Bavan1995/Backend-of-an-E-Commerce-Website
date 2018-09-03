package com.sievehq.demo_project.repositoryImpl;

import com.sievehq.demo_project.dao.WishListDAO;
import com.sievehq.demo_project.models.WishList;
import com.sievehq.demo_project.repository.WishRepoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WishRepoV2Impl implements WishRepoV2 {

    @Autowired
    WishListDAO wishListDAO;


    public WishList findById(Long id){
       return wishListDAO.findById(id);
    }

    public List<WishList> findByUsername(String username){
        return wishListDAO.findByUsername(username);
    }

    public void removeWishlist(String username){
        wishListDAO.removeWishlist(username);
    }

    public void removeProductFromWishlist(Long id,Long productId){
        wishListDAO.removeProductFromWishlist(id,productId);
    }
}