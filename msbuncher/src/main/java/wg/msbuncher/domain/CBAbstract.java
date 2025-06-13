package wg.msbuncher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class CBAbstract {
	
	private String name;
	private String direcao;
	private String maquina;
	private String formacao;
	private String passoMinimo;
	private String passoMaximo;
	private String diametroCorda;
	private Integer quantidadeBobina;
	private Integer quantidade;
	private Integer quantidadeTotalPedido;
	private Integer capacidadeMAximaBobina;
	private Integer quantidadeCarga;
	private Integer quantidadeRestante;
	

	public void inserirQuantidadeTotalPedido(Integer quantidadeTotalPedido) {
		
	}
	



}
