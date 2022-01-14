package com.digytal.open.util;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class Diretorio {
	public static String ROOT=System.getProperty("user.dir");
	public static File raizSistema(String nome) {
		return arquivo(ROOT,nome);
	}
	public static File raizSistema(String nome,Extensao extensao) {
			return arquivo(extensao, ROOT,nome);
	}
	public static File resource(String nome,Extensao extensao) {
		ClassLoader classLoader = new Diretorio().getClass().getClassLoader();
        URL resource = classLoader.getResource(nome+extensao);
        if (resource == null) {
        	System.out.println("IMAGEN NÃO ENCONTRADA " + nome + " " + extensao);
           return null;
        } else {
            return new File(resource.getFile());
        }
	}
	
	public static File arquivo(String ... caminhos) {
		return arquivo(null, caminhos);
	}
	public static File arquivo(Extensao extensao, String ... caminhos) {
		String local=Arrays.asList(caminhos).stream().collect(Collectors.joining("/")).replaceAll("/", Matcher.quoteReplacement(File.separator)) ;
		local+=extensao==null?"":extensao.toString();
		System.out.println(local);
		return new File(local);
	}
	public static File url(Extensao extensao,String ... endereco) {
		String url = Texto.concatenar("/", endereco) + extensao;
		ClassLoader classLoader = new Diretorio().getClass().getClassLoader();
        URL resource = classLoader.getResource(url);
        System.out.println(resource!=null?resource.toString() :"ENDERECO NAO NAO ENCONTRATO " + url);
        return new File( resource.getFile());
	}
	public static URL src(Extensao extensao,String ... endereco) {
		String url = Texto.concatenar("/", endereco) + extensao;
		ClassLoader classLoader = new Diretorio().getClass().getClassLoader();
        URL resource = classLoader.getResource(url);
        System.out.println(resource!=null?resource.toString() :"ENDERECO NAO NAO ENCONTRATO " + url);
        return resource;
	}
	public static void main(String[] args) {
		/*
		 * System.out.println(resource("img").isDirectory());
		 * System.out.println(resource("img/voltar.png").isFile());
		 */
		System.out.println(resource( "teste",Extensao.TXT).isFile());
		//System.out.println(raizSistema("target").isDirectory());
		//System.out.println(arquivo("/dev").isDirectory());
	}
}
