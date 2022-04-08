package com.andre.projedata.dto;

import java.io.Serializable;
import java.util.List;

import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.entities.Manufacture;
import com.andre.projedata.entities.Product;

public class ManufactureDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Product product;
	private List<AmountFeedstock> amountFeedstocks;

	public ManufactureDTO() {
	}

	public ManufactureDTO(Long id, Product product, List<AmountFeedstock> amountFeedstocks) {
		super();
		this.id = id;
		this.product = product;
		this.amountFeedstocks = amountFeedstocks;
	}

	public ManufactureDTO(Manufacture entity) {
//		id = entity.getId();
//		product = entity.getProduct();
//		amountFeedstocks = entity.getAmountFeedstocks();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<AmountFeedstock> getAmountFeedstocks() {
		return amountFeedstocks;
	}

}
