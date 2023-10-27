package com.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="colaborador")
public class ColaboradorEntity {

	@Id
	@Column(name="id")
	Integer id;
	@Column(name="nome")
	String nome;
	@Column(name="senha")
	String senha;
	@Column(name="score")
	Integer score;
	
	@ManyToOne
	@JoinColumn(name="id_chefe")
	ColaboradorEntity chefe;
	
}
