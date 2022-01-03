package java.code.desktop.desktop.ss;

import java.awt.*;

public class SSLayout {
	//xyGridwidthRightWeightXWeightYBotton
	public static GridBagConstraints xyGridWidthGridHeightWeightXWeightYBottonRight(int x,int y,int gridheight, int gridwidth,double weightx,double weighty, int botton,int right) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth=gridwidth;
		gbc.gridheight=gridheight;
		
		gbc.weightx=weightx;
		gbc.weighty=weighty;
		gbc.insets = new Insets(5, 5, botton, right);
		
		return gbc;
	}
	public static GridBagConstraints xy(int x,int y) {
		return xyGridWidthGridHeightWeightXWeightYBottonRight(x, y, 1,1, 0.0,0.0,0,0);
	}
	public static GridBagConstraints xyLast(int x,int y) {
		return xyGridWidthGridHeightWeightXWeightYBottonRight(x, y, 1,1, 1.0,1.0,1,0);
	}
	public static GridBagConstraints xyRight(int x,int y) {
		return xyGridWidthGridHeightWeightXWeightYBottonRight(x, y, 1,1, 0.0,0.0,0,5);
	}
	public static GridBagConstraints xyFill(int x,int y) {
		return xyGridWidthGridHeightWeightXWeightYBottonRight(x, y, 1,1, 1.0,1.0,0,5);
	}
	public static GridBagConstraints xyGridW(int x,int y,int gridwidth) {
		return xyGridWidthGridHeightWeightXWeightYBottonRight(x, y, 1,gridwidth, 1.0,0.0,0,5);
	}
	
}
