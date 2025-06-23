package wg.msextrusora.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import wg.msextrusora.domain.Pedido;
import wg.msextrusora.repositories.PedidoFeign;
import wg.msextrusora.services.exceptions.ErroComunicacaoMicroserviceException;
import wg.msextrusora.services.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoFeign feign;

	public Pedido obterPedido(Long id) {

		try{
			ResponseEntity<Pedido> pedido = feign.findByIdPedido(id);
	

		   return pedido.getBody();
		}catch(FeignException.FeignClientException e) {
			int status = e.status();
			
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new ResourceNotFoundException(id);
			}
			throw new ErroComunicacaoMicroserviceException(e.getMessage(), status);
		}

	}

	public List<Pedido> separarPedido(List<Pedido> pedidos) {

		String[] cores = { "branco", "verde", "amarelo", "azul", "preto", "vermelho", "veia", "epr" };
		List<Pedido> pedidoseparados = new ArrayList<>();
		Integer quantidade = 0;

		for (String cor : cores) {
			for (Pedido pedido : pedidos) {
				if (cor.equals(pedido.getCor())) {
					quantidade += pedido.getQuantidade();

				}

			}

			Pedido p1 = new Pedido();
			p1.setCor(cor);
			p1.setQuantidade(quantidade);
			pedidoseparados.add(p1);

			quantidade = 0;

		}
		return pedidoseparados;

	}
}
