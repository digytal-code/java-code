package com.digytal.open.util;

import java.util.Objects;

import org.jasypt.util.text.BasicTextEncryptor;

public class Criptografia {
	public static final String CHAVE_PRIVADA=Objects.toString(System.getProperty("app.private.key"),"FluxsKey");
	public static String criptografar(String texto, String chavePrivada) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPasswordCharArray(chavePrivada.toCharArray());
		return encryptor.encrypt(texto);
	}
	public static String criptografar(String texto) {
		return criptografar(texto, CHAVE_PRIVADA);
	}
	public static String decriptografar(String texto, String chavePrivada) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPasswordCharArray(chavePrivada.toCharArray());
		return encryptor.decrypt(texto);
	}
	public static String decriptografar(String texto) {
		return decriptografar(texto);
	}
}
