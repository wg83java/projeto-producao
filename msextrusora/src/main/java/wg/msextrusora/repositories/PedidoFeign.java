package wg.msextrusora.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wg.msextrusora.domain.Pedido;

@FeignClient(value = "mspedido", path = "/pedidos")
public interface PedidoFeign {
	
	
	@GetMapping(params = "idpedido")
	public ResponseEntity<Pedido> findByIdPedido(@RequestParam("idpedido") Long idpedido);

}
