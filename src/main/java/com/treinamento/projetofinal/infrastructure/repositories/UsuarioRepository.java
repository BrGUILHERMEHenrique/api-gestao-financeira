package com.treinamento.projetofinal.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.treinamento.projetofinal.domain.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
}
