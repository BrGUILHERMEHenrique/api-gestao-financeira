package com.treinamento.projetofinal.domain.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;
import com.treinamento.projetofinal.domain.enums.TipoGasto;

@Entity
public class Retirada implements Comparable<Retirada>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private TipoGasto tipoGasto;
	
	@NotNull
	private Double quantia;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	

	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Retirada() {
		super();
	}



	public Retirada(Long id, String descricao, TipoGasto tipoGasto, Double quantia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.quantia = quantia;
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



	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}



	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}



	public Double getQuantia() {
		return quantia;
	}



	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public int compareTo(Retirada o) {
		return o.getQuantia().compareTo(this.quantia);
	}
	
	
	
	
}
