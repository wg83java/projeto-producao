package wg.mscontrole.publications;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import wg.mscontrole.config.RabbitMQConfig;
import wg.mscontrole.domain.OrdemPedido;
import wg.mscontrole.domain.PedidoLiberadoParaProcesso;

@Component
@RequiredArgsConstructor
public class OrdemPedidoPublish {
	
	private final RabbitTemplate rabbitTemplate;
	
	
	public void publicarOrdemPedido(PedidoLiberadoParaProcesso ordemPedido) throws JsonProcessingException {
		
		var json = convertParaJson(ordemPedido);
		
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_PRODUCAO,RabbitMQConfig.RK_ROUTING_KEY_ORDEM_PEDIDO,json);
		
		
		
	}
	
	public String convertParaJson(PedidoLiberadoParaProcesso ordemPedido) throws JsonProcessingException {
		
		var objectMapper = new ObjectMapper();
		
		String json = objectMapper.writeValueAsString(ordemPedido);
		
		return json;
	}

}
