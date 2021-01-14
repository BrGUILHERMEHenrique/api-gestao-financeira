package com.treinamento.projetofinal.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.application.dto.ContaDto;
import com.treinamento.projetofinal.domain.models.Conta;
import com.treinamento.projetofinal.domain.models.ModeloPagamentoConta;
import com.treinamento.projetofinal.domain.models.exceptions.ContaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.service.service.ContaService;

@RestController
@RequestMapping({ "/contas"} )
public class ContaController {	

	@Autowired
	private ContaService contaService;
	
	@PostMapping("/criar")
	public Conta criaConta(@RequestBody ContaDto conta) throws UsuarioNaoEncontradoException {
		return contaService.criarConta(conta);
	}
	@GetMapping("/{idUsuario}")
	public List<Conta> retornaContasUsuario(@PathVariable Long idUsuario) {
		return contaService.retornaContasUsuario(idUsuario);
	}
	
	@GetMapping("/conta/{id}")
	public Conta retornarConta(@PathVariable Long id) throws ContaNaoEncontradaException {
		return contaService.retornaConta(id);
	}
	
	@PutMapping("/pagar")
	public String pagarConta(@RequestBody ModeloPagamentoConta modelo) throws UsuarioNaoEncontradoException, ContaNaoEncontradaException {
		return contaService.pagarConta(modelo);
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagarConta(@PathVariable Long id) throws ContaNaoEncontradaException {
		return contaService.apagarConta(id);
	}
}
