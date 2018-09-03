package com.sievehq.demo_project.repository;

import com.sievehq.demo_project.dto.CartIDTO;
import com.sievehq.demo_project.models.Cart;
import com.sievehq.demo_project.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    List<Cart>  findByUsername(String username);
}
