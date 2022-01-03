package code.desktop.desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import code.desktop.Imagens;
import code.desktop.desktop.ss.SSCabecalho;
import code.desktop.desktop.ss.SSMensagem;
import code.desktop.desktop.ss.SSRodape;

public abstract class Formulario extends JPanel {
	protected SSCabecalho cabecalho = new SSCabecalho();
	protected SSRodape rodape = new SSRodape();
	protected JPanel conteudo = new JPanel();
	private Formulario dono;
	private Object resposta;
	private static Object respostaDialogo;
	
	private MDI mdi;
	
	public Formulario() {
		this(new GridBagLayout());
	}
	
	public Formulario(LayoutManager layout) {
		this.setLayout(new BorderLayout());
		
		this.setTitulo("Informe um título");
		this.setDescricao("Informe uma descrição");

		this.add(cabecalho, BorderLayout.NORTH);
		this.add(conteudo, BorderLayout.CENTER);
		this.add(rodape, BorderLayout.SOUTH);
		
		this.conteudo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.conteudo.setLayout(layout);
		this.rodape.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
	}
	
	public String getTitulo() {
		return cabecalho.getTitulo();
	}
	
	public void carregar() {

	}
	
	public MDI getMdi() {
		return mdi;
	}
	public void setMdi(MDI mdi) {
		this.mdi = mdi;
	}
	
	public void exibir() {
		this.exibir(this);
	}
	
	public void exibir(Formulario frm) {
		if (frm != this) {
			frm.setMdi(this.getMdi());
		}
		//frm.setLogin(this.getLogin());
		JInternalFrame internal = new JInternalFrame(getTitulo());
		internal.setFrameIcon(Imagens.png("app"));
		internal.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		internal.setResizable(true);
		internal.setVisible(true);
		internal.setContentPane(frm);
		internal.setSize(frm.getWidth(), frm.getHeight());
		try {
			internal.setSelected(true);
			if(frm.getWidth() ==0  && frm.getHeight()==0)
				internal.pack();
			centralizar(internal);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		//frm.carregar();
		mdi.getAreaTrabalho().add(internal);
		mdi.getAreaTrabalho().getDesktopManager().activateFrame(internal);
		   
		
	}
	public void setTitulo(String titulo) {
		this.cabecalho.setTitulo(titulo);
	}
	public void setDescricao(String descricao) {
		this.cabecalho.setDescricao(descricao);
	}
	public JPanel getConteudo() {
		return conteudo;
	}
	public SSCabecalho getCabecalho() {
		return cabecalho;
	}
	public SSRodape getRodape() {
		return rodape;
	}
	protected void setAlinhamentoBotoes(int alinhamento) {
		this.rodape.setLayout(new FlowLayout(alinhamento));
	}
	
	public static Object dialogo(Formulario form) {
		respostaDialogo=null;
		form.carregar();
		criarDialogo(form);
		return respostaDialogo;
	}
	private static void criarDialogo(JPanel form) {
		JDialog dialog = new JDialog();
		dialog.setResizable(false);
		
		dialog.setUndecorated(true);
		//dialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		dialog.setModal(true);
		dialog.setContentPane(form);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		dialog.dispose();
	}
	
	
	public void fechar(Object resposta) {
		if (resposta != null) {
			if(dono!=null)
				dono.resposta = resposta;
			respostaDialogo=resposta;
			fechar();
		} else {
			SSMensagem.avisa("Selecione um item da item");
		}
		resposta=null;
	}

	public void fechar() {
		if(isInternal(this))
			removerFormulario();
		//else if(isJanela(this))
			//fecharJanela();
		else if (isDialogo(this))
			fecharDialogo();
		else
			removerFormulario();
	}
	
	private void fecharDialogo() {
		JDialog dialog = (JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, this);
		dialog.dispose();
		dialog.setVisible(false);
	}
	
	private void removerFormulario() {
		JInternalFrame iframe = (JInternalFrame) SwingUtilities.getAncestorOfClass(JInternalFrame.class, this);
		if (mdi != null) {
			mdi.getAreaTrabalho().remove(iframe);
			mdi.getAreaTrabalho().repaint();
		}
	}
	/*
	private void fecharJanela() {
		JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
		frame.setVisible(false);
		frame.dispose();
	}
	*/
	private void centralizar(JInternalFrame componente) {
		Dimension dim = mdi.getSize();
		int x = dim.width / 2 - componente.getSize().width / 2;
		int y = dim.height / 2 - componente.getSize().height / 2;
		y = y - 37; // opcional
		x = x - 10; // opcional
		componente.setLocation(x, y);
		componente.setVisible(true);
	}
	public boolean isInternal(Formulario form) {
		return SwingUtilities.getAncestorOfClass(JInternalFrame.class, form) != null;
	}
	/*
	public boolean isJanela(Formulario form) {
		return SwingUtilities.getAncestorOfClass(JFrame.class, form) != null;
	}
	*/
	public boolean isDialogo(Formulario form) {
		return SwingUtilities.getAncestorOfClass(JDialog.class, form) != null;
	}
	
	private static void gbc(String component,int x, int y) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("GridBagConstraints gbc_%s = new GridBagConstraints();\n", component) );
		sb.append(String.format("gbc_%s.weightx = 1.0;\n",component));
		sb.append(String.format("gbc_%s.gridwidth = 1;\n",component));
		sb.append(String.format("gbc_%s.anchor = GridBagConstraints.NORTHWEST;\n",component));
		sb.append(String.format("gbc_%s.fill = GridBagConstraints.HORIZONTAL;\n",component));
		sb.append(String.format("gbc_%s.insets = new Insets(3, 3, 0, 3);\n",component));
		sb.append(String.format("gbc_%s.gridx = %d;\n",component, x)   );
		sb.append(String.format("gbc_%s.gridy = %d;\n",component, y)   );
		sb.append(String.format("getConteudo().add(%s, gbc_%s);\n", component,component) );
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String[] args) {
		gbc("cContaDestino",0,7);
	}
}
