package wg.mspedido.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@JoinColumn(name = "id_produto")
	private String nameproduto;
	private LocalDate data;
	private String cor;
	private Integer quantidade;
	
	public Pedido(String nameproduto,String cor,Integer quantidade) {
		this.nameproduto = nameproduto;
		this.data = LocalDate.now();
		this.cor = cor;
		this.quantidade = quantidade;
	}
	
	
	

}
