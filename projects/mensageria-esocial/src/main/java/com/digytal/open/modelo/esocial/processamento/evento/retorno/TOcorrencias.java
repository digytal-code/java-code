package com.digytal.open.modelo.esocial.processamento.evento.retorno;

import java.util.List;
public class TOcorrencias {
	private List<TOcorrencia> ocorrencia;
	public List<TOcorrencia> getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(List<TOcorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	@Override
	public String toString() {
		return "TOcorrencias [ocorrencia=" + ocorrencia + "]";
	}
    

}
