package java.code.desktop.desktop;

import java.code.desktop.Imagens;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BotaoIcone extends JLabel {
	private String icone;
	public BotaoIcone (){
		setIcone("pasta");
	}
	
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;        
        ImageIcon imagem = null;
        if (icone != null) {
              imagem = Imagens.png(icone);
        }
        setIcon(imagem);
		
	}
}
