
package kr.cleancode.dashboard.manager.ui.center.desktop.popup;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd.UiPopupMenuCmd;

import javax.swing.*;

public class UiPopupMenu extends JPopupMenu {

	private static final long serialVersionUID = -1069376349894848493L;

	public final JMenuItem jMenuItem00 = new JMenuItem("Program Install / Remove");
	public final JMenuItem jMenuItem01 = new JMenuItem("Ethernet");
	
	public UiPopupMenu(){
		setLabel(XrManagerProperties.moduleName);
		
		final UiPopupMenuCmd uiPopupMenuCmd = new UiPopupMenuCmd();
		
		this.jMenuItem00.addActionListener(uiPopupMenuCmd.actionListenerProgram());
		add(jMenuItem00);
		
		this.jMenuItem01.addActionListener(uiPopupMenuCmd.actionListenerEhternet());
		add(jMenuItem01);
		
		addPopupMenuListener(uiPopupMenuCmd.getPopupMenuListener(jMenuItem00, jMenuItem01));
		
		add(new JSeparator());
		
		final JMenuItem jMenuItem02 = new JMenuItem("Background Image");
		jMenuItem02.addActionListener(uiPopupMenuCmd.actionListenerBackgroundImage());
		add(jMenuItem02);
		
		add(new JSeparator());
		
		final JMenuItem jMenuItem03 = new JMenuItem("Power");
		jMenuItem03.addActionListener(uiPopupMenuCmd.actionListenerPower());
		add(jMenuItem03);
	}
	
}
