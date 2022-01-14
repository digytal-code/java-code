package com.digytal.open.modelo.esocial.processamento.evento.retorno;

import java.util.Date;

public class TDadosRecepcao {

    private short tpAmb;
    private Date dhRecepcao;
    private String versaoAppRecepcao;
    private String protocoloEnvioLote;

    public short getTpAmb() {
        return tpAmb;
    }

   
    public void setTpAmb(short value) {
        this.tpAmb = value;
    }

   
    public Date getDhRecepcao() {
        return dhRecepcao;
    }

   
    public void setDhRecepcao(Date value) {
        this.dhRecepcao = value;
    }

  
    public String getVersaoAppRecepcao() {
        return versaoAppRecepcao;
    }

    public void setVersaoAppRecepcao(String value) {
        this.versaoAppRecepcao = value;
    }

    public String getProtocoloEnvioLote() {
        return protocoloEnvioLote;
    }

   
    public void setProtocoloEnvioLote(String value) {
        this.protocoloEnvioLote = value;
    }


	@Override
	public String toString() {
		return "TDadosRecepcao [tpAmb=" + tpAmb + ", dhRecepcao=" + dhRecepcao + ", versaoAppRecepcao="
				+ versaoAppRecepcao + ", protocoloEnvioLote=" + protocoloEnvioLote + "]";
	}

}
