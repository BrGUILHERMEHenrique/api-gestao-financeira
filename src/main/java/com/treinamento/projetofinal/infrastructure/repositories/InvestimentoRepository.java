package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Investimento;

@Repository
public interface InvestimentoRepository extends CrudRepository<Investimento, Long> {


	@Query(value = "SELECT * FROM investimento WHERE id_usuario = :idUsuario", nativeQuery = true)
	List<Investimento> findByIdUsuario(Long idUsuario);
	
	Optional<Investimento> findById(Long id);
	
}
