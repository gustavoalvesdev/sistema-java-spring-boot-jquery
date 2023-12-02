package com.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="colaborador")
public class ColaboradorEntity {

	@Id
	@GeneratedValue
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
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public ColaboradorEntity getChefe() {
		return chefe;
	}
	
	public void setChefe(ColaboradorEntity chefe) {
		this.chefe = chefe;
	}
}
