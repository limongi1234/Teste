package br.org.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.org.backend.model.Cliente;


public interface ClienteRepository extends JpaRepository <Cliente, Long>
{
	Cliente findByEmail(String email);
}
