
package kr.cleancode.dashboard.manager.ui.center.desktop.program.cmd;

import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.UiProgramHistory;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.cmd.UiProgramHistoryCmd;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.UiProgramRemove;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd.UiProgramRemoveCmd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UiProgramCmd {

	public final ComponentAdapter getComponentAdapter() {
		return new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				new UiProgramHistoryCmd().tableReflash();
				new UiProgramRemoveCmd().tableReflash();
			}
		};
	}
	
	public final ItemListener getItemListener(final JPanel jPanel) {
		return new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				final JToggleButton jToggleButton = (JToggleButton)e.getSource();
				final CardLayout cardLayout = (CardLayout)jPanel.getLayout();
				
				if(ItemEvent.SELECTED == e.getStateChange()) {
					jToggleButton.setText("Program Remove");
					jToggleButton.setBackground(Color.pink);
					cardLayout.show(jPanel, UiProgramHistory.getInstance().getName());
				}else {
					jToggleButton.setText("Program History");
					jToggleButton.setBackground(Color.white);
					cardLayout.show(jPanel, UiProgramRemove.getInstance().getName());
				}
			}
		};
	}
	
	public final ActionListener getActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final kr.cleancode.dashboard.manager.ui.center.desktop.program.cmd.ProgramInstall programInstall = new kr.cleancode.dashboard.manager.ui.center.desktop.program.cmd.ProgramInstall();
				programInstall.install();
			}
		};
	}
}
