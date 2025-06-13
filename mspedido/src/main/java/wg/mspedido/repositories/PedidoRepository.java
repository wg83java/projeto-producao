package wg.mspedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import wg.mspedido.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
