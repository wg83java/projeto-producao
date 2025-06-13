package wg.mscontrole.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wg.mscontrole.domain.ControllerPedido;

public interface ControllerPedidoRepository extends JpaRepository<ControllerPedido, Long>{
	
	List<ControllerPedido> findByName(String name);

}
