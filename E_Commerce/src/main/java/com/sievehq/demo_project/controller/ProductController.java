package com.sievehq.demo_project.controller;

import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.service.ProductService;
import com.sievehq.demo_project.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public  class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public void addTo(@RequestBody Product product){
        productService.addToProduct(product);
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public List<Product> getAll(){
        return productService.getAllProducts();
    }
}
