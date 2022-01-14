package com.digytal.open.servico;

import java.util.List;

public interface Services {
	String API = "API";
	String JPA = "JPA";
	List listar(Class classe, String campo, Object valor);
}
