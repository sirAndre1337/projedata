package com.andre.projedata.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.andre.projedata.entities.Feedstock;
import com.andre.projedata.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double price;

	private List<FeedstockDTO> feedstocks = new ArrayList<>();

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
	}

	public ProductDTO(Product entity, Set<Feedstock> feedstocks) {
		this(entity);
		feedstocks.forEach(fs -> this.feedstocks.add(new FeedstockDTO(fs)));
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

	public List<FeedstockDTO> getFeedstocks() {
		return feedstocks;
	}

	public void setFeedstocks(List<FeedstockDTO> feedstocks) {
		this.feedstocks = feedstocks;
	}

}
