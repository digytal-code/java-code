package java.code.desktop.desktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.code.desktop.desktop.ss.SSBotao;
import java.code.desktop.desktop.ss.SSGrade;
import java.code.desktop.desktop.ss.SSMensagem;
import java.code.desktop.enums.TipoOperacao;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract  class FormularioConsulta extends Formulario {
	protected SSBotao cmdBuscar = new SSBotao();
	private SSGrade tabela = new SSGrade();
	private JScrollPane scroll;
	public FormularioConsulta() {
		super(new BorderLayout());
		setSize(600, 600);
		init();
	}
	private void init(){
		cmdBuscar.setText("Buscar");
		cmdBuscar.setIcone("lupa");
		scroll = new JScrollPane();
		scroll.setViewportView(tabela);
				
		cmdBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filtrar();
			}
		});
		
		this.tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		super.setAlinhamentoBotoes(FlowLayout.LEFT);
		getConteudo().add(scroll,BorderLayout.CENTER);
		
	}
	
	public GridBagConstraints getGbcBuscar(int x, int y) {
		GridBagConstraints gbc_bBuscar = new GridBagConstraints();
		gbc_bBuscar.insets = new Insets(0, 3, 3, 3);
		gbc_bBuscar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_bBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_bBuscar.gridx = x;
		gbc_bBuscar.gridy = y;
		return gbc_bBuscar;
	}
	public SSGrade getTabela() {
		return tabela;
	}
	
	protected JScrollPane getScroll() {
		return scroll;
	}
	protected void alterar(FormularioCadastro formulario){
		Object entidade = getTabela().getLinhaSelecionada();
		if(entidade==null){
			SSMensagem.avisa("Selecione um registro");
			return;
		}
		exibir(formulario, TipoOperacao.ALTERACAO, entidade);
	}
	protected void incluir(FormularioCadastro formulario, Object entidade){
		exibir(formulario, TipoOperacao.INCLUSAO, entidade);
	}
	protected void exibir(FormularioCadastro formulario, TipoOperacao tipoOperacao, Object entidade){
		formulario.setTipoOperacao(tipoOperacao);
		formulario.carregar();
		formulario.setEntidade(entidade);
		this.exibir(formulario);
		
	}
	
	protected void filtrar() {
		
	}
	protected void exibirResultado(List lista) {
		if(lista==null || (lista!=null && lista.isEmpty()))
			SSMensagem.avisa("Nenhum registro encontrado");
		getTabela().setValue(lista);
	}
	

}
