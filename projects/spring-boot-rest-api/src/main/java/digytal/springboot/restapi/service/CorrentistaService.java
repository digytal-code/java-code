package digytal.springboot.restapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digytal.springboot.restapi.dto.NovoCorrentista;
import digytal.springboot.restapi.model.Conta;
import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	@Autowired
    private CorrentistaRepository correntistaRepository;
    @Transactional
	public void gravar(NovoCorrentista novoCorrentista){
    	//poderia ter uma validação de não salvar com mesmo CPF
    	Conta conta = new Conta();
        conta.setNumero(new Date().getTime());
        conta.setSaldo(0.0);
        
        //aqui poderia ter frameworks de conversao automatica
        Correntista correntista = new Correntista();
        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setConta(conta);
        
    	correntistaRepository.save(correntista);
        
    }
}
