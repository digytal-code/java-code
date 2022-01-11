package code.desktop.ss;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SSConteudo extends JPanel {    
    private GridBagLayout gridBagLayout1 = new GridBagLayout();

    public SSConteudo() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(gridBagLayout1);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));                
    }    
    
}
