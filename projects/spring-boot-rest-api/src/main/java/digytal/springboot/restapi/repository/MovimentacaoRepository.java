package digytal.springboot.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.springboot.restapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    public List<Movimentacao> findByIdConta(Integer idConta);
}
