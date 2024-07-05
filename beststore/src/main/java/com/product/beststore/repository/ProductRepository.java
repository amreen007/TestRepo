package com.product.beststore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.beststore.model.Products;

public interface ProductRepository extends JpaRepository<Products,Integer> {

}
