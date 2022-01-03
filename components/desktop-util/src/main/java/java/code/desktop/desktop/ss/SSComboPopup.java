package java.code.desktop.desktop.ss;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;


public class SSComboPopup extends BasicComboPopup {
    public SSComboPopup(JComboBox comboBox) {
        super(comboBox);
    }

    protected JScrollPane createScroller() {
        JScrollPane scroller = new JScrollPane( list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        return scroller;
    }

    public Dimension getPreferredSize() {
        Dimension d = new Dimension();
        d.setSize(comboBox.getWidth(), super.getPreferredSize().getHeight());
        return d;
    }

    public void show() {
        Dimension popupSize = getPreferredSize();
        popupSize.setSize( popupSize.width, getPopupHeightForRowCount( comboBox.getMaximumRowCount() ) );
        Rectangle popupBounds = computePopupBounds( 0, comboBox.getBounds().height, popupSize.width, popupSize.height);
        scroller.setMaximumSize( popupBounds.getSize() );
        scroller.setPreferredSize( popupBounds.getSize() );
        scroller.setMinimumSize( popupBounds.getSize() );
        list.invalidate();
        int selectedIndex = comboBox.getSelectedIndex();
        if( selectedIndex == -1 ) {
            list.clearSelection();
        } else {
            list.setSelectedIndex( selectedIndex );
        }
        list.ensureIndexIsVisible( list.getSelectedIndex() );
        setLightWeightPopupEnabled( comboBox.isLightWeightPopupEnabled() );
        show( comboBox, popupBounds.x, popupBounds.y );					
    }
}

class SSCaixaCombinacaoUI extends BasicComboBoxUI { 
    BasicComboPopup popup;
        
    protected ComboPopup createPopup() {
        popup = new SSComboPopup(comboBox);
        popup.getAccessibleContext().setAccessibleParent(comboBox);
        this.installUI(new SSCaixaCombinacao());
        return popup;
    }
    
    public BasicComboPopup getPopup() {
        return popup;
    }
}
