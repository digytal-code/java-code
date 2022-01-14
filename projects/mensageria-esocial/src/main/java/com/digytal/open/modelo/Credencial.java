package com.digytal.open.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
public class Credencial {
	private String pfx;
	private String alias;
	private String senha;
	private String cacerts;
	private String cpfCnpjEmissor;
	private String cpfCnpjTransmissor;
	
	public String getCpfCnpjEmissor() {
		return cpfCnpjEmissor;
	}
	public void setCpfCnpjEmissor(String cpfCnpjEmissor) {
		this.cpfCnpjEmissor = cpfCnpjEmissor;
	}
	public String getCpfCnpjTransmissor() {
		return cpfCnpjTransmissor;
	}
	public void setCpfCnpjTransmissor(String cpfCnpjTransmissor) {
		this.cpfCnpjTransmissor = cpfCnpjTransmissor;
	}
	public void setCacerts(String cacerts) {
		this.cacerts = cacerts;
	}
	public void setPfx(String pfx) {
		this.pfx = pfx;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPfx() {
		return pfx;
	}
	public String getAlias() {
		return alias;
	}
	public String getSenha() {
		return senha;
	}
	public String getCacerts() {
		return cacerts;
	}
	private  KeyStore ks() throws Exception{
		KeyStore ks = KeyStore.getInstance("PKCS12");
		try {
			InputStream entrada = new FileInputStream(getPfx());
			ks.load(entrada, getSenha().toCharArray());
		} catch (IOException e) {
			throw new Exception(
					"Senha do Certificado Digital incorreta ou Certificado invalido.");
		}
		return ks;
	}
	private  KeyStore.PrivateKeyEntry pk() throws Exception {
		KeyStore ks = ks();
		KeyStore.PrivateKeyEntry pkEntry = null;
		Enumeration<String> aliasesEnum = ks.aliases();
		while (aliasesEnum.hasMoreElements()) {
			String alias = (String) aliasesEnum.nextElement();
			if (ks.isKeyEntry(alias)) {
				pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias,
						new KeyStore.PasswordProtection(getSenha().toCharArray()));
				break;
			}
		}
		return pkEntry;
	}
	public PrivateKey getChavePrivada() throws Exception { 

		Key chavePrivada = (Key) ks().getKey(getAlias(), getSenha().toCharArray()); 
		if (chavePrivada instanceof PrivateKey) { 
			return (PrivateKey) chavePrivada; 
		} 
		return null; 

	} 
	public X509Certificate getX509Certificate()throws Exception{
		X509Certificate cert = (X509Certificate) pk().getCertificate();
		return cert;
	}
	
}
