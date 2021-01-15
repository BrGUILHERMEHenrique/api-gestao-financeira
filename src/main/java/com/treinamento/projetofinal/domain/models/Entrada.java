package com.treinamento.projetofinal.domain.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.treinamento.projetofinal.domain.enums.TipoEntrada;

@Entity
@Table(name="entrada")
public class Entrada {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private TipoEntrada tipoEntrada;
	
	@NotNull
	private Double quantia;

	
	public Entrada() {
		super();
	}

	public Entrada(Long id, Usuario usuario, String descricao, TipoEntrada tipoEntrada, Double quantia) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descricao = descricao;
		this.tipoEntrada = tipoEntrada;
		this.quantia = quantia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	
	
}
