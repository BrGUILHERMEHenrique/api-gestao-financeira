package com.treinamento.projetofinal.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.treinamento.projetofinal.domain.models.exceptions.ContaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.RetiradaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<?> usuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
		return ResponseEntity.notFound().header("X-erro-msg", ex.getMsg()).header("X-erro-code", ex.getMessage()).build();
	}

	@ExceptionHandler(RetiradaNaoEncontradaException.class)
	public ResponseEntity<?> retiradaNaoEncontrada(RetiradaNaoEncontradaException ex) {
		return ResponseEntity.notFound().header("X-erro-msg", ex.getMsg()).header("X-erro-code", ex.getMessage()).build();
	}
	
	@ExceptionHandler(ContaNaoEncontradaException.class)
	public ResponseEntity<?> contaNaoEncontrada(ContaNaoEncontradaException ex) {
		return ResponseEntity.notFound().header("X-erro-msg", ex.getMsg()).header("X-erro-code", ex.getMessage()).build();
	}
}
