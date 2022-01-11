package code.desktop.ss;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class SSModeloCheckBoxBloqueado implements ButtonModel{
    private boolean selected;
    private boolean enabled;
    private boolean pressed;
    private boolean armed;
    private boolean rollover;    
    
    public SSModeloCheckBoxBloqueado(JCheckBox chk) {
        setEnabled(chk.isEnabled());
        setSelected(chk.isSelected());
        setPressed(chk.getModel().isPressed());
        setArmed(chk.getModel().isArmed());
        setRollover(chk.getModel().isRollover());
    }

    public boolean isArmed() {
        return armed;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public boolean isRollover() {
        return rollover;
    }

    public void setArmed(boolean b) {
        this.armed = b;
    }

    public void setSelected(boolean b) {
        if (this.selected == b)
            return;
        
        this.selected = b;
        
    }

    public void setEnabled(boolean b) {
        this.enabled = b;
    }

    public void setPressed(boolean b) {
        this.pressed = b;
    }

    public void setRollover(boolean b) {
        this.rollover = b;
    }

    public void setMnemonic(int key) {
    }

    public int getMnemonic() {
        return 0;
    }

    public void setActionCommand(String s) {
    }

    public String getActionCommand() {
        return null;
    }

    public void setGroup(ButtonGroup group) {
    }

    public void addActionListener(ActionListener l) {
    }

    public void removeActionListener(ActionListener l) {
    }

    public void addItemListener(ItemListener l) {
    }

    public void removeItemListener(ItemListener l) {
    }

    public void addChangeListener(ChangeListener l) {
    }

    public void removeChangeListener(ChangeListener l) {
    }

    public Object[] getSelectedObjects() {
        return new Object[0];
    }
}
