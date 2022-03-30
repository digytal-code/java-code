package code.desktop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import code.desktop.ss.SSBotao;

public class UploadImagem extends JPanel {
	
	private JLabel frame = new JLabel("");
	private File arquivo;
	private final int TAMANHO_PADRAO = 180;
	
	public UploadImagem() {
		imagemPadrao();
		SSBotao btRemover = new SSBotao();
		SSBotao btSelecionar = new SSBotao();
		
		btRemover.setText("Limpar");
		btRemover.setIcone("remover");
		
		btSelecionar.setText("Abrir");
		btSelecionar.setIcone("pasta");
		
		GridBagLayout gridBagLayout = new GridBagLayout();

		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblFrame = new GridBagConstraints();
		gbc_lblFrame.insets = new Insets(3, 3, 10, 3);
		gbc_lblFrame.gridwidth = 2;
		gbc_lblFrame.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFrame.gridx = 0;
		gbc_lblFrame.gridy = 0;
		add(frame, gbc_lblFrame);

		GridBagConstraints gbc_btSelecionar = new GridBagConstraints();
		gbc_btSelecionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btSelecionar.insets = new Insets(2, 10, 5, 5);
		gbc_btSelecionar.gridx = 0;
		gbc_btSelecionar.gridy = 1;
		add(btSelecionar, gbc_btSelecionar);

		GridBagConstraints gbc_btRemover = new GridBagConstraints();
		gbc_btRemover.anchor = GridBagConstraints.NORTHWEST;
		gbc_btRemover.insets = new Insets(2, 10, 5, 0);
		gbc_btRemover.gridx = 1;
		gbc_btRemover.gridy = 1;
		add(btRemover, gbc_btRemover);
		btRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remover();
			}

		});
		btSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionar();
			}

		});
	}
	
	public void setImagem(byte[] bytes) {
		if(bytes!=null) {
			ImageIcon imagem = new ImageIcon(bytes);
			setImagem(imagem);
		}
	}

	public void setImagem(ImageIcon imagem) {
		setImagem(imagem, TAMANHO_PADRAO);
	}

	public void setImagem(ImageIcon imagem, int tamanho) {
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(tamanho, tamanho, Image.SCALE_DEFAULT));
		frame.setIcon(imagem);
		this.repaint();
	}

	private void selecionar() {
		JFileChooser file = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			arquivo = file.getSelectedFile();
			ImageIcon imagem = new ImageIcon(arquivo.getAbsolutePath());
			setImagem(imagem, TAMANHO_PADRAO);
		} else if (result == JFileChooser.CANCEL_OPTION) {
			imagemPadrao();
		}
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] getBytes() throws Exception {
		byte[] bytes = new byte[(int) arquivo.length()];
		FileInputStream fis = new FileInputStream(arquivo);
		fis.read(bytes);
		fis.close();
		return bytes;
	}

	private void remover() {
		imagemPadrao();
	}

	private void imagemPadrao() {
		ImageIcon image = new ImageIcon(getClass().getResource("/img/semfoto.png"));
		setImagem(image, TAMANHO_PADRAO);
	}
	
}
