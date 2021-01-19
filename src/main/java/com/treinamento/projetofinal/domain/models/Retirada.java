package com.treinamento.projetofinal.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.treinamento.projetofinal.domain.enums.TipoGasto;

@Entity
public class Retirada implements Comparable<Retirada>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGasto tipoGasto;
	
	@Column(nullable = false)
	private Double quantia;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", updatable = true, nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantia == null) ? 0 : quantia.hashCode());
		result = prime * result + ((tipoGasto == null) ? 0 : tipoGasto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retirada other = (Retirada) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantia == null) {
			if (other.quantia != null)
				return false;
		} else if (!quantia.equals(other.quantia))
			return false;
		if (tipoGasto != other.tipoGasto)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
