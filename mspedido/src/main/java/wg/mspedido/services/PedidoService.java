package wg.mspedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import wg.mspedido.domain.Pedido;
import wg.mspedido.repositories.PedidoRepository;
import wg.mspedido.services.exceptions.ResourceNotFondException;

@Service
@RequiredArgsConstructor
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	
	public List<Pedido> findAll(){
		
		return pedidoRepository.findAll();
	}
	
	public Pedido findByIdPedido(Long idpedido) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(idpedido);
		
		return pedido.orElseThrow(()-> new ResourceNotFondException(idpedido));
	}
	
	@Transactional
	public Pedido savePedido(Pedido pedido) throws JsonProcessingException {
		try {
			
			pedidoRepository.save(pedido);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return pedido;
	}
	

	
	

}
