
package kr.cleancode.dashboard.manager.ui.center.menubar.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiUserLevel;
import kr.cleancode.dashboard.manager.ui.JFrameMain;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.cmd.UiPopupMenuCmd;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.service.UiUserLevelVo;
import kr.cleancode.dashboard.manager.ui.center.menubar.UiMenubar;
import kr.cleancode.dashboard.manager.ui.os.XrManagerOsCommand;
import kr.cleancode.dashboard.manager.ui.util.XrManagerImageUtil;
import kr.cleancode.dashboard.manager.util.ThreadSleep;
import org.sqlite.date.DateFormatUtils;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiMenubarCmd {

	public final JMenuBar memuPanel(final JMenu jMenuProgram, final JMenu jMenuModuleTest, final JMenu jMenuRootLevelConfig){
		final JMenuBar jMenuBar = new JMenuBar(){
			private static final long serialVersionUID = -793961347971207026L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D graphics2d = (Graphics2D)g;
				graphics2d.setColor(Color.black);
				graphics2d.fillRect(0, 0, getWidth(), getHeight());
			}
			
		};
		jMenuBar.setOpaque(false);
		
		final JMenu jMenu = new JMenu();
		jMenu.setIcon(XrManagerImageUtil.imageSizeChange(Toolkit.getDefaultToolkit().getImage(UiMenubar.class.getResource("/images/logo/impact_logo_20200301.png")), 32, 32));
		jMenuBar.add(jMenu);
		
		jMenu.add(jMenuProgram);
		
		jMenu.addMenuListener(new MenuListener() {
			private void perform() {
				final UiUserLevelVo ngsUiUserLevelVo = XrManagerWindowInit.getInstance().getUiUserLevelVo();
				
				if(UiUserLevel.User.equals(ngsUiUserLevelVo.getNgsUiUserLevel())) {
					jMenuProgram.setVisible(false);
				}else {
					jMenuProgram.setVisible(true);
				}
				
				if(0 < jMenuModuleTest.getMenuComponentCount()) {
					jMenuModuleTest.setVisible(true);
				}else {
					jMenuModuleTest.setVisible(false);
				}
			}
			public void menuCanceled(MenuEvent e) {}
			public void menuDeselected(MenuEvent e) {
				this.perform();
			}
			public void menuSelected(MenuEvent e) {
				this.perform();
			}
		});
		
		jMenu.add(jMenuModuleTest);
		jMenuModuleTest.setVisible(false);
		
		final JMenu jMenuSub00 = new JMenu("Control");
		jMenu.add(jMenuSub00);
		{
			final JMenuItem jMenuItem = new JMenuItem("Code Transfer");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					if(UiTest.getInstance().isVisible()) {
//						JOptionPane.showMessageDialog(NgsDeskTopPane.getInstance(), "Cannot be used with 'Code Test'.", NgsProperties.moduleName, JOptionPane.WARNING_MESSAGE);
//						UiTransfer000000.getInstance().setVisible(false);
//						return;
//					}
//					
//					UiTransfer000000.getInstance().setVisible(!UiTransfer000000.getInstance().isVisible());
				}
			});
			jMenuSub00.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Code Test");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					if(UiTransfer000000.getInstance().isVisible()) {
