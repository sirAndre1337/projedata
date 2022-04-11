package com.andre.projedata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.dto.AmountFeedStockDTO;
import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.repositories.AmountFeedstockReposity;
import com.andre.projedata.services.exceptions.DataBaseException;
import com.andre.projedata.services.exceptions.ResourceNotFoundException;

@Service
public class AmountFeedstockService {
	
	@Autowired
	private AmountFeedstockReposity repository;
	
	@Transactional(readOnly = true)
	public Page<AmountFeedstock> findAllPaged(PageRequest pageRequest, String name) {
		Page<AmountFeedstock> page = repository.findAll(pageRequest);
		return page;
	}

	@Transactional(readOnly = true)
	public List<AmountFeedStockDTO> findById(Long prodctId) {
		 List<AmountFeedstock> amountFeedstocks = repository.findByProduct(prodctId);
		 return amountFeedstocks.stream().map(x -> new AmountFeedStockDTO(x)).toList();
	}

	public AmountFeedStockDTO saveAmountFeedstock(AmountFeedStockDTO dto) {
		AmountFeedstock amountFeedStock = new AmountFeedstock(null, dto.getFeedstock_id(), dto.getAmount(),dto.getProduct_id() );
		amountFeedStock = repository.save(amountFeedStock);
		return new AmountFeedStockDTO(amountFeedStock);
	}
	
	public AmountFeedStockDTO updateAmountFeedstock(Long id, AmountFeedStockDTO dto) {
		findById(id);
		AmountFeedstock AmountFeedstock = new AmountFeedstock(id, dto.getFeedstock_id(), dto.getAmount(),dto.getProduct_id());
		AmountFeedstock = repository.save(AmountFeedstock);
		return new AmountFeedStockDTO(AmountFeedstock);
	}

	public void deleteAmountFeedstock(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}
}
