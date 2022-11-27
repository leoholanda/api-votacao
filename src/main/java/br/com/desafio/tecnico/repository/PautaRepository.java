package br.com.desafio.tecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.tecnico.entity.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

	@Query("SELECT p FROM Pauta p WHERE p.descricao = :descricao AND p.dataAbertura = CURRENT_DATE")
	List<Pauta> findByDescricao(String descricao);
	
}
