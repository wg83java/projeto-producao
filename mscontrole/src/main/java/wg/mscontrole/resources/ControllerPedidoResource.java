package wg.mscontrole.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import wg.mscontrole.domain.ControllerPedido;
import wg.mscontrole.domain.PedidoLiberadoParaProcesso;
import wg.mscontrole.publications.OrdemPedidoPublish;
import wg.mscontrole.services.ControllerService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/controllers")
public class ControllerPedidoResource {
	
	private final ControllerService controllerService;
	private final OrdemPedidoPublish publicar;
	
	@GetMapping
	public ResponseEntity<List<ControllerPedido>> findAll(){
		
		List<ControllerPedido> pedidos = controllerService.findAll();
		
		return ResponseEntity.ok(pedidos);
	}
	
	@GetMapping(params = "produto")
	public ResponseEntity<List<ControllerPedido>> verificarProduto(@RequestParam("produto") String nameProduto) throws JsonProcessingException{
		
		Integer maxQuantidade = 0;
		
		List<ControllerPedido> pedidos = controllerService.findByNameProduto(nameProduto);
		List<Long> idpedidos = new ArrayList<>();
		List<Long> idcontroller = new ArrayList<>();
		
		for(ControllerPedido p : pedidos) {
			maxQuantidade += p.getQuantidade();
			idpedidos.add(p.getIdpedido());
			idcontroller.add(p.getId());
		}
		
		if(maxQuantidade >= 10) {
			PedidoLiberadoParaProcesso liberado = new PedidoLiberadoParaProcesso(idpedidos, nameProduto, maxQuantidade);
			
			publicar.publicarOrdemPedido(liberado);
			
			for(Long id : idcontroller) {
				controllerService.deleteById(id);
			}
			
			
		}
		
		return ResponseEntity.ok(pedidos);
	}
	

}
