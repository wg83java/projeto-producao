package wg.msextrusora.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import wg.msextrusora.domain.CBAbstract;
import wg.msextrusora.domain.OrdemProcessoProducao;
import wg.msextrusora.repositories.OrdemProcessoProducaoRepository;

@Service
@RequiredArgsConstructor
public class OrdemProcessoProducaoService {
	
	private final OrdemProcessoProducaoRepository ordemProcessoRepository;
	
	@Transactional
	public OrdemProcessoProducao saveOrdemProcessoProducao(CBAbstract cb) {
		
		var ordem = new OrdemProcessoProducao();
		
		ordem.setName(cb.getName());
		ordem.setDiametro(cb.getDiametro());
		ordem.setFormacao(cb.getFormacao());
		ordem.setMaquina(cb.getMaquina());
		ordem.setQuantidadeBobina(cb.getQuantidadeBobina());
		ordem.setQuantidadeTotal(cb.getQuantidadeTotal());
		ordem.setQuantidade(cb.getQuantidade());
		
		return ordemProcessoRepository.save(ordem);
	}
	
	public List<OrdemProcessoProducao> findAll(){
		
		return ordemProcessoRepository.findAll();
	}
	
	
	

}
