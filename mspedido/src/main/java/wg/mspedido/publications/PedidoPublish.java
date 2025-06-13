package wg.mspedido.publications;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import wg.mspedido.domain.OrdemPedido;

@Component
@RequiredArgsConstructor
public class PedidoPublish {
	
	private final RabbitTemplate rabbitTemplate;
	
	
	public void publicarPedido(OrdemPedido ordemPedido) throws JsonProcessingException {
		
		var json = converteParaJson(ordemPedido);
		rabbitTemplate.convertAndSend(wg.mspedido.config.RabbitMQConfig.EXG_NAME_MARKETPLACE,wg.mspedido.config.RabbitMQConfig.RK_PRODUCT_LOG,json);
		
	}
	
	public String converteParaJson(OrdemPedido ordemPedido) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(ordemPedido);
		return json;
	}
	

}
