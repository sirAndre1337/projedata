package com.andre.projedata.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.dto.FeedstockDTO;
import com.andre.projedata.entities.Feedstock;
import com.andre.projedata.repositories.FeedstockRepository;
import com.andre.projedata.services.exceptions.DataBaseException;
import com.andre.projedata.services.exceptions.ResourceNotFoundException;

@Service
public class FeedstockService {

	@Autowired
	private FeedstockRepository repository;

	@Transactional(readOnly = true)
	public Page<FeedstockDTO> findAllPaged(PageRequest pageRequest , String name) {
		Page<Feedstock> list = repository.findWithName(pageRequest, name);
		return list.map(x -> new FeedstockDTO(x));
	}

	@Transactional(readOnly = true)
	public FeedstockDTO findById(Long id) {
		Optional<Feedstock> obj = repository.findById(id);
		Feedstock feedstock = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new FeedstockDTO(feedstock);
	}

	@Transactional
	public FeedstockDTO saveFeedstock(FeedstockDTO dto) {
		Feedstock feedstock = new Feedstock(null, dto.getName(), dto.getAmount());
		feedstock = repository.save(feedstock);
		return new FeedstockDTO(feedstock);
	}

	public FeedstockDTO updateFeedstock(Long id, FeedstockDTO dto) {
		findById(id);
		Feedstock feedstock = new Feedstock(id, dto.getName(), dto.getAmount());
		feedstock = repository.save(feedstock);
		return new FeedstockDTO(feedstock);
	}

	public void deleteFeedstock(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}
}
