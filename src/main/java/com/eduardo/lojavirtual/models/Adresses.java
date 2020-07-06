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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "local")
	private String local;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "adresses")
	private String adresses;
	
	@Column(name = "adresses_num")
	private Integer adresses_num;
	
	@Column(name = "complement")
	private String complement;
	
	@Column(name = "neighborhood")
	private String neighborhood;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@ManyToOne
	private Costumer costumer;

}
