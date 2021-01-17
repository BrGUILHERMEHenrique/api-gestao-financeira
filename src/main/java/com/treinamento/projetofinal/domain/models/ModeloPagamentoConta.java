package com.treinamento.projetofinal.domain.models;

public class ModeloPagamentoConta {

	private Long idConta;
	private Long idUsuario;
	private Double quantia;
	
	public ModeloPagamentoConta() {
		super();
	}
	public ModeloPagamentoConta(Long idConta, Long idUsuario, Double quantia) {
		super();
		this.idConta = idConta;
		this.idUsuario = idUsuario;
		this.quantia = quantia;
	}
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Double getQuantia() {
		return quantia;
	}
	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	
}
