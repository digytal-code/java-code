package digytal.azapy.model.esocial.processamento;

import javax.persistence.PrePersist;
public class RetornoProcessamentoLoteEventos {
	private IdeEmpregador ideEmpregador;
	private IdeTransmissor ideTransmissor;
	private Status status;
	private DadosRecepcaoLote dadosRecepcaoLote ;
	private DadosProcessamentoLote dadosProcessamentoLote ;
	private RetornoEventos retornoEventos;
	public IdeEmpregador getIdeEmpregador() {
		return ideEmpregador;
	}
	public void setIdeEmpregador(IdeEmpregador ideEmpregador) {
		this.ideEmpregador = ideEmpregador;
	}
	
	public IdeTransmissor getIdeTransmissor() {
		return ideTransmissor;
	}
	public void setIdeTransmissor(IdeTransmissor ideTransmissor) {
		this.ideTransmissor = ideTransmissor;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public DadosRecepcaoLote getDadosRecepcaoLote() {
		return dadosRecepcaoLote;
	}
	public void setDadosRecepcaoLote(DadosRecepcaoLote dadosRecepcaoLote) {
		this.dadosRecepcaoLote = dadosRecepcaoLote;
	}
	public DadosProcessamentoLote getDadosProcessamentoLote() {
		return dadosProcessamentoLote;
	}
	public void setDadosProcessamentoLote(DadosProcessamentoLote dadosProcessamentoLote) {
		this.dadosProcessamentoLote = dadosProcessamentoLote;
	}
	public RetornoEventos getRetornoEventos() {
		return retornoEventos;
	}
	public void setRetornoEventos(RetornoEventos retornoEventos) {
		this.retornoEventos = retornoEventos;
	}
	
}
