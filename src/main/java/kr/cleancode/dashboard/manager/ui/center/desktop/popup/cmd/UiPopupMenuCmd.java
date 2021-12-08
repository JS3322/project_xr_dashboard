
package kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.ui.JFrameMain;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.UiProgram;
import kr.cleancode.dashboard.manager.ui.os.XrManagerOsCommand;
import kr.cleancode.dashboard.manager.ui.util.XrManagerImageUtil;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPopupMenuCmd {

	public final ActionListener actionListenerProgram() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						UiProgram.getInstance().setVisible(true);
						UiProgram.getInstance().setFocusable(true);
					}
				});
			}
		};
	}
	
	public final ActionListener actionListenerEhternet() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new XrManagerOsCommand().osCallEthernetConfig();
			}
		};
	}
	
	public final ActionListener actionListenerBackgroundImage() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BackgroundChange().change();
			}
		};
	}
	
	public final ActionListener actionListenerPower() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getShutdownOption();
			}
		};
	}
	
	public final PopupMenuListener getPopupMenuListener(final JMenuItem jMenuItem00, final JMenuItem jMenuItem01) {
		return new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				if(XrManagerWindowInit.getInstance().uiUserLevelVos[0].equals(XrManagerWindowInit.getInstance().getUiUserLevelVo())){
					jMenuItem00.setVisible(true);
					jMenuItem01.setVisible(true);
				}else if(XrManagerWindowInit.getInstance().uiUserLevelVos[1].equals(XrManagerWindowInit.getInstance().getUiUserLevelVo())){
					jMenuItem00.setVisible(false);
					jMenuItem01.setVisible(false);
				}else{
					jMenuItem00.setVisible(false);
					jMenuItem01.setVisible(false);
				}
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
		};
	}
	
	public final void getShutdownOption(){
		final JOptionPane jOptionPane = new JOptionPane("Please select carefully and press the button.", JOptionPane.WARNING_MESSAGE);
		
		final JDialog jDialog = jOptionPane.createDialog(JFrameMain.getInstance(), XrManagerProperties.moduleName);
		jDialog.setSize(new Dimension(420, 180));
		
		final JButton[] jButtons = this.getShutdownOptions(jDialog);
		jOptionPane.setOptions(jButtons);
		jDialog.setAlwaysOnTop(true);
		jDialog.setModal(true);
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
	
	private final JButton[] getShutdownOptions(final JDialog jDialog){
		final JButton btnShutdown = new JButton("Power Off");
		btnShutdown.setIcon(XrManagerImageUtil.imageSizeChange(Toolkit.getDefaultToolkit().getImage(PopupMenu.class.getResource("/images/power/icon_power_off.png")), 30, 30));
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int option = JOptionPane.showConfirmDialog((JButton)e.getSource()
																, "Are you sure you want to turn off the power?"
																, XrManagerProperties.moduleName
																, JOptionPane.OK_CANCEL_OPTION
																, JOptionPane.WARNING_MESSAGE);
				
				if(JOptionPane.OK_OPTION == option){
					new XrManagerOsCommand().osCallShutdown();
				}
			}
		});
		
		final JButton btnReboot = new JButton("Reboot");
		btnReboot.setIcon(XrManagerImageUtil.imageSizeChange(Toolkit.getDefaultToolkit().getImage(PopupMenu.class.getResource("/images/power/icon_power_reboot.png")), 30, 30));
		btnReboot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int option = JOptionPane.showConfirmDialog((JButton)e.getSource()
																, "Are you sure this is a reboot?"
																, XrManagerProperties.moduleName
																, JOptionPane.OK_CANCEL_OPTION
																, JOptionPane.WARNING_MESSAGE);
				
				if(JOptionPane.OK_OPTION == option){
					new XrManagerOsCommand().osCallReboot();
				}
			}
		});
		
		final JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(XrManagerImageUtil.imageSizeChange(Toolkit.getDefaultToolkit().getImage(PopupMenu.class.getResource("/images/power/icon_power_cancel.png")), 30, 30));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialog.dispose();
			}
		});
		
		final JButton[] jButtons = {btnShutdown, btnReboot, btnCancel};
		
		return jButtons;
	} 
}
