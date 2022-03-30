package digytal.springboot.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	@Autowired
    private CorrentistaRepository correntistaRepository;
    public void gravar(Correntista correntista){
        correntistaRepository.saveAndFlush(correntista);
        System.out.println("Este é o id do correntista salvo: " + correntista.getId());
    }
}
