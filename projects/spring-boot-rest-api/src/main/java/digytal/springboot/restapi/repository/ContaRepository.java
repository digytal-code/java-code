package digytal.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.springboot.restapi.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
}
