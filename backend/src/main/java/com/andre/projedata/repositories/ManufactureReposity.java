package com.andre.projedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Manufacture;

@Repository
public interface ManufactureReposity extends JpaRepository<Manufacture, Long>{

}
