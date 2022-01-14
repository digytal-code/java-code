package com.digytal.open.util;

import java.net.URL;

import javax.swing.ImageIcon;

import com.digytal.open.util.config.Configuracao;

public class Imagem {
	public static ImageIcon gif(String ... endereco) {
		return icone(Extensao.GIF,endereco);
	}
	public static ImageIcon jpg(String ... endereco) {
		return icone(Extensao.JPG,endereco);
	}
	public static ImageIcon png(String ... endereco) {
		return icone(Extensao.PNG,endereco);
	}
	public static ImageIcon sysPng(String png) {
		return icone(Extensao.PNG,"app",Configuracao.lowercase(),png);
	}
	
	public static ImageIcon icone(Extensao extensao,String ... endereco) {
		return new ImageIcon(url(extensao, endereco));
	}
	public static URL url(Extensao extensao, String ... endereco) {
		String url = "/img/"+Texto.concatenar("/", endereco) + extensao;
		return Imagem.class.getResource(url);
	}
	
}
