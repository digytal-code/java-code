package digytal.springboot.restapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digytal.springboot.restapi.dto.NovaMovimentacao;
import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.model.Movimentacao;
import digytal.springboot.restapi.model.TipoMovimentacao;
import digytal.springboot.restapi.repository.CorrentistaRepository;
import digytal.springboot.restapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	
	@Transactional
	public void gravar(NovaMovimentacao novaMovimentacao){
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista!=null) {
			Double valor = novaMovimentacao.getValor();
			TipoMovimentacao tipo = novaMovimentacao.getTipo();
			valor = tipo==TipoMovimentacao.CREDITO? valor : valor * -1;
			Movimentacao movimentacao = new Movimentacao();
			movimentacao.setDataHora(LocalDateTime.now());
			movimentacao.setIdConta(novaMovimentacao.getIdConta());
			movimentacao.setDescricao(novaMovimentacao.getDescricao());
			movimentacao.setValor(novaMovimentacao.getValor());
			movimentacao.setTipo(tipo);
			
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			repository.save(movimentacao);
			correntistaRepository.save(correntista);
		}
	
	}
}
