package digytal.springboot.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.springboot.restapi.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    public List<Correntista> findByNomeContaining(String nome);
}
