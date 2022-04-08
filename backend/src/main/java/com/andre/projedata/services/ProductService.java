package com.andre.projedata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andre.projedata.dto.ProductDTO;
import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.entities.Product;
import com.andre.projedata.repositories.AmountFeedstockReposity;
import com.andre.projedata.repositories.ProductReposity;
import com.andre.projedata.services.exceptions.DataBaseException;
import com.andre.projedata.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductReposity repository;
	
	@Autowired
	private AmountFeedstockReposity amountFeedstockReposity;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest, String name) {
		Page<Product> page = repository.findWithName(pageRequest, name);
		return page.map(x -> new ProductDTO(x));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		 Optional<Product> obj = repository.findById(id);
		 Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		 return new ProductDTO(product);
	}
	
	@Transactional
	public ProductDTO saveProduct(ProductDTO dto) {
		Product product = new Product();
		product.setId(null);
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product = repository.save(product);
		
		product.getAmountFeedstocks().clear();
		for (AmountFeedstock af: dto.getAmountFeedstocks()) {
			product.getAmountFeedstocks().add(af);
			AmountFeedstock amountFeedstock = new AmountFeedstock(null, af.getFeedstock(), af.getAmount() ,product);
			amountFeedstockReposity.save(amountFeedstock);
		}		
		
		return new ProductDTO(product);
	}
	
	@Transactional
	public ProductDTO updateProduct(Long id , ProductDTO dto) {
		findById(id);
		Product product = new Product();
		product.setId(id);
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	public void deleteProduct(Long id) {
		try {
			List<AmountFeedstock> list = amountFeedstockReposity.findAll();
			for (AmountFeedstock amountFeedstock : list) {
				if (amountFeedstock.getProduct().getId() == id) {
					amountFeedstockReposity.deleteById(amountFeedstock.getId());
				}
			}
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}
	
}
