package java.code.desktop.desktop.ss.tabela;

import javax.swing.*;

public enum SSTipoSelecao {
    SELECAO_UNICA (ListSelectionModel.SINGLE_SELECTION),    
    SELECAO_MULTIPLA (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION),
    SELECAO_INTERVALO (ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    
    private int codigo;
    
    SSTipoSelecao (int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
}
