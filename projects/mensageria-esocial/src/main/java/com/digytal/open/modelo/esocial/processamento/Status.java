package com.digytal.open.modelo.esocial.processamento;

public class Status {
    private int cdResposta;
	private String descResposta;
    private Integer tempoEstimadoConclusao;
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
    public Integer getTempoEstimadoConclusao() {
        return tempoEstimadoConclusao;
    }
    public void setTempoEstimadoConclusao(Integer value) {
        this.tempoEstimadoConclusao = value;
    }
    
}
