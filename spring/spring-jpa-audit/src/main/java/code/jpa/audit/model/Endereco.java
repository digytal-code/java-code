package code.jpa.audit.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String logradouro;
	private Integer cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Integer getCep() {
		return cep;
	}
	
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "Dados do endereço\n"
		     + "\tLogradouro = " + logradouro + "\n"
		     + "\tCEP = " + cep;
	}
	
}
