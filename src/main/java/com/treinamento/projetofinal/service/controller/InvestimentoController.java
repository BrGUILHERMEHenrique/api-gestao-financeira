package com.treinamento.projetofinal.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.application.dto.InvestimentoRequest;
import com.treinamento.projetofinal.domain.models.Investimento;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.service.service.InvestimentoService;

@RestController
@RequestMapping({ "/investimentos" })
public class InvestimentoController {

	@Autowired
	private InvestimentoService investimentoService;
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Investimento>> retornaListaporUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(investimentoService.retornaPorUsuario(idUsuario));	
	}
	@GetMapping("/porcentagem/{id}")
	public ResponseEntity<String> retornaPorcentagem(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(investimentoService.verificarPorcetagemLucro(id));
	}
	@GetMapping("investimento/{id}")
	public ResponseEntity<Investimento> retornaPorId(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(investimentoService.retornaPorId(id));
	}
	@PostMapping("/criar")
	public ResponseEntity<Investimento> adicionarInvestimento(@RequestBody InvestimentoRequest req) throws NotFound {
		return ResponseEntity.ok(investimentoService.adicionarInvestimento(req));
	}
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarInvestimento(@PathVariable Long id, @RequestBody InvestimentoRequest req) throws NotFound  {
		return ResponseEntity.ok(investimentoService.atualizarInvestimento(id, req));
	}
	@PutMapping("/atualizar/lucro/{id}")
	public ResponseEntity<String> atualizarLucro(@PathVariable Long id,@RequestParam Double quantia) throws NotFound {
		return ResponseEntity.ok(investimentoService.atualizarLucro(id, quantia));
	}
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> apagarInvestimento(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(investimentoService.apagarInvestimento(id));
	}
}
