package java.code.desktop.desktop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.code.desktop.Imagens;
import java.code.desktop.desktop.ss.SSMensagem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CampoImagem extends JPanel {
	private JLabel frame = new JLabel("");
	private byte[] bytes;
	//private File arquivo;
	private int IMG_SIZE=130;
	public CampoImagem() {
		setSize(100, 100);
		//setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		//imagemPadrao();
		BotaoIcone btRemover = new BotaoIcone();
		btRemover.setText("Limpar");
		
		BotaoIcone btExportar = new BotaoIcone();
		btExportar.setText("");
		btExportar.setIcone("imagem");

		BotaoIcone btSelecionar = new BotaoIcone();
		btSelecionar.setText("Abrir");
		btSelecionar.setIcone("pasta");

		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblFrame = new GridBagConstraints();
		gbc_lblFrame.insets = new Insets(3, 3, 10, 3);
		gbc_lblFrame.gridwidth = 3;
		gbc_lblFrame.gridx = 0;
		gbc_lblFrame.gridy = 0;
		add(frame, gbc_lblFrame);

		GridBagConstraints gbc_btSelecionar = new GridBagConstraints();
		gbc_btSelecionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btSelecionar.insets = new Insets(2, 10, 5, 0);
		gbc_btSelecionar.gridx = 0;
		gbc_btSelecionar.gridy = 1;
		add(btSelecionar, gbc_btSelecionar);

		btRemover.setIcone("remover");
		GridBagConstraints gbc_btRemover = new GridBagConstraints();
		gbc_btRemover.anchor = GridBagConstraints.NORTHWEST;
		gbc_btRemover.insets = new Insets(2, 10, 5, 0);
		gbc_btRemover.gridx = 1;
		gbc_btRemover.gridy = 1;
		add(btRemover, gbc_btRemover);
		
		GridBagConstraints gbc_btExportar = new GridBagConstraints();
		gbc_btExportar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btExportar.insets = new Insets(2, 10, 5, 0);
		gbc_btExportar.gridx = 2;
		gbc_btExportar.gridy = 1;
		add(btExportar, gbc_btExportar);

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
		btExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exportar();
			}

		});
	}

	private void imagemPadrao() {
		ImageIcon image = Imagens.png("perfil");
		setImagem(image, IMG_SIZE);
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setImagem(byte[] bytes) {
		try {
			this.bytes = bytes;
			if(this.bytes==null)
				imagemPadrao();
			else
				setImagem(new ImageIcon(this.bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImagem(ImageIcon imagem) {
		setImagem(imagem, IMG_SIZE);
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
			bytes = convert( file.getSelectedFile());
			ImageIcon imagem = new ImageIcon(bytes);
			setImagem(imagem, IMG_SIZE);
		} else if (result == JFileChooser.CANCEL_OPTION) {
			imagemPadrao();
		}
	}
	private void exportar() {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
           File dir = fileChooser.getSelectedFile();
           exportar(bytes, dir.getAbsolutePath());
           SSMensagem.informa("Imagem Exportada");
        }else{
        	System.out.println("Open command canceled");
        }
	}
	private void exportar(byte[] bFile, String dir) {
        try {
            Path path = Paths.get(dir,"img"+new Date().getTime() + ".jpg");
            Files.write(path, bFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	private byte[] convert(File file) {
		byte[] bFile=null;
		try {
			bFile = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bFile;
	}
	private void remover() {
		imagemPadrao();
	}
}
