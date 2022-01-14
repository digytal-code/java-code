package com.digytal.open.modelo.entidade.esocial;

import java.util.HashMap;
import java.util.Map;

public class LoteEventoConsulta {
	private String evento; 
	private String recibo;
	private String hash;
	private Map<Integer,String> ocorrecias;
	public LoteEventoConsulta() {
		ocorrecias = new HashMap<Integer,String>();
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getRecibo() {
		return recibo;
	}
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public void addOcorrencia(Integer id,String descricao) {
		ocorrecias.put(id, descricao);
	}
	public Map<Integer, String> getOcorrecias() {
		return ocorrecias;
	}
	
}
