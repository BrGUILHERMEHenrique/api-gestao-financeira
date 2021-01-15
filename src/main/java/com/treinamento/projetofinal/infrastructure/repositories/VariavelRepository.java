package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Variavel;

@Repository
public interface VariavelRepository extends CrudRepository<Variavel, Long> {


	@Query(value = "SELECT * FROM variavel WHERE id_usuario = :idUsuario", nativeQuery = true)
	List<Variavel> findByIdUsuario(Long idUsuario);
	
	Optional<Variavel> findById(Long id);
	
}
