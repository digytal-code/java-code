package digytal.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.springboot.restapi.dto.NovaMovimentacao;
import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.model.Movimentacao;
import digytal.springboot.restapi.repository.MovimentacaoRepository;
import digytal.springboot.restapi.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoService service;
	
	@Autowired
	private MovimentacaoRepository repository;

	@PostMapping
	public void gravar(@RequestBody NovaMovimentacao movimentacao) {
		service.gravar(movimentacao);
	}
	@GetMapping("/{idConta}")
    public List<Movimentacao> listarMovimentacoes(@PathVariable("idConta") Integer idConta){
    		return repository.findByIdConta(idConta);
    }
}
