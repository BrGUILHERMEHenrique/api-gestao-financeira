package com.treinamento.projetofinal.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.treinamento.projetofinal.domain.models.exceptions.NotFound;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NotFound.class)
	public ResponseEntity<String> notFound(NotFound ex) {
		return ResponseEntity.notFound().header("X-erro-msg", ex.getMsg()).header("X-erro-code", ex.getMessage())
				.build();
	}
}
