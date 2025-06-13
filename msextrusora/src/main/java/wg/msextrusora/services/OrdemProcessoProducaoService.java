package wg.msextrusora.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import wg.msextrusora.domain.OrdemProcessoProducao;
import wg.msextrusora.repositories.OrdemProcessoProducaoRepository;

@Service
@RequiredArgsConstructor
public class OrdemProcessoProducaoService {
	
	private final OrdemProcessoProducaoRepository ordemProcessoRepository;
	
	@Transactional
	public OrdemProcessoProducao saveOrdemProcessoProducao(OrdemProcessoProducao ordem) {
		
		return ordemProcessoRepository.save(ordem);
	}
	
	public List<OrdemProcessoProducao> findAll(){
		
		return ordemProcessoRepository.findAll();
	}

}
