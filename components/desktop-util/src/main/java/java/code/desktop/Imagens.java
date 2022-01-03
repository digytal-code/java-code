package java.code.desktop;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagens {
	private static String URL="/img/";
	public static ImageIcon jpg(String nome) {
		return jpg("", nome);
	}
	public static ImageIcon jpg(String prefixo, String nome) {
		return icone(prefixo, nome, ".jpg");
	}
	public static ImageIcon png(String nome) {
		return png("", nome);
	}
	public static Image pngImage(String nome) {
		return png("", nome).getImage();
	}
	public static ImageIcon png(String prefixo, String nome) {
		return icone(prefixo, nome, ".png");
	}
	public static ImageIcon icone(String prefixo, String nome, String extensao) {
		prefixo = prefixo.isEmpty()?prefixo:prefixo+"/";
		String imagem = String.format("%s%s%s%s", URL,prefixo,nome,extensao);
		try {
			ImageIcon icon= new ImageIcon(Imagens.class.getResource(imagem));
			return icon;
		}catch (Exception e) {
			return null;
		}
		 
	}
	
}
