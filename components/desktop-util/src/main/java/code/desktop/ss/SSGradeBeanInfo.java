package code.desktop.ss;

import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;


public class SSGradeBeanInfo extends SimpleBeanInfo {
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor bd = new BeanDescriptor(SSComponenteRotulado.class);
        bd.setValue("isContainer", false);
        return bd;
    }
}
