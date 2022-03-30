package digytal.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.springboot.restapi.dto.NovoCorrentista;
import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.repository.CorrentistaRepository;
import digytal.springboot.restapi.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaService service;
    
    @Autowired
    private CorrentistaRepository repository;
    
    @PostMapping
    public void gravar(@RequestBody NovoCorrentista correntista){
        service.gravar(correntista);
    }
    @GetMapping
    public List<Correntista> listarTodos(){
    	return repository.findAll();
    }
}
