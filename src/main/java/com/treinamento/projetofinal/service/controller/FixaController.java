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
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.application.dto.FixaRequest;
import com.treinamento.projetofinal.domain.models.Fixa;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.service.service.FixaService;

@RestController
@RequestMapping({ "/fixas" })
public class FixaController {

	@Autowired
	private FixaService fixaService;
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Fixa>> retornaPorUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(fixaService.retornaListaporUsuario(idUsuario));
	}
	
	@GetMapping("fixa/{id}")
	public ResponseEntity<Fixa> retornaPorId(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(fixaService.retornaPorId(id));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Fixa> criaDespesaFixa(@RequestBody FixaRequest req) throws NotFound {
		return ResponseEntity.ok(fixaService.criarDespesaFixa(req));
	}
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarDespesaFIxa(@PathVariable Long id, @RequestBody FixaRequest req) throws NotFound{
		return ResponseEntity.ok(fixaService.atualizarDespesaFixa(id, req));
	}
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> apagarDespesaFixa(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(fixaService.apagarDespesaFixa(id));
	}
}
