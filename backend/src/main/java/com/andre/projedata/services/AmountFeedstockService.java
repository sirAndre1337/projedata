package com.andre.projedata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.repositories.AmountFeedstockReposity;

@Service
public class AmountFeedstockService {
	
	@Autowired
	private AmountFeedstockReposity repository;
	
	@Transactional(readOnly = true)
	public Page<AmountFeedstock> findAllPaged(PageRequest pageRequest, String name) {
		Page<AmountFeedstock> page = repository.findWithAmount(pageRequest);
		return page;
	}
}
