package digytal.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import digytal.springboot.restapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    
}
