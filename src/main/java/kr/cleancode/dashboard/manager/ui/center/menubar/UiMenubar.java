
package kr.cleancode.dashboard.manager.ui.center.menubar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import kr.cleancode.dashboard.manager.ui.center.menubar.cmd.UiMenubarCmd;

public class UiMenubar extends JPanel{

	private static final long serialVersionUID = -25107800614072197L;

	private volatile static UiMenubar object = null;
	
	public static final UiMenubar getInstance(){
		if(object == null){
			synchronized (UiMenubar.class) {
				if(object == null){
					object = new UiMenubar();
				}
			}
		}
		return object;
	}
	
	private final String viewName = "XR Manager Menubar";
	
	public final JMenu jMenuProgram = new JMenu("Program");
	
	public final JMenu jMenuModuleTest = new JMenu("Module Test");
	
	public final JMenu jMenuRootLevelConfig = new JMenu("Root Level Config");
	
	public JToolBar jToolBar = null;
	
	public UiMenubar() {
		setName(viewName);
		setBackground(Color.black);
		setOpaque(true);
		setLayout(new BorderLayout(5, 5));
		
		final UiMenubarCmd uiMenubarCmd = new UiMenubarCmd();
		add(uiMenubarCmd.memuPanel(jMenuProgram, jMenuModuleTest, jMenuRootLevelConfig), BorderLayout.WEST);
		
		this.jToolBar = uiMenubarCmd.toolbarPanel();
		add(jToolBar, BorderLayout.CENTER);
		
		add(uiMenubarCmd.dateTimePanel(), BorderLayout.EAST);
	}
	
}
