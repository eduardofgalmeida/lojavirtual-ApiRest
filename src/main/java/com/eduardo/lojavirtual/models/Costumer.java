package com.eduardo.lojavirtual.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_COSTUMER")
public class Costumer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "cpf")
	private String cpf;

	@NotNull
	@Column(name = "telephone1")
	private Integer telephone1;

	@Column(name = "telephone2")
	private Integer telephone2;

	@Column(name = "email")
	private String email;

	@OneToMany
	private List<Adresses> adresses;
	
	@OneToMany
	private List<Order> order;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(Integer telephone1) {
		this.telephone1 = telephone1;
	}

	public Integer getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(Integer telephone2) {
		this.telephone2 = telephone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Adresses> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresses> adresses) {
		this.adresses = adresses;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	

	
	
}
