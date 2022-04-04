package com.andre.projedata.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.dto.FeedstockDTO;
import com.andre.projedata.dto.ProductDTO;
import com.andre.projedata.entities.Feedstock;
import com.andre.projedata.entities.Product;
import com.andre.projedata.repositories.FeedstockRepository;
import com.andre.projedata.repositories.ProductReposity;
import com.andre.projedata.services.exceptions.DataBaseException;
import com.andre.projedata.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductReposity repository;
	
	@Autowired
	private FeedstockRepository feedstockRepository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest, Long feedstockId, String name) {
		List<Feedstock> feedstocks = (feedstockId == 0) ? null : Arrays.asList(feedstockRepository.getOne(feedstockId));
		Page<Product> page = repository.find(feedstocks, pageRequest, name);
		repository.findWithFeedstock(page.toList());
		return page.map(x -> new ProductDTO(x, x.getFeedstocks()));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		 Optional<Product> obj = repository.findById(id);
		 Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		 return new ProductDTO(product, product.getFeedstocks());
	}
	
	@Transactional
	public ProductDTO saveProduct(ProductDTO dto) {
		Product product = new Product();
		product.setId(null);
		copyDtoToEntity(dto, product);
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	@Transactional
	public ProductDTO updateProduct(Long id , ProductDTO dto) {
		findById(id);
		Product product = new Product();
		product.setId(id);
		copyDtoToEntity(dto, product);
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	public void deleteProduct(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());		
		
		entity.getFeedstocks().clear();
		for (FeedstockDTO feedDto : dto.getFeedstocks()) {
			Feedstock feedstock = feedstockRepository.getOne(feedDto.getId());
			entity.getFeedstocks().add(feedstock);
		}
	}
	
}
