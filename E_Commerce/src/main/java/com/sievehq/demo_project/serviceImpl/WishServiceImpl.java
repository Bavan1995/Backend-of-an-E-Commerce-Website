package com.sievehq.demo_project.serviceImpl;

import com.sievehq.demo_project.dto.TransferIDTO;
import com.sievehq.demo_project.dto.WishIDTO;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.models.WishList;
import com.sievehq.demo_project.repository.*;
import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.service.WishService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

@Component
public class WishServiceImpl implements WishService {

    @Autowired
    WishRepository wishRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    WishRepoV2 wishRepoV2;
    @Autowired
    CartRepoV2 cartRepoV2;

    @Override
   public void addToWishlist(WishIDTO idto) {
        java.util.Optional<Product> product = productRepository.findById(idto.getId());
        if(product.isPresent()){
            List<WishList> wishLists = new ArrayList<>();
            wishLists = wishRepository.findByUsername(idto.getUsername());
            if(!wishLists.isEmpty()){
                WishList wishList = wishLists.get(0);
                wishList.setUserName(idto.getUsername());
                List<Product> products = wishList.getProduct();
                products.add(product.get());
                wishList.setProduct(products);
                wishRepository.save(wishList);
            }
            else{
                WishList wishList = new WishList();
                List<Product> myproducts = new ArrayList<>();
                myproducts.add(product.get());
                wishList.setProduct(myproducts);
                wishRepository.save(wishList);
            }
        }
    }

   @Override
   public void removeFromWishlist(Long id,Long productId){
       wishRepoV2.removeProductFromWishlist(id,productId);
   }

    @Override
    public List<Product> getAllProducts(Long id){
        WishList wishList = wishRepoV2.findById(id);
        List<Product> products = wishList.getProduct();
        return products;
    }

    @Override
    public List<WishList> findByUsername(String username){
       return wishRepoV2.findByUsername(username);
    }

    @Override
    public void addToCartFromWishlist(TransferIDTO idto) {
        java.util.Optional<WishList> wishList= wishRepository.findById(idto.getWishListId());
        if(wishList.isPresent()){
            Product product = getProductFromWishList(wishList.get(),idto);
            if(product != null){
                List<Cart> carts = cartRepository.findByUsername(idto.getUserName());
                if(!carts.isEmpty()){
                    Cart cart = carts.get(0);
                    List<Product> products = cart.getProducts();
                    products.add(product);
                    cart.setProducts(products);
                    cartRepository.save(cart);
                }
            }
        }
    }

    private Product getProductFromWishList(WishList wishList,TransferIDTO idto){
        Long counter = new Long(0);
        for(Product product : wishList.getProduct()){

            if(product.getId().equals(idto.getProductId())){
                removeFromWishList(wishList,product);
                return product;
            }
            counter++;
        }
        return null;
    }

    private Boolean removeFromWishList(WishList wishList,Product product){
        List<Product> products = wishList.getProduct();
        products.remove(product);
        wishList.setProduct(products);
        wishRepository.save(wishList);
        return true;
    }
}