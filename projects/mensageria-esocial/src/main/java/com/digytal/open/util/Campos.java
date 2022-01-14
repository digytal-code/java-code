package com.digytal.open.util;

public class Campos {
	private String label;
	private String atributo;
	public String getLabel() {
		return label;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public Campos(String label) {
		this(label,label.toLowerCase());
	}
	public Campos(String label, String atributo) {
		this.label = label;
		this.atributo = atributo;
	}
	
}
