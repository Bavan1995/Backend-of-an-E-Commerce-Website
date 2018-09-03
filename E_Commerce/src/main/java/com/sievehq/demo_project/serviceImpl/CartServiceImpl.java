package com.sievehq.demo_project.serviceImpl;

import com.sievehq.demo_project.dto.CartIDTO;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.repository.CartRepoV2;
import com.sievehq.demo_project.repository.CartRepository;
import com.sievehq.demo_project.repository.ProductRepository;
import com.sievehq.demo_project.repository.WishRepository;
import com.sievehq.demo_project.service.CartService;
import com.sievehq.demo_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    WishRepository wishRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Autowired
    CartRepoV2 cartRepoV2;

    @Override
    public void addToCart(CartIDTO idto){
        Optional<Product> product = productRepository.findById(idto.getProductId());
        if(product.isPresent()){
            List<Cart> carts = new ArrayList<>();
             carts = cartRepository.findByUsername(idto.getUsername());
             if(!carts.isEmpty()){
             Cart cart = carts.get(0);
             List<Product> products = cart.getProducts();
             products.add(product.get());
             cart.setProducts(products);
             cartRepository.save(cart);
        }else{
                 Cart cart = new Cart();
                 List<Product> products = new ArrayList<>();
                 products.add(product.get());
                 cart.setProducts(products);
                 cart.setUserName(idto.getUsername());
                 cartRepository.save(cart);
             }
        }
        else {
            System.out.println("Product is not present!");
        }
    }

    @Override
    public void removeFromCart(Long id){
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getAllCarts(){
        List<Cart> pros = cartRepoV2.findById(new Long(6));
        System.out.println(pros.toString());
        List<Cart> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

   @Override
   public List<Product> getAllProducts(Long id){
       Optional<Cart> cart = cartRepository.findById(id);
       if(cart.isPresent()){
           List<Product> products = new ArrayList<>(0);
           products = cart.get().getProducts();
           return products;
       }
       else{
           System.out.println("Cart is not present");
           return null;
       }
   }

    @Override
    public void flushCart(CartIDTO cartIDTO) {
        List<Cart> carts = cartRepository.findByUsername(cartIDTO.getUsername());
        Cart cart = carts.get(0);
        cart.setProducts(new ArrayList<>());
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Long id, Long productId){
           cartRepoV2.removeProductFromCart(id,productId);
    }
}