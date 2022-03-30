package digytal.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.springboot.restapi.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    
}
