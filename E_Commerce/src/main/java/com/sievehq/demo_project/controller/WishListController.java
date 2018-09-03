package com.sievehq.demo_project.controller;

import com.sievehq.demo_project.dto.TransferIDTO;
import com.sievehq.demo_project.dto.WishIDTO;
import com.sievehq.demo_project.models.WishList;
import com.sievehq.demo_project.service.WishService;
import com.sievehq.demo_project.serviceImpl.WishServiceImpl;
import com.sievehq.demo_project.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wishlist/")
public class WishListController {

    @Autowired
    WishService wishService;


    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public void addToWishlist(@RequestBody WishIDTO idto){
        wishService.addToWishlist(idto);
    }
    @RequestMapping(value= "user/{username}/", method = RequestMethod.GET)
    public List<WishList> findByUsername(@PathVariable String username){
        return wishService.findByUsername(username);
    }

    @RequestMapping(value = "remove/{id}/{productId}/", method = RequestMethod.DELETE)
    public void removeFrom(@PathVariable Long id,@PathVariable Long productId){
        wishService.removeFromWishlist(id,productId);
    }

    @RequestMapping(value = "all/{id}/", method = RequestMethod.GET)
    public List<Product> getAll(@PathVariable Long id){
        return wishService.getAllProducts(id);
    }

    @RequestMapping(value = "addtocart/", method = RequestMethod.POST)
    public void addToCart( @RequestBody TransferIDTO idto){
        wishService.addToCartFromWishlist(idto);
    }
}
