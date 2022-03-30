package digytal.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digytal.springboot.restapi.service.BancoService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private BancoService service;
    public 
}
