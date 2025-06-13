package wg.msextrusora;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableFeignClients
public class MsextrusoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsextrusoraApplication.class, args);
	}

}
