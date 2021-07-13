package com.api.farmacia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NonNull;
@Data
@Entity
@Table(name="STORE")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String nome;
	
	
	private Date inicioAtividades;
	
	
	private String endereco;
	
	
	private String telefone;
	
	
	private String ativa;
}
