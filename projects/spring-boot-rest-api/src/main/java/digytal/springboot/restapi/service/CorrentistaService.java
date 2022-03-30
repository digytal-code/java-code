package digytal.springboot.restapi.service;

import org.springframework.stereotype.Service;

import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
    private CorrentistaRepository correntistaRepository;
    public void salvarConta(Correntista correntista){
        correntistaRepository.saveAndFlush(correntista);
        System.out.println("Este é o id do correntista salvo: " + correntista.getId());
    }
}
