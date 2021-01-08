package com.treinamento.projetofinal.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<?> usuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
		return ResponseEntity.badRequest().header("X-erro-msg", ex.getMsg()).header("X-erro-code", ex.getMessage()).build();
	}

}
