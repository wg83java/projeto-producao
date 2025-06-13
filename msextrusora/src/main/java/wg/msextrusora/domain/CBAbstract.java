package wg.msextrusora.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class CBAbstract {
	
	private String maquina;
	private String name;
	private String formacao;
	private String diametro;
	private Integer quantidadeTotal;
	private Integer quantidadeBobina;
	private Integer quantidade;
	private String cor;
	
	
	public void inserirQuantidadaPedido(Integer quantidadePedido) {
		
	}

}
