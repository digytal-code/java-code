package com.digytal.open.util.config;

import java.io.File;
import java.util.Objects;

import com.digytal.open.util.Criptografia;
import com.digytal.open.util.model.Sistema;

public class Configuracao {
	private static final String APP_HOME="app.home";
	//private static final String CONFIG="application.properties";
	
	public static final String CURRENT_VERSION="1.0";
	public static final String APP_SYSTEM="app.sys";
	public static final String APP_ENV="app.env";
	public static final String APP_VERSION="app.version";
	public static final String APP_CONNECT="app.cnn";
	
	public static final String API_URL="api.url";
	public static final String DB_DRIVER="spring.datasource.driverClassName";
	public static final String DB_URL="spring.datasource.url";
	public static final String DB_USER="spring.datasource.username";
	public static final String DB_PASS="spring.datasource.password";
	public static final String DB_DIALECT="spring.jpa.properties.hibernate.dialect";
	public static final String DB_SHOWSQL="spring.jpa.show-sql";
	public static final String DB_DDL="spring.jpa.hibernate.ddl-auto";
	public static final String ACTIVE_PROFILE="spring.profiles.active";
	public static final String PROFILE_API="WEBSERVICE";
	public static final String PROFILE_JPA="DATABASE";
	public static boolean iniciarConfiguracao(){
		//https://emmanuelneri.com.br/2017/05/14/profiles-no-spring-boot/
		System.setProperty("app.home", System.getProperty("user.dir"));
		System.setProperty("spring.config.location", getConfigProperties());
		//https://www.ricston.com/blog/encrypting-properties-in-spring-boot-with-jasypt-spring-boot/
		System.setProperty("jasypt.encryptor.password",Criptografia.CHAVE_PRIVADA);
		return !getArquivoConfiguracao().exists();
	}
	public static File getArquivoConfiguracao() {
		File arquivo = new File(getRoot(), getConfigProperties());
		return arquivo;
	}
	public static File getArquivo(String nome) {
		File arquivo = new File(getRoot(), nome);
		return arquivo;
	}
	public static String getConfigProperties() {
		return "application-" + getSistema().lowercase()+".properties";
	}
	public static Sistema getSistema() {
		return Sistema.valueOf(Objects.toString(System.getProperty(APP_SYSTEM).toUpperCase(),Sistema.ESOCIAL.name()));
	}
	public static String lowercase() {
		return getSistema().lowercase();
	}
	public static String upercase() {
		return getSistema().name().toUpperCase();
	}
	public static String hsqlPorta() {
		return getSistema().hsqlPorta();
	}
	public static String getRoot() {
		return Objects.toString(System.getProperty(APP_HOME),"/home");
	}
}
