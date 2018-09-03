package com.sievehq.demo_project.repository;

import com.sievehq.demo_project.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
