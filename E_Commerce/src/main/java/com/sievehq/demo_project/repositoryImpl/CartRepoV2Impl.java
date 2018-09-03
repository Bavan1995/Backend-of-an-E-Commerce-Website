package com.sievehq.demo_project.repositoryImpl;

import com.sievehq.demo_project.dao.CartDao;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.repository.CartRepoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartRepoV2Impl implements CartRepoV2 {

    @Autowired
    CartDao cartDao;

    @Override
    public List<Cart> findById(Long id) {
        return cartDao.findById(id);
    }

    @Override
    public Cart findByUsername(String username){
        return cartDao.findByUsername(username);
    }

    @Override
    public void removeCart(Long id){
        cartDao.removeCart(id);
    }

    @Override
    public  void removeProductFromCart(Long id,Long productId){
        cartDao.removeProductFromCart(id,productId);
    }
}