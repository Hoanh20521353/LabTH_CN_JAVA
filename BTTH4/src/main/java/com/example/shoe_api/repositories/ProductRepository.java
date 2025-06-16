package com.example.shoe_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoe_api.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
