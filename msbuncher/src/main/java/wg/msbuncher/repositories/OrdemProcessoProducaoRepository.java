package wg.msbuncher.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wg.msbuncher.domain.OrdemProcessoProducao;

public interface OrdemProcessoProducaoRepository extends JpaRepository<OrdemProcessoProducao, Long>{
	
	List<OrdemProcessoProducao> findByData(LocalDate data);

}
