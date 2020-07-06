package com.eduardo.lojavirtual.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="TB_ADRESSES")
public class Adresses implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@NotNull
	@Column(name = "adresses")
	private String adresses;
	
	@NotNull
	@Column(name = "adresses_num")
	private Integer adresses_num;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "complement")
	private String complement;
	
	@Column(name = "neighborhood")
	private String neighborhood;
	
	@NotNull
	@Column(name = "city")
	private String city;
	
	@NotNull
	@Column(name = "state")
	private String state;
	
	@ManyToOne
	private Costumer costumer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresses() {
		return adresses;
	}

	public void setAdresses(String adresses) {
		this.adresses = adresses;
	}

	public Integer getAdresses_num() {
		return adresses_num;
	}

	public void setAdresses_num(Integer adresses_num) {
		this.adresses_num = adresses_num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Costumer getCostumer() {
		return costumer;
	}

	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}



}
