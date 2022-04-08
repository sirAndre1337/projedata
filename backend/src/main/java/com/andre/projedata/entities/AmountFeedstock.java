package com.andre.projedata.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_amountfeedstock")
public class AmountFeedstock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "feedstock_id")
	private Feedstock feedstock;
	
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public AmountFeedstock() {
	}

	public AmountFeedstock(Long id, Feedstock feedstock, Double amount, Product product) {
		super();
		this.id = id;
		this.feedstock = feedstock;
		this.amount = amount;
		this.product = product;
	}

	public Feedstock getFeedstock() {
		return feedstock;
	}

	public void setFeedstock(Feedstock feedstock) {
		this.feedstock = feedstock;
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

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
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
