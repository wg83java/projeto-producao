package wg.msextrusora.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CB50mm extends CBAbstract {
	
	private String maquina = "EXTRUSORA";
	private String name = "CABO FLEXIVEL 1 X 50MM ";
	private String formacao = "51 X 0,401";
	private String diametro = " diametro cabo";
	private Integer quantidadeMaxBobina = 1000;
	private Integer quantidadeTotal;
	private Integer quantidadeBobina;
	private Integer quantidade;
	private String cor;
	
	@Override
	public void inserirQuantidadeTotalPedido(Integer quantidadePedido) {
		
		if(quantidadePedido > quantidadeMaxBobina) {
			
			this.quantidadeTotal = quantidadePedido;
			this.quantidadeBobina = quantidadeTotal / quantidadeMaxBobina;
			this.quantidade = quantidadeTotal / quantidadeBobina;
			
		}else {
			this.quantidadeTotal = quantidadePedido;
			this.quantidadeBobina = 1;
			this.quantidade = quantidadePedido;
			
		}
		
		
	}

}
