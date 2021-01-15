package com.treinamento.projetofinal.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="investimento")
public class Investimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@NotNull
	private Double valorRetirada;
	
	@NotNull
	private Double lucroAtual = 0D;

	
	public Investimento() {
		super();
	}

	public Investimento(Long id, String descricao, Usuario usuario, Double valorRetirada, Double lucroAtual) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.usuario = usuario;
		this.valorRetirada = valorRetirada;
		this.lucroAtual = lucroAtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getValorRetirada() {
		return valorRetirada;
	}

	public void setValorRetirada(Double valorRetirada) {
		this.valorRetirada = valorRetirada;
	}

	public Double getLucroAtual() {
		return lucroAtual;
	}

	public void setLucroAtual(Double lucroAtual) {
		this.lucroAtual = lucroAtual;
	}
	
	
}
