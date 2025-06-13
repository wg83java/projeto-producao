package wg.mspedido.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import wg.mspedido.domain.Produto;
import wg.mspedido.repositories.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	
	public Produto saveProduto(Produto produto) {
		
		return produtoRepository.save(produto);
	}


	public Produto findByIdProduto(Long idproduto) {
		
		return produtoRepository.getReferenceById(idproduto);
	}


	public List<Produto> findAll() {
		
		return produtoRepository.findAll();
	}
	
	

}
