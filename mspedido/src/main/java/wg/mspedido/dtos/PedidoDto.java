package wg.mspedido.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import wg.mspedido.domain.Pedido;

@Data
@AllArgsConstructor
public class PedidoDto {
	
	private Long idproduto;
	private String cor;
	private Integer quantidade;
	
	public Pedido toModel() {
		
		return new Pedido(idproduto,cor,quantidade);
	}
	
	
	
}
