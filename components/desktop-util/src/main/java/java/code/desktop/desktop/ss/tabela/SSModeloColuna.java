package java.code.desktop.desktop.ss.tabela;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;


public class SSModeloColuna extends DefaultTableColumnModel {
    private Vector campos;
    private Vector formatos;
    private Vector mascaras;
    
    public SSModeloColuna() {      
        super();
    }
    public void definirPositivoNegativo(int x) {
    	setCorFonte(x);
    }
    public void setCorFonte(int x,Color ... cor) {
    	getColumn(x).setCellRenderer(new CustomRenderer(cor));
    }
    public void setAlinhamentoColuna(int coluna, int alinhamento) {
        getColumn(coluna).setCellRenderer(new DefaultTableCellRenderer());
        ((DefaultTableCellRenderer)getColumn(coluna).getCellRenderer()).setHorizontalAlignment(alinhamento);
    }
    
    public int getAlinhamentoColuna(TableColumn coluna) {
        if (coluna.getCellRenderer() == null)
            return SwingConstants.LEFT;
        return ((DefaultTableCellRenderer)coluna.getCellRenderer()).getHorizontalAlignment();
    }
    
    public void setAlinhamentoColunaHeader(int coluna, int alinhamento) {
        DefaultTableCellRenderer renderizador = ((DefaultTableCellRenderer)getColumn(coluna).getHeaderRenderer());
        renderizador = (DefaultTableCellRenderer)new JTableHeader().getDefaultRenderer();
        renderizador.setHorizontalAlignment(alinhamento);
        getColumn(coluna).setHeaderRenderer(renderizador);
    }
    
    public int getAlinhamentoColunaHeader(TableColumn coluna) {
        if (coluna.getHeaderRenderer() == null)
            return SwingConstants.LEFT;
        return ((DefaultTableCellRenderer)coluna.getHeaderRenderer()).getHorizontalAlignment();
    }
    
    public void addColumn(String nomeColuna) {
        TableColumn coluna = new TableColumn();
        coluna.setHeaderValue(nomeColuna);
        addColumn(coluna);
    }
    
    public SSModeloColuna(DefaultTableColumnModel modelo) {
        this.setColumnSelectionAllowed(modelo.getColumnSelectionAllowed());
        this.setColumnMargin(modelo.getColumnMargin());
        this.setSelectionModel(modelo.getSelectionModel());
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            this.addColumn(modelo.getColumn(i));            
        }
        for (int i = 0; i < modelo.getColumnModelListeners().length; i++) {
            this.addColumnModelListener(modelo.getColumnModelListeners()[i]);            
        }
        campos = new Vector(getColumnCount());
        formatos = new Vector(getColumnCount());
        mascaras = new Vector(getColumnCount());
    }
    
    public void setCampo(int coluna, String campo) {
        setCampo(getColumn(coluna), campo);
    }
   
    public void setCampo(TableColumn coluna, String campo) {        
        campos = definirValorVetor(campos, coluna.getModelIndex(), campo);        
    }
    
    public void setFormato(int coluna, String formato) {
        setFormato(getColumn(coluna), formato);
    }
    
    public void setFormato(TableColumn coluna, String formato) {        
        formatos = definirValorVetor(formatos, coluna.getModelIndex(), formato);        
    }
    
    public String getCampo(TableColumn coluna) {
        if (campos == null)
            return null;
        if (coluna.getModelIndex() >= campos.size())
            return null;
        return (String)campos.get(coluna.getModelIndex());
    }
    
    public String getFormato(TableColumn coluna) {
        if (formatos == null)
            return null;
        if (coluna.getModelIndex() < formatos.size())
            return (String)formatos.get(coluna.getModelIndex());
        else
            return null;
    }

    public void setCampos(Vector campos) {
        this.campos = campos;
    }

    public Vector getCampos() {
        return campos;
    }

    public void setFormatos(Vector formatos) {
        this.formatos = formatos;
    }

    public Vector getFormatos() {
        return formatos;
    }
    
    private Vector verificarVetor(Vector vetor, int modelIndex) {
        if (vetor == null)
            vetor = new Vector(getColumnCount());
        if (modelIndex >= vetor.size())
            for (int i = 0; i <= modelIndex; i++)
                vetor.add(null);
        return vetor;
    }
    
    private Vector definirValorVetor(Vector vetor, int indice, Object valor) {
        vetor = verificarVetor(vetor, indice);
        vetor.set(indice, valor);
        return vetor;
    }
    
    public void setMascara(TableColumn coluna, String mascara) {
        mascaras = definirValorVetor(mascaras, coluna.getModelIndex(), mascara);        
    }
    
    public void setMascara(int coluna, String mascara) {
        setMascara(getColumn(coluna), mascara);
    }
    
    public String getMascara(TableColumn coluna) {
        if (mascaras == null)
            return null;
        if (coluna.getModelIndex() >= mascaras.size())
            return null;
        return (String)mascaras.get(coluna.getModelIndex());
    }
    
    public void setMascaras(Vector mascaras) {
        this.mascaras = mascaras;
    }

    public Vector getMascaras() {
        return mascaras;
    }
}

class CustomRenderer extends DefaultTableCellRenderer
{	
	private Color[] cor;
	CustomRenderer(Color ... cor){
		this.cor=cor;
	}
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
    	if(value!=null && value.toString().startsWith("-"))
            setForeground(Color.RED);
    	else
    		setForeground(Color.BLUE);
        return c;
    }
}
