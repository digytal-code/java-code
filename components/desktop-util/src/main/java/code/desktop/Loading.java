package code.desktop;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Imagem;

public class Loading extends JPanel {
	private JLabel img=new JLabel("LOAD");
	private JLabel text = new JLabel("PROCESSANDO ... ");
	public Loading() {
		text.setFont(new Font("Tahoma", Font.BOLD, 13));
		text.setForeground(Color.BLUE);
		img = new JLabel(Imagem.gif("loading"));
		add(img);
		add(text);
		ocultar();
	}
	private void setGif(String gif) {
		img = new JLabel(Imagem.gif(gif));
	}
	public void ocultar() {
		exibir(false);
	}
	public void exibir() {
		exibir(true);
	}
	public void exibir(boolean exibir) {
		this.setVisible(exibir);
	}
}
