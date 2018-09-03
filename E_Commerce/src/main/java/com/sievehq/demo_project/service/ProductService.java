package com.sievehq.demo_project.service;

import com.sievehq.demo_project.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    public List<Product> getAllProducts();
    public void addToProduct(Product product);

}
