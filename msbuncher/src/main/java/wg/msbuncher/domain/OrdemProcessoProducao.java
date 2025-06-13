package wg.msbuncher.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdemProcessoProducao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

}
