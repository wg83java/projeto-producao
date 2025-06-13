package wg.msbuncher.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoLiberadoParaProcesso {
	
	private List<Long> idpedido;
	private String name;
	private Integer quantidade;

}
