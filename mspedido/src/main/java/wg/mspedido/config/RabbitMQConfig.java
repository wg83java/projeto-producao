package wg.mspedido.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	

	public static String EXG_NAME_MARKETPLACE = "exg-producao";
	public static String QUEUE_PRODUCT_LOG = "queue-controller";
	public static String RK_PRODUCT_LOG = "pedido";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_PRODUCT_LOG,false,false,false);
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(EXG_NAME_MARKETPLACE,false,false);
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(directExchange())
				.with(RK_PRODUCT_LOG);
	}


}
