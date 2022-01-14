
package com.digytal.open.modelo.esocial.processamento;

import java.util.Date;


public class DadosRecepcaoLote {
    private Date dhRecepcao;
    private String versaoAplicativoRecepcao;
    private String protocoloEnvio;
    public Date getDhRecepcao() {
        return dhRecepcao;
    }
    public void setDhRecepcao(Date value) {
        this.dhRecepcao = value;
    }
    public String getVersaoAplicativoRecepcao() {
        return versaoAplicativoRecepcao;
    }
    public void setVersaoAplicativoRecepcao(String value) {
        this.versaoAplicativoRecepcao = value;
    }
    public String getProtocoloEnvio() {
        return protocoloEnvio;
    }
    public void setProtocoloEnvio(String value) {
        this.protocoloEnvio = value;
    }
	
}
