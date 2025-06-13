package wg.mspedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import wg.mspedido.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	/*@Query("SELECT p FROM Produto p WHERE p.idcliente LIKE %:idcliente%")
	List<Produto> findByProduto(@Param("idcliente") String idcliente);*/

}
