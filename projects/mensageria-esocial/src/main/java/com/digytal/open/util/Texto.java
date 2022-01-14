package com.digytal.open.util;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Texto {
	public static int INICIO = 0;
	public static int FIM = 1;
	public static int MEIO = 2;
	public static String base64Encode(String texto) throws Exception {
		String resultado = Base64.getEncoder().encodeToString(texto.getBytes());
		return resultado;
	}

	public static String base64Decore(String encoded) throws Exception {
		byte[] bytes = Base64.getDecoder().decode(encoded);
		String resultado = new String(bytes);
		return resultado;
	}

	public static String removerAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	private static String extensao(File file) {
		return file.getName().replaceAll("^.\\.(.)$", "$1");
	}

	public static String str(Object texto, String textoPadrao) {
		return Objects.toString(texto, textoPadrao);
	}

	public static String str(Object texto) {
		return str(texto, "");
	}

	public static String concatenar(String delimitador, List valores) {
		return concatenar(delimitador, valores.stream().toArray(Object[]::new));
	}

	public static String concatenar(String delimitador, Object... valores) {
		List strs = new ArrayList<>(Arrays.asList(valores));
		StringJoiner sj = new StringJoiner(delimitador, "", "");
		strs.stream().forEach(o -> {
			if (o != null && (!o.toString().trim().isEmpty()))
				sj.add(str(o));
		});

		return sj.toString();
	}

	public static String prefixo(String simbolo, int comprimento, String texto) {
		return completar(texto, INICIO, simbolo, comprimento);
	}

	public static String sufixo(String texto, String simbolo, int comprimento) {
		return completar(texto, INICIO, simbolo, comprimento);
	}

	public static String completar(String texto, int posicao, String simbolo, int comprimento) {
		boolean meio = posicao == MEIO;
		while (texto.length() < comprimento) {
			if (meio)
				posicao = posicao == INICIO ? FIM : INICIO;

			if (FIM == posicao)
				texto += simbolo;
			else if (INICIO == posicao)
				texto = simbolo + texto;
		}
		return texto;
	}

	public static String caso(String palavra, String... opcoes) {
		for (int x = 0; x < opcoes.length; x++) {
			if (palavra.equals(opcoes[x])) {
				return opcoes[x + 1];
			}
		}
		return null;
	}
	public static String primeiraMinuscula(String texto) {
		texto = texto.substring(0, 1).toLowerCase() + texto.substring(1);
		return texto;
	}
	public static String numeros(String texto) {
		return Objects.toString(texto.replaceAll("\\D", ""),"");
	}
	public static String removerQuebralinha(String texto) {
		return Objects.toString(texto.replaceAll("\\r|\\n|\\t", ""),"");
	}
	public static void main(String[] args) throws Exception {
		Object[] testes = { "localhost:8080", "cadastros", "contas"};

		System.out.println(concatenar("/", testes));

		String var = "SUBI NO ONIBUS";
		System.out.println(new StringBuilder(var).reverse());
		
		System.out.println("Ç./004.\\".replaceAll("\\D", ""));
	}

}
