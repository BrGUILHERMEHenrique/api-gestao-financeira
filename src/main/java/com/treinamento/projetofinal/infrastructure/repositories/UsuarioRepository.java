package com.treinamento.projetofinal.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
}
