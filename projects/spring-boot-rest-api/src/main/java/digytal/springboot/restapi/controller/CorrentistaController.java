package digytal.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.springboot.restapi.model.Correntista;
import digytal.springboot.restapi.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaService service;
    @PostMapping
    public void gravar(@RequestBody Correntista correntista){
        service.gravar(correntista);
    }
}
