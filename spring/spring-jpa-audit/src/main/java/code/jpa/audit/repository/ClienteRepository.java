package code.jpa.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import code.jpa.audit.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Cliente findByCpf(String cpf);
}
