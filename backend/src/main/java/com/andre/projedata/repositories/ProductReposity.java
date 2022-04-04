package com.andre.projedata.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.Feedstock;
import com.andre.projedata.entities.Product;

@Repository
public interface ProductReposity extends JpaRepository<Product, Long>{

	@Query("SELECT obj FROM Product obj JOIN FETCH obj.feedstocks WHERE obj IN :products")
	List<Product> findWithFeedstock(List<Product> products);
	
	@Query("SELECT DISTINCT obj FROM Product  obj INNER JOIN obj.feedstocks cats WHERE "
			+ "(COALESCE(:feedstocks) IS NULL OR cats IN :feedstocks) AND "
			+ "(LOWER (obj.name) LIKE LOWER(CONCAT('%',:name,'%')))")
	Page<Product> find(List<Feedstock> feedstocks, Pageable pageable, String name);
	
	@Query("SELECT DISTINCT obj FROM Product  obj INNER JOIN obj.feedstocks cats WHERE "
			+ "(COALESCE(:feedstocks) IS NULL OR cats IN :feedstocks) AND "
			+ "(LOWER (obj.name) LIKE LOWER(CONCAT('%',:name,'%'))) AND "
			+ "cats.amount > 0")
	Page<Product> findProductWithAmount(List<Feedstock> feedstocks, Pageable pageable, String name);
}
