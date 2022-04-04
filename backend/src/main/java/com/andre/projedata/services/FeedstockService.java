package com.andre.projedata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.dto.FeedstockDTO;
import com.andre.projedata.entities.Feedstock;
import com.andre.projedata.repositories.FeedstockRepository;

@Service
public class FeedstockService {

	@Autowired
	private FeedstockRepository repository;
	
	@Transactional(readOnly = true)
	public Page<FeedstockDTO> findAllPaged(PageRequest pageRequest) {
		Page<Feedstock> list = repository.findAll(pageRequest);
		return list.map(x -> new FeedstockDTO(x));
	}
	
	
}
