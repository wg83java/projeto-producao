package wg.msextrusora.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import wg.msextrusora.domain.CBAbstract;
import wg.msextrusora.domain.ListCb;
import wg.msextrusora.domain.OrdemProcessoProducao;
import wg.msextrusora.domain.Pedido;
import wg.msextrusora.domain.PedidoLiberadoParaProcesso;
import wg.msextrusora.repositories.PedidoRepository;
import wg.msextrusora.services.OrdemProcessoProducaoService;
import wg.msextrusora.services.PedidoService;

@Component
@RequiredArgsConstructor
public class ExtrusoraConsume {
	
	private final PedidoService pedidoService;
	private final OrdemProcessoProducaoService ordemService;
	private final PedidoRepository pedidoRepository;
	
	@RabbitListener(queues = "queue-extrusoras")
	public void emissaoPedido(@Payload String payload) {
		
		try {
			
			var objectMapper = new ObjectMapper();
			
			PedidoLiberadoParaProcesso processo = objectMapper.readValue(payload, PedidoLiberadoParaProcesso.class);
			
			//Recuperando pedidos por id
			List<Pedido> pedidos = new ArrayList<>();
						
			for(Long id : processo.getIdpedido()) {
				
				Pedido pedido = pedidoService.obterPedido(id);
				pedidos.add(pedido);			
				
			}
			//Separando pedidos por cor e somando quantidade para producao
			List<Pedido> pedidosSeparados = pedidoService.separarPedido(pedidos);		
			
			//iniciando a instancia do cabo recebido
			ListCb.iniciar();
			CBAbstract cb = ListCb.getInstance(processo.getName());
			cb.inserirQuantidadaPedido(processo.getQuantidade());
			
			//Realizando o processo de ordem para producao
			var ordem = new OrdemProcessoProducao();
			
			ordem.setName(cb.getName());
			ordem.setDiametro(cb.getDiametro());
			ordem.setFormacao(cb.getFormacao());
			ordem.setMaquina(cb.getMaquina());
			ordem.setQuantidadeBobina(cb.getQuantidadeBobina());
			ordem.setQuantidadeTotal(cb.getQuantidadeTotal());
			
			
			ordemService.saveOrdemProcessoProducao(ordem);
			
			//Obtendo os pedidos separados para processo
			for(Pedido rec : pedidosSeparados) {
				if(rec.getQuantidade() > 0) {
					Pedido novo = new Pedido(null,rec.getIdproduto(),rec.getTipo(),rec.getCor(),rec.getQuantidade(),ordem);
					
					pedidoRepository.save(novo);
				}
			}
					
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
