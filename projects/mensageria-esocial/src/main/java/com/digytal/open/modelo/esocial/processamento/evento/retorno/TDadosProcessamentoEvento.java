
package com.digytal.open.modelo.esocial.processamento.evento.retorno;

import java.util.Date;

public class TDadosProcessamentoEvento {
	private int cdResposta;
	private String descResposta;
	private String versaoAppProcessamento;
	private Date dhProcessamento;

	private TOcorrencias ocorrencias;

	public int getCdResposta() {
		return cdResposta;
	}

	public void setCdResposta(int value) {
		this.cdResposta = value;
	}

	public String getDescResposta() {
		return descResposta;
	}

	public void setDescResposta(String value) {
		this.descResposta = value;
	}

	public String getVersaoAppProcessamento() {
		return versaoAppProcessamento;
	}

	public void setVersaoAppProcessamento(String value) {
		this.versaoAppProcessamento = value;
	}

	public Date getDhProcessamento() {
		return dhProcessamento;
	}

	public void setDhProcessamento(Date value) {
		this.dhProcessamento = value;
	}

	@Override
	public String toString() {
		return "TDadosProcessamentoEvento [cdResposta=" + cdResposta + ", descResposta=" + descResposta
				+ ", versaoAppProcessamento=" + versaoAppProcessamento + ", dhProcessamento=" + dhProcessamento + "]";
	}

	public TOcorrencias getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(TOcorrencias value) {
		this.ocorrencias = value;
	}

}
