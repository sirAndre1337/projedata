package com.andre.projedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Product;

@Repository
public interface ProductReposity extends JpaRepository<Product, Long>{

}
