package wg.msbuncher.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import wg.msbuncher.domain.CBAbstract;
import wg.msbuncher.domain.ListCb;
import wg.msbuncher.domain.OrdemProcessoProducao;
import wg.msbuncher.domain.PedidoLiberadoParaProcesso;
import wg.msbuncher.services.OrdemProcessoProducaoService;

@Service
@RequiredArgsConstructor
public class BuncherConsume {
	
	private final OrdemProcessoProducaoService ordemService;
	
	
	@RabbitListener(queues = "queue-bunchers")
	public void emissaoPedido(@Payload String payload) {
		
		try {
			
			var objectMapper = new ObjectMapper();
			
			PedidoLiberadoParaProcesso processo = objectMapper.readValue(payload, PedidoLiberadoParaProcesso.class);
			
			
			ListCb.iniciar();
			CBAbstract cb =  ListCb.getInstance(processo.getName());
			cb.inserirQuantidadeTotalPedido(processo.getQuantidade());
			
			var ordem = new OrdemProcessoProducao();
			
			ordem.setName(cb.getName());
			ordem.setFormacao(cb.getFormacao());
			ordem.setDiametroCorda(cb.getDiametroCorda());
			ordem.setPassoMaximo(cb.getPassoMaximo());
			ordem.setPassoMinimo(cb.getPassoMinimo());
			ordem.setDirecao(cb.getDirecao());
			ordem.setQuantidade(cb.getQuantidade());
			ordem.setCapacidadeMAximaBobina(cb.getCapacidadeMAximaBobina());
			ordem.setMaquina(cb.getMaquina());
			ordem.setQuantidadeTotalPedido(cb.getQuantidadeTotalPedido());
			ordem.setQuantidadeBobina(cb.getQuantidadeBobina());
			ordem.setQuantidadeCarga(cb.getQuantidadeCarga());
			ordem.setQuantidadeRestante(cb.getQuantidadeRestante());
			
			ordemService.saveOrdemProcessoProducao(ordem);
			
			
			
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
