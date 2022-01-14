
package com.digytal.open.modelo.esocial.processamento.evento;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.xml.bind.annotation.XmlRootElement;

import com.digytal.open.modelo.esocial.processamento.evento.retorno.TRetornoEvento;

@XmlRootElement(name = "eSocial")
@Embeddable
public class ESocial {
	@Embedded
	private TRetornoEvento retornoEvento;
	public TRetornoEvento getRetornoEvento() {
		return retornoEvento;
	}
	public void setRetornoEvento(TRetornoEvento retornoEvento) {
		this.retornoEvento = retornoEvento;
	}
}
