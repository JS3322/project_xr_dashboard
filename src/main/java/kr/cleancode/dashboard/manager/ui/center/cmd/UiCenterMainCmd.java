
package kr.cleancode.dashboard.manager.ui.center.cmd;

import kr.cleancode.dashboard.manager.ui.center.desktop.popup.UiUserLevelAction;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UiCenterMainCmd {

	public void setHidenMenu(final JPanel jPanel) {
		final String hidenMenu = "Hidden Menu";
		
		final ActionMap actionMap = jPanel.getActionMap();
		final InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), hidenMenu);
		actionMap.put(hidenMenu, new UiUserLevelAction());
	}
	
}
