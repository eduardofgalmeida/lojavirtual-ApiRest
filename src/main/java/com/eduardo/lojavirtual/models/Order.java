package com.eduardo.lojavirtual.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="TB_ORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@NotNull
	@Column(name = "cod")
	private BigDecimal cod;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	@Column(name = "date")
	private LocalDate date;
    
	@Column(name = "status")
	private String status;
	
	@Lob
	@Column(name = "comments")
	private String comments;
	
	@OneToMany
	private List<Product> product;

	@ManyToOne
	private Costumer costumer;
	
	public long getId() {
		return id;
	}
	
	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	
	
	
}
