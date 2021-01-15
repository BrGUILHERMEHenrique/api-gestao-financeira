package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Entrada;

@Repository
public interface EntradaRepository extends CrudRepository<Entrada, Long> {

	@Query(value = "SELECT * FROM entrada WHERE id_usuario = :idUsuario", nativeQuery = true)
	List<Entrada> findByIdUsuario(Long idUsuario);
	
	Optional<Entrada> findById(Long id);
	
}
