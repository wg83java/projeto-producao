package wg.mstorcedeira.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import wg.mstorcedeira.domain.OrdemProcessoProducao;
import wg.mstorcedeira.services.OrdemProcessoProducaoService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/torcedeiras")
public class OrdemProcessoProducaoResource {
	
	private final OrdemProcessoProducaoService ordemService;
	
	@GetMapping
	public ResponseEntity<List<OrdemProcessoProducao>> findAll(){
		
		List<OrdemProcessoProducao> ordens= ordemService.findAll();
		
		return ResponseEntity.ok(ordens);
		
	}
	
	
	

}
