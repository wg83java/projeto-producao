package wg.mspedido.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wg.mspedido.domain.Produto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
	
	private String name;
	
	
	
	public Produto toModel() {
		
		return new Produto(name);
	}

}
