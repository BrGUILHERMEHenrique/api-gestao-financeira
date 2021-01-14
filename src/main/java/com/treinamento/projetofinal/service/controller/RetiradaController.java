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

import com.treinamento.projetofinal.application.dto.RetiradaDto;
import com.treinamento.projetofinal.domain.models.Retirada;
import com.treinamento.projetofinal.domain.models.exceptions.RetiradaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.service.service.RetiradaService;

@RestController
@RequestMapping({ "/retiradas" })
public class RetiradaController {

	@Autowired
	private RetiradaService retiradaService;
	
	@PostMapping("/retirar")
	public Retirada retirarMontante(@RequestBody RetiradaDto dto) throws UsuarioNaoEncontradoException {
		return retiradaService.criarRetirada(dto);
	}
	
	@GetMapping("/{idUsuario}")
	public List<Retirada> retornaPorUsuario(@PathVariable Long idUsuario) {
		return retiradaService.retornarPorUsuario(idUsuario);
	}
	
	@GetMapping("/retirada/{id}")
	public Retirada retornarRetirada(@PathVariable Long id) throws RetiradaNaoEncontradaException {
		return retiradaService.retornaRetirada(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizarDescricao(@PathVariable Long id, @RequestBody RetiradaDto dto) {
		return retiradaService.atualizarDescricao(id, dto);
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagarRetirada(@PathVariable Long id) throws RetiradaNaoEncontradaException {
		return retiradaService.deletarRetirada(id);
	}
	
}
