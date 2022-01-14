package com.digytal.open.modelo.esocial.processamento.evento.retorno;

public class TRetornoEvento {
	private TIdeEmpregador ideEmpregador;
	private TDadosRecepcao recepcao;
	private TDadosProcessamentoEvento processamento;
	private TDadosRecibo recibo;
	
	public TIdeEmpregador getIdeEmpregador() {
		return ideEmpregador;
	}
	public void setIdeEmpregador(TIdeEmpregador ideEmpregador) {
		this.ideEmpregador = ideEmpregador;
	}
	
	public TDadosRecepcao getRecepcao() {
		return recepcao;
	}
	public void setRecepcao(TDadosRecepcao recepcao) {
		this.recepcao = recepcao;
	}
	
	public TDadosProcessamentoEvento getProcessamento() {
		return processamento;
	}
	public void setProcessamento(TDadosProcessamentoEvento processamento) {
		this.processamento = processamento;
	}
	public TDadosRecibo getRecibo() {
		return recibo;
	}
	public void setRecibo(TDadosRecibo recibo) {
		this.recibo = recibo;
	}
	@Override
	public String toString() {
		return "TRetornoEvento [ideEmpregador=" + ideEmpregador + ", recepcao=" + recepcao + ", processamento="
				+ processamento + ", recibo=" + recibo + "]";
	}
	
}
