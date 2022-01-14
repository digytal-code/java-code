package com.digytal.open.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.digytal.open.modelo.enums.esocial.TipoEvento;

public class ESocialUtil {
	
	public static String tagEventoId(TipoEvento tipo, String id){
		return String.format("<%s Id=\"%s\">", tipo.getNome(),id);
	}
	public static String esocialEventoId(String cpfCnpj,Integer sequencia){
		StringBuffer id = new StringBuffer("ID");
		id.append(1);//TORNAR PARAMETRO
		id.append(formatarCpfCnpj(cpfCnpj));
		id.append(formatarDataIdEvento(new Date()));
		id.append(formatarSequencia(sequencia));
		return id.toString();
	}
	public static String formatarCpfCnpj(String cpfCnpj){
		cpfCnpj = cpfCnpj.replaceAll("[\\D]", "");
		int zeros = 14 - cpfCnpj.length();
		if(zeros > 0)
			cpfCnpj= cpfCnpj + String.format("%0" +zeros + "d", 0);
		return cpfCnpj;
	}
	public static String formatarSequencia(Integer numero){
		return String.format("%02d", numero);
	}
	public static String formatarDataIdEvento(Date data){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(data);
	}
	public static String formatarData(Date data, String formato){
		return new SimpleDateFormat(formato).format(data);
	}
	
}
