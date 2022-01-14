package com.digytal.open.util.model;

import java.util.List;

public interface Menu{
	public String getNome();
	public List getItens();
	public Menu getPai();
	public String getOrdem();
	public Funcionalidade getFuncionalidade();
	
}
