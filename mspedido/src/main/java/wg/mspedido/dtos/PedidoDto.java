package wg.mspedido.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import wg.mspedido.domain.Pedido;
import wg.mspedido.enums.Tipo;

@Data
@AllArgsConstructor
public class PedidoDto {
	
	private Long idproduto;
	private Tipo tipo;
	private String cor;
	private Integer quantidade;
	
	public Pedido toModel() {
		
		return new Pedido(idproduto,tipo,cor,quantidade);
	}
	
	
	
}
