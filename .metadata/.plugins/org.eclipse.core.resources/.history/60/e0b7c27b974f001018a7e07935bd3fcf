package wg.msbuncher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CB6mm extends CBAbstract{
	
	
	private String name = "CABO FLEXIVEL 1 X 6MM";
	private String direcao = "ESQUERDA";
	private String maquina = "105 & 106";
	private String formacao = "42 x 0,401 mm";
	private String passoMinimo = "26,40 mm";
	private String passoMaximo = "181,10 mm";
	private String diametroCorda = "4,60-MM mm";
	private Integer quantidadeBobina;
	private Integer quantidade;
	private Integer quantidadeTotalPedido;
	private Integer capacidadeMaxBobina = 8500;
	private Integer quantidadeRestante;
	
	@Override
	public void inserirQuantidadeTotalPedido(Integer quantidadePedido) {
		
		if(quantidadePedido > capacidadeMaxBobina) {
			
			this.quantidadeTotalPedido = quantidadePedido;
			this.quantidadeBobina = quantidadeTotalPedido / capacidadeMaxBobina;
			this.quantidade = capacidadeMaxBobina;
		}else {
			this.quantidadeBobina = 1;
			this.quantidadeTotalPedido = quantidadePedido;
			this.quantidade = quantidadeTotalPedido;
		}
		
		
	}

}
