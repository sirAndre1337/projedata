package com.andre.projedata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Product;

@Repository
public interface ProductReposity extends JpaRepository<Product, Long>{


//	@Query("SELECT DISTINCT obj FROM Product  obj INNER JOIN obj.amountFeedstocks cats WHERE "
//			+ "(LOWER (obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
//			+ "cats.amount > 0")
//	Page<Product> findProductWithAmount(Pageable pageable, String name);
	
	@Query("SELECT obj FROM Product obj WHERE LOWER (obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<Product> findWithName(Pageable pageable, String name);
}
