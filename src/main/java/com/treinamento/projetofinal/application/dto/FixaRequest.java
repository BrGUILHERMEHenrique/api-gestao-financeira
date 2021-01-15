package com.treinamento.projetofinal.application.dto;


public class FixaRequest {

	private Long usuario;
	private String descricao;
	private Double quantia;
	
	
	public FixaRequest() {
		super();
	}


	public FixaRequest(Long usuario, String descricao, Double quantia) {
		super();
		this.usuario = usuario;
		this.descricao = descricao;
		this.quantia = quantia;
	}


	public Long getUsuario() {
		return usuario;
	}


	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getQuantia() {
		return quantia;
	}


	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	

}
