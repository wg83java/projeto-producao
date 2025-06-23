package wg.mspedido.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import wg.mspedido.domain.Pedido;

@Data
@AllArgsConstructor
public class PedidoDto {
	
	private String nameproduto;;
	private String cor;
	private Integer quantidade;
	
	public Pedido toModel() {
		
		return new Pedido(nameproduto,cor,quantidade);
	}
	
	
	
}
