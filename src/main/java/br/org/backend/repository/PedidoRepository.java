package br.org.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.backend.model.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>
{

}