//						JOptionPane.showMessageDialog(NgsDeskTopPane.getInstance(), "Cannot be used with 'Code Transfer'.", NgsProperties.moduleName, JOptionPane.WARNING_MESSAGE);
//						UiTest.getInstance().setVisible(false);
//						return;
//					}
//					
//					UiTest.getInstance().setVisible(!UiTest.getInstance().isVisible());
				}
			});
			jMenuSub00.add(jMenuItem);
		}
		
		final JMenu jMenuSub01 = new JMenu("Resource");
		jMenu.add(jMenuSub01);
		{
			final JMenuItem jMenuItem = new JMenuItem("Background Image");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					new BackgroundChange().change();
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Resource Monitor");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiResourceMornitor.getInstance().setVisible(!UiResourceMornitor.getInstance().isVisible());
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Ethernet Information");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiEthernetViewer.getInstance().setVisible(!UiEthernetViewer.getInstance().isVisible());
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("ARP Information");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiArpViewer.getInstance().setVisible(!UiArpViewer.getInstance().isVisible());
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Log Viewer");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiLogViewer.getInstance().setVisible(!UiLogViewer.getInstance().isVisible());
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("About");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					NgsAboutDialog.getInstance().setVisible(!NgsAboutDialog.getInstance().isVisible());
				}
			});
			jMenuSub01.add(jMenuItem);
		}
		
		jMenu.add(jMenuRootLevelConfig);
		jMenuRootLevelConfig.setVisible(false);
		{
			final JMenuItem jMenuItem = new JMenuItem("Program Install / Remove");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiProgram.getInstance().setVisible(true);
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		{
			final JMenuItem jMenuItem = new JMenuItem("Ethernet");
			jMenuItem.setForeground(Color.pink);
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					UiEthernetViewer.getInstance().setVisible(false);
//					try {
//						if(System.getProperty("os.name").indexOf("Windows") > -1){
//							String[] cmd = new String[3];
//							cmd[0] = "cmd";
//							cmd[1] = "/c";
//							cmd[2] = "ncpa.cpl";
//							new ProcessBuilder(cmd).start();
//						}else{
//							List<String> cmdList = new ArrayList<String>();
//							//cmdList.add("bash");
//							//cmdList.add("-c");
//							cmdList.add("nm-connection-editor");
//							new ProcessBuilder(cmdList).start();
//						}
//					} catch (IOException e2) {}
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		{
			final JMenuItem jMenuItem = new JMenuItem("Date / Time");
			jMenuItem.setForeground(Color.pink);
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new XrManagerOsCommand().osCallDateTimeConfig();
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		{
			final JMenuItem jMenuItem = new JMenuItem("Firewall");
			jMenuItem.setForeground(Color.pink);
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new XrManagerOsCommand().osCallFirewall();
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		if(-1 == System.getProperty("os.name").indexOf("Windows")) {
			final JMenuItem jMenuItem = new JMenuItem("Removable Drives and Media");
			jMenuItem.setForeground(Color.pink);
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new XrManagerOsCommand().osCallRemoveDrivesAndMedia();
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Location Information System Config");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					final CardLayout cardLayout = (CardLayout)UiCenter.getInstance().getLayout();
//					cardLayout.show(UiCenter.getInstance(), UiCenterConfig0000.getInstance().getName());
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem("Contents Distribution System Config");
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		
		{
			final JMenuItem jMenuItem = new JMenuItem(String.format("%s Window Off", XrManagerProperties.moduleName));
			jMenuItem.setForeground(Color.red);
			jMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			jMenuRootLevelConfig.add(jMenuItem);
		}
		
		jMenu.add(new JSeparator());
		
		final JMenuItem jMenuItemPower = new JMenuItem("Power");
		jMenuItemPower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UiPopupMenuCmd().getShutdownOption();
			}
		});
		jMenuItemPower.setIcon(XrManagerImageUtil.imageSizeChange(Toolkit.getDefaultToolkit().getImage(JFrameMain.class.getResource("/images/power/icon_power_off.png")), 16, 16));
		
		jMenu.add(jMenuItemPower);
		
		return jMenuBar;
	}
	
	public final JToolBar toolbarPanel(){
		final JToolBar jToolBar = new JToolBar(JToolBar.HORIZONTAL){
			private static final long serialVersionUID = 5701722662912304988L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				final Graphics2D graphics2d = (Graphics2D)g;
				graphics2d.setColor(Color.black);
				graphics2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		jToolBar.setOpaque(false);
		jToolBar.setName("XR Manager Module Icon");
		
		return jToolBar;
	}
	
	public final JPanel dateTimePanel(){
		final JPanel jPanel = new JPanel();
		jPanel.setOpaque(false);
		jPanel.setLayout(new GridLayout(0, 1));
		
		final JLabel lblDate = new JLabel("YYYY-MM-dd", JLabel.CENTER);
		lblDate.setForeground(Color.white);
		jPanel.add(lblDate);
		
		final JLabel lblTime = new JLabel("HH:mm:ss", JLabel.CENTER);
		lblTime.setForeground(Color.white);
		jPanel.add(lblTime);
		
		final Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					lblDate.setText(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"));
					lblTime.setText(DateFormatUtils.format(System.currentTimeMillis(), "HH:mm:ss"));
					ThreadSleep.sleep(500);
				}
			}
		});
		thread.setDaemon(true);
		thread.setName(String.format("[%s] XR Manager Window Toolbar DateTime Thread", XrManagerProperties.moduleName));
		thread.start();
		
		return jPanel;
	}
	
}
