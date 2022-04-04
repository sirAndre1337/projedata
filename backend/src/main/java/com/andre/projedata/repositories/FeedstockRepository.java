package com.andre.projedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Feedstock;

@Repository
public interface FeedstockRepository extends JpaRepository<Feedstock, Long>{

}
