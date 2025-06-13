package wg.mstorcedeira.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CB50mm extends CBAbstract{
	

	private String name = "FEIXE DE COBRE NU P/CABO 50MM";
	private String direcao = "ESQUERDA";
	private String maquina = "119";
	private String formacao = "51 x 0,401 mm";
	private String passoMinimo = "?";
	private String passoMaximo = "?";
	private String diametroCorda = "3,30 mm";
	private Integer quantidadeBobina = 7;
	private Integer quantidade;
	private Integer quantidadeTotalPedido;
	private Integer capacidadeMAximaBobina = 7400;
	private Integer quantidadeCarga;
	private Integer quantidadeRestante;
	
	
	@Override
	public void inserirQuantidadeTotalPedido(Integer quantidadeTotalPedido) {
		this.quantidadeTotalPedido = quantidadeTotalPedido;
		
		if(quantidadeTotalPedido > capacidadeMAximaBobina) {
			this.quantidadeCarga = quantidadeTotalPedido / capacidadeMAximaBobina;
			this.quantidadeBobina = quantidadeCarga * 7;
			this.quantidadeRestante = capacidadeMAximaBobina * quantidadeCarga - quantidadeTotalPedido;
			this.quantidade = quantidadeTotalPedido / quantidadeBobina;
			
		}else {
			this.quantidadeCarga = 1;
			this.quantidade = quantidadeTotalPedido;
			
		}
	}

}
