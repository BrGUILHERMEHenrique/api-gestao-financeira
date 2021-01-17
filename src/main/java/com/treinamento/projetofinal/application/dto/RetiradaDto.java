package com.treinamento.projetofinal.application.dto;

public class RetiradaDto {

	private String descricao;
	private String tipoGasto;
	private Double quantia;
	private Long usuario;
	
	
	public RetiradaDto() {
		super();
	}


	public RetiradaDto(String descricao, String tipoGasto, Double quantia, Long usuario) {
		super();
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.quantia = quantia;
		this.usuario = usuario;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipoGasto() {
		return tipoGasto;
	}


	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}


	public Double getQuantia() {
		return quantia;
	}


	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}


	public Long getUsuario() {
		return usuario;
	}


	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	
}
