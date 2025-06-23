package wg.mstorcedeira.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wg.mstorcedeira.domain.OrdemProcessoProducao;

public interface OrdemProcessoProducaoRepository extends JpaRepository<OrdemProcessoProducao, Long>{
	
	List<OrdemProcessoProducao> findByData(LocalDate data);

}
