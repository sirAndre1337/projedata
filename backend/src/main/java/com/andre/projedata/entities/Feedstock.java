package com.andre.projedata.entities;

import java.io.Serializable;
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
@Table(name = "tb_feedstock")
public class Feedstock implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double amount;
	private String type;
	
	@OneToOne(mappedBy = "feedstock")
	private AmountFeedstock amountFeedstock;
	
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product product;	
	
	public Feedstock() {
	}

	public Feedstock(Long id, String name, Double amount, String type) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.type = type;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public AmountFeedstock getAmountFeedstock() {
		return amountFeedstock;
	}
	
	public void setAmountFeedstock(AmountFeedstock amountFeedstock) {
		this.amountFeedstock = amountFeedstock;
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
		Feedstock other = (Feedstock) obj;
		return Objects.equals(id, other.id);
	}
}
