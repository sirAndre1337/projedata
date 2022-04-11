package com.andre.projedata.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_amountfeedstock")
public class AmountFeedstock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long feedstock_id;
	
	private Double amount;
	
	
	private Long product_id;
	
	public AmountFeedstock() {
	}

	public AmountFeedstock(Long id, Long feedstock_id, Double amount, Long product_id) {
		super();
		this.id = id;
		this.feedstock_id = feedstock_id;
		this.amount = amount;
		this.product_id = product_id;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getFeedstock_id() {
		return feedstock_id;
	}
	
	public void setFeedstock_id(Long feedstock_id) {
		this.feedstock_id = feedstock_id;
	}
	
	public Long getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmountFeedstock other = (AmountFeedstock) obj;
		return Objects.equals(id, other.id);
	}
	
}
