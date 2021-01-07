package com.treinamento.projetofinal.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.projetofinal.domain.models.Conta;
import com.treinamento.projetofinal.domain.models.ContaResponse;


@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	public Optional<Conta> findById(Long id);
	
	@Query(value="SELECT * FROM conta WHERE id_usuario = :idUsuario", nativeQuery=true)
	public List<Conta> findByIdUsuario(Long idUsuario);
}
