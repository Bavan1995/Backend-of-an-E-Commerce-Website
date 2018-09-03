package com.sievehq.demo_project.serviceImpl;

import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.repository.ProductRepository;
import com.sievehq.demo_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return  products;
    }
    @Override
     public void addToProduct(Product product){
        productRepository.save(product);
     }

}
