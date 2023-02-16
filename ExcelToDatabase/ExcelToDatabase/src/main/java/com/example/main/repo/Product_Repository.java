package com.example.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.Product;

public interface Product_Repository extends JpaRepository<Product, Integer> {

}
