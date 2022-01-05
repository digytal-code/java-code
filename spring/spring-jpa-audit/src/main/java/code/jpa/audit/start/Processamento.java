package code.jpa.audit.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import code.jpa.audit.model.Cidade;
import code.jpa.audit.model.Cliente;
import code.jpa.audit.model.Endereco;
import code.jpa.audit.repository.CidadeRepository;
import code.jpa.audit.repository.ClienteRepository;

@Component
public class Processamento {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private static final int IBGE = 2211001;
	
	public void cargaInicial() {
		if(!cidadeRepository.existsById(IBGE)) {
			Cidade cidade = new Cidade();
			cidade.setId(IBGE);
			cidade.setNome("TERESINA");
			cidadeRepository.save(cidade);
			
			Cliente cliente = new Cliente();
			cliente.setCpf("123");
			cliente.setNome("GLEYSON SAMPAIO");
			cliente.setCidade(cidade);

			Endereco endereco = new Endereco();
			endereco.setCep(7867456);
			endereco.setLogradouro("AV NOSSA SENHORA");
			cliente.setEndereco(endereco);
			
			clienteRepository.save(cliente);
			
			cliente = new Cliente();
			cliente.setCpf("456");
			cliente.setNome("MARCOS P SILVA");
			cliente.setCidade(cidade);

			endereco = new Endereco();
			endereco.setCep(876786);
			endereco.setLogradouro("RUA DAS JAZIRAS");
			cliente.setEndereco(endereco);
			
			clienteRepository.save(cliente);	
		}
	}

	public void alteraCidade() {
		System.out.println("---------- ALTERANDO CIDADE ----------");
		
		Cidade cidade = new Cidade();
		cidade.setId(IBGE);
		cidade.setNome("TERESINA PIAUI");
		
		cidadeRepository.save(cidade);
	}

	public void alteraCliente() throws Exception {
		System.out.println("---------- ALTERANDO CLIENTE ----------");
		
		Cliente clienteDoBancoDeDados = clienteRepository.findByCpf("123"); 

		if(clienteDoBancoDeDados != null) {			
			Endereco endereco = new Endereco();
			endereco.setCep(clienteDoBancoDeDados.getEndereco().getCep());
			endereco.setCep(988678);
			endereco.setLogradouro("RUA JOSE FIRMINO");
			
			Cliente cliente = new Cliente();
			cliente.setId(clienteDoBancoDeDados.getId());
			cliente.setNome("GLEYSON SAMPAIO DE OLIVEIRA");
			cliente.setCpf(clienteDoBancoDeDados.getCpf());
			cliente.setCidade(clienteDoBancoDeDados.getCidade());
			cliente.setEndereco(endereco);
			
			clienteRepository.save(cliente);
		}
	}
}
