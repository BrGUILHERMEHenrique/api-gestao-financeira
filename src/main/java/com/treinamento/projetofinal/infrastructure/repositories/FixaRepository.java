package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Fixa;

@Repository
public interface FixaRepository extends CrudRepository<Fixa, Long> {

	@Query(value = "SELECT * FROM fixa WHERE id_usuario = :idUsuario", nativeQuery = true)
	List<Fixa> findByIdUsuario(Long idUsuario);
	
	Optional<Fixa> findById(Long id);
}
