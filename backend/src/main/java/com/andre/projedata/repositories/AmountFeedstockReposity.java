package com.andre.projedata.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andre.projedata.entities.AmountFeedstock;

@Repository
public interface AmountFeedstockReposity extends JpaRepository<AmountFeedstock, Long>{
	
	@Query("SELECT DISTINCT obj FROM AmountFeedstock obj INNER JOIN obj.feedstock fs WHERE "
			+ "obj.amount < fs.amount")
	Page<AmountFeedstock> findWithAmount(Pageable pageable);
}
