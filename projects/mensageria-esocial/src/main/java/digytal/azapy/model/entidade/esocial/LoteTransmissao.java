package digytal.azapy.model.entidade.esocial;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoteTransmissao {
	@Column(name="cd_resposta",length=50)
	private Integer cdResposta;
	@Column(name="ds_resposta",length=3000)
	private String descResposta;
	@Column(name="nr_protocolo",length=50)
	private String protocoloEnvio;
	public LoteTransmissao() {
		cdResposta=0;
		descResposta="";
		protocoloEnvio="";
	}
	public Integer getCdResposta() {
		return cdResposta;
	}
	public void setCdResposta(Integer cdResposta) {
		this.cdResposta = cdResposta;
	}
	public String getDescResposta() {
		return descResposta;
	}
	public void setDescResposta(String descResposta) {
		this.descResposta = descResposta;
	}
	public String getProtocoloEnvio() {
		return protocoloEnvio;
	}
	public void setProtocoloEnvio(String protocoloEnvio) {
		this.protocoloEnvio = protocoloEnvio;
	}
	
}
