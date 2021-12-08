
package kr.cleancode.dashboard.manager.ui.center;

import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.menubar.UiMenubar;

import javax.swing.*;
import java.awt.*;

public class UiCenterMainFrame extends JPanel {

	private static final long serialVersionUID = -6048314073965426409L;
	
	private volatile static UiCenterMainFrame object = null;
	
	public static final UiCenterMainFrame getInstance(){
		if(object == null){
			synchronized (UiCenterMainFrame.class) {
				if(object == null){
					object = new UiCenterMainFrame();
				}
			}
		}
		return object;
	}
	
	private String viewName = "Xr Manager Main Frame";
	
	public UiCenterMainFrame() {
		setName(this.viewName);
		setBackground(Color.black);
		setLayout(new BorderLayout(0, 0));
		
		final JScrollPane jScrollPane = new JScrollPane(UiDeskTopPane.getInstance());
		add(jScrollPane, BorderLayout.CENTER);
		
		add(UiMenubar.getInstance(), BorderLayout.SOUTH);
	}
	
}
