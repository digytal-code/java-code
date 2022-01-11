package code.desktop.ss;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;


public class SSRodape extends JPanel {
    private boolean iniciado = false;
    private FlowLayout layout = new FlowLayout();
    public SSRodape() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        this.setSize(new Dimension(430, 41));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(layout);
        layout.setAlignment(FlowLayout.RIGHT);
        this.iniciado = true;
    }
    public void setAlinhamento(int alinhamento) {
    	layout.setAlignment(alinhamento);
    }
}
