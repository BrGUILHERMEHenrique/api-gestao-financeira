package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.treinamento.projetofinal.domain.models.Retirada;

public interface RetiradaRepository extends CrudRepository<Retirada, Long> {

	Optional<Retirada> findById(Long id);
	
	@Query(value = "SELECT * FROM retirada WHERE id_usuario = :idUsuario", nativeQuery = true)
	List<Retirada> findByIdUsuario(Long idUsuario);
}
