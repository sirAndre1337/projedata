package com.andre.projedata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Feedstock;

@Repository
public interface FeedstockRepository extends JpaRepository<Feedstock, Long>{

	
	@Query("SELECT obj FROM Feedstock obj WHERE LOWER (obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<Feedstock> findWithName(Pageable pageable, String name);
}
