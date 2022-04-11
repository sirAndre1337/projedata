package com.andre.projedata.dto;

import java.io.Serializable;

import com.andre.projedata.entities.AmountFeedstock;

public class AmountFeedStockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long product_id;
	private Long feedstock_id;
	private Double amount;

	public AmountFeedStockDTO() {
	}

	public AmountFeedStockDTO(Long id, Long product_id, Long feedstock_id, Double amount) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.feedstock_id = feedstock_id;
		this.amount = amount;
	}

	public AmountFeedStockDTO(AmountFeedstock entity) {
		id = entity.getId();
		product_id = entity.getProduct_id();
		feedstock_id = entity.getFeedstock_id();
		amount = entity.getAmount();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getFeedstock_id() {
		return feedstock_id;
	}

	public void setFeedstock_id(Long feedstock_id) {
		this.feedstock_id = feedstock_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
