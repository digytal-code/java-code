package com.digytal.open.modelo.esocial.processamento;

public class IdeEmpregador {
    private int tpInsc;
    private String nrInsc;

    public int getTpInsc() {
        return tpInsc;
    }
    public void setTpInsc(int value) {
        this.tpInsc = value;
    }
    public String getNrInsc() {
        return nrInsc;
    }
    public void setNrInsc(String value) {
        this.nrInsc = value;
    }
	@Override
	public String toString() {
		return "IdeEmpregador [tpInsc=" + tpInsc + ", nrInsc=" + nrInsc + "]";
	}
}
