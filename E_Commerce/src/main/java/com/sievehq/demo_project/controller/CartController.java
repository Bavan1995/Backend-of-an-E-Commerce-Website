package com.sievehq.demo_project.controller;

import com.sievehq.demo_project.dto.CartIDTO;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.service.CartService;
import com.sievehq.demo_project.serviceImpl.CartServiceImpl;
import com.sievehq.demo_project.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart/")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public void addTo(@RequestBody CartIDTO idto){
        cartService.addToCart(idto);
    }

    @RequestMapping(value = "remove/{id}/$", method = RequestMethod.DELETE)
    public void removeFrom(@PathVariable Long id){
        cartService.removeFromCart(id);
    }

    @RequestMapping(value = "all/", method = RequestMethod.GET)
    public List<Cart> getAll(){
        return cartService.getAllCarts();
    }

    @RequestMapping(value = "all/products/{id}/", method = RequestMethod.GET)
    public List<Product> getAllProducts(@PathVariable Long id){
        return cartService.getAllProducts(id);
    }

    @RequestMapping(value = "clear/all/", method = RequestMethod.DELETE)
    public void flushAllProducts(@RequestBody CartIDTO cartIDTO){
         cartService.flushCart(cartIDTO);
    }

    @RequestMapping(value = "remove/{id}/product/{productId}/", method = RequestMethod.DELETE)
    public void removeProductFromCart(@PathVariable Long id, @PathVariable Long productId){
        cartService.removeProductFromCart(id,productId);
    }
}