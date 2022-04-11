package com.andre.projedata.dto;

import java.io.Serializable;

import com.andre.projedata.entities.Feedstock;

public class FeedstockDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double amount;
	
	public FeedstockDTO() {
	}

	public FeedstockDTO(Long id, String name, Double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public FeedstockDTO(Feedstock entity) {
		id = entity.getId();
		name = entity.getName();
		amount = entity.getAmount();
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
