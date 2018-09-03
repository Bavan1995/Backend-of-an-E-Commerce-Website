package com.sievehq.demo_project.repository;

import com.sievehq.demo_project.models.Product;
import com.sievehq.demo_project.models.WishList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishRepository extends CrudRepository<WishList,Long > {
    List<WishList> findByUsername(String name);
}
