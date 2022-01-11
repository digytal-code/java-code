package code.desktop;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import code.enums.TipoOperacao;

public abstract class FormularioCadastro extends Formulario{
	protected JCheckBox cNovo = new JCheckBox("Novo?");
	protected TipoOperacao tipoOperacao;
	private JComponent primeiroCampo;
	public void ocultarNovo() {
		this.cNovo.setVisible(false);
	}
	public void setExibirNovo(boolean exibir) {
		this.cNovo.setVisible(exibir);
	}
	public FormularioCadastro() {
		rodape.add(cNovo);
	}
	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public void setPrimeiroCampo(JComponent primeiroCampo) {
		this.primeiroCampo = primeiroCampo;
		focus();
	}
	public abstract void setEntidade(Object entidade);
	
	public abstract <T> T getRegistro();
	private void focus() {
		if(primeiroCampo!=null)
			primeiroCampo.requestFocus();
	}
	public abstract void salvar();
	public void novoCadastro() {
		try {
			//confirmar();
			if(cNovo.isSelected()) {
				Object entidade = getRegistro().getClass().newInstance();
				setEntidade(entidade);
				focus();
			}else
				fechar();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
