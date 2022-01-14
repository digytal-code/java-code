package com.digytal.open.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DataHora implements DataHoraConstants {
	public static int get(Date data, int atributo, Locale localizacao) {
		Calendar calendar = Calendar.getInstance(localizacao);
		calendar.setTime(data);
		int get = calendar.get(atributo);
		get=atributo==MES?get+1:get;
		return get;
	}
	public static int get(Date data, int atributo) {
		return get(data, atributo, LOCALIZACAO);
	}
	public static int dia(Date data) {
		return get(data,DIA);
	}
	public static int dia() {
		return get(new Date(),DIA);
	}
	public static int mes(Date data) {
		return get(data,MES);
	}
	public static int mes() {
		return get(new Date(),MES);
	}
	public static int ano(Date data) {
		return get(data,ANO);
	}
	public static int ano() {
		return get(new Date(),ANO);
	}
	public static int hora(Date data) {
		return get(data,HORA);
	}
	public static int minuto(Date data) {
		return get(data,MINUTO);
	}
	public static int segundo(Date data) {
		return get(data,SEGUNDO);
	}
	public static int periodo(Date data) {
		return Integer.valueOf(Formatador.formatar(DataHora.ano(data),"0000") + Formatador.formatar(DataHora.mes(data),"00"));
	}
}
