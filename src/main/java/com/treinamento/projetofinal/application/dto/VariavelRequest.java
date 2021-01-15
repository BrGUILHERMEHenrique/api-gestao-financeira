package com.treinamento.projetofinal.application.dto;

public class VariavelRequest {

	private Long usuario;
	private String descricacao;
	private Double quantia;
	
	public VariavelRequest() {
		super();
	}

	public VariavelRequest(Long usuario, String descricacao, Double quantia) {
		super();
		this.usuario = usuario;
		this.descricacao = descricacao;
		this.quantia = quantia;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	
}
