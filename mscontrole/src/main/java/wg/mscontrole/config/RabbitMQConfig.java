package wg.mscontrole.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	public static final String EXG_NAME_PRODUCAO = "exg-producao";
	public static final String QUEUE_PRODUCT_BUNCHER = "queue-bunchers";
	public static final String QUEUE_PRODUCT_TORCEDEIRA = "queue-torcedeiras";
	public static final String QUEUE_PRODUCT_EXTRUSORA = "queue-extrusoras";
	public static final String RK_ROUTING_KEY_ORDEM_PEDIDO= "ordempedido";
	public static final String QUEUE_CONSUMER_CONTROLLER = "queue-controller";
	
  
    	   
	@Bean
	public Queue queueBUNCHER() {
		
			return new Queue(QUEUE_PRODUCT_BUNCHER,false,false,false);
	}
	
	@Bean
	public Queue queueTORCEDEIRA() {
		
			return new Queue(QUEUE_PRODUCT_TORCEDEIRA,false,false,false);
	}
	
	@Bean
	public Queue queueExtrusora() {
		
		return new Queue(QUEUE_PRODUCT_EXTRUSORA,false,false,false);
	}
	
	@Bean
	public Binding binding3() {
		
		return BindingBuilder
			   .bind(queueExtrusora())
			   .to(directExchange())
			   .with(RK_ROUTING_KEY_ORDEM_PEDIDO);
	}
	
	
	@Bean
	public Binding binding1() {
		
		return BindingBuilder
				.bind(queueBUNCHER())
				.to(directExchange())
				.with(RK_ROUTING_KEY_ORDEM_PEDIDO);
	}
	
	@Bean
	public Binding binding2() {
		
		return BindingBuilder
				.bind(queueTORCEDEIRA())
				.to(directExchange())
				.with(RK_ROUTING_KEY_ORDEM_PEDIDO);
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(EXG_NAME_PRODUCAO,false,false);
	}
   
	

}
