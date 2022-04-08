package com.andre.projedata.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double price;

	private List<AmountFeedstock> amountFeedstocks = new ArrayList<>();

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price, List<AmountFeedstock> amountFeedstocks) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amountFeedstocks = amountFeedstocks;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public List<AmountFeedstock> getAmountFeedstocks() {
		return amountFeedstocks;
	}

}
