
package kr.cleancode.dashboard.manager.ui.center;

import kr.cleancode.dashboard.manager.ui.center.cmd.UiCenterMainCmd;

import javax.swing.*;
import java.awt.*;

public class UiCenterMain extends JPanel {

	private static final long serialVersionUID = -6048314073965426409L;
	
	private volatile static UiCenterMain object = null;
	
	public static final UiCenterMain getInstance(){
		if(object == null){
			synchronized (UiCenterMain.class) {
				if(object == null){
					object = new UiCenterMain();
				}
			}
		}
		return object;
	}
	
	public UiCenterMain() {
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder());
		setLayout(new CardLayout(0, 0));
		
		add(kr.cleancode.dashboard.manager.ui.center.UiCenterMainFrame.getInstance().getName(), kr.cleancode.dashboard.manager.ui.center.UiCenterMainFrame.getInstance());
		
		new UiCenterMainCmd().setHidenMenu(this);
	}
	
}
