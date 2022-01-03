package java.code.desktop.desktop.ss.tabela;

import javax.swing.table.DefaultTableModel;


public class SSModeloTabela extends DefaultTableModel {
	
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;        
    }
    
    
}
