package wg.mspedido.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import wg.mspedido.domain.Pedido;
import wg.mspedido.dtos.PedidoDto;
import wg.mspedido.services.PedidoService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	private final PedidoService pedidoService;
	

	@GetMapping
	public String status() {
		return "GetMapping pedidos Ok";
	}

	@GetMapping(value = "consultar-pedidos")
	public ResponseEntity<List<Pedido>> findAll() {

		List<Pedido> pedidos = pedidoService.findAll();

		return ResponseEntity.ok(pedidos);
	}

	@GetMapping(params = "idpedido")
	public ResponseEntity<Pedido> findByIdPedido(@RequestParam("idpedido") Long idpedido) {

		Pedido pedido = pedidoService.findByIdPedido(idpedido);

		return ResponseEntity.ok().body(pedido);
	}

	@PostMapping
	public ResponseEntity savePedido(@RequestBody PedidoDto pedidoDto) throws JsonProcessingException {

		Pedido pedido = pedidoDto.toModel();

		pedidoService.savePedido(pedido);


		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@DeleteMapping(params = "idpedido")
	public ResponseEntity<Void> deletarPedido(@RequestParam("idpedido") Long idpedido) {

		pedidoService.deletarPedidoPorId(idpedido);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(params = "idpedido")
	public ResponseEntity<PedidoDto> alteraPedido(@RequestParam("idpedido") Long idpedido, @RequestBody PedidoDto pedidoDto) {

		Pedido pedido = pedidoDto.toModel();
		pedidoService.alteraPedido(idpedido, pedido);

		return ResponseEntity.ok().body(pedidoDto);
	}


}
