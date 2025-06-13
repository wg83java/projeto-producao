package wg.mscontrole.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private Long id;
	private String idcliente;
	private String name;
	private String tipo;
	private String cor;
	private Integer quantidade;
	private BigDecimal valor;
	
	


}
