package kr.cleancode.dashboard.manager.ui;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.ui.center.UiCenterMain;
import kr.cleancode.dashboard.manager.ui.util.XrManagerLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 6474627909331729645L;
	
	private volatile static JFrameMain object = null;
	
	public static final JFrameMain getInstance(){
		if(object == null){
			synchronized (JFrameMain.class) {
				if(object == null){
					new XrManagerLookAndFeel().perform();
					
					object = new JFrameMain();
				}
			}
		}
		return object;
	}
	
	private JPanel contentPane = null;

	public JFrameMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameMain.class.getResource("/images/logo/impact_logo_20200301.png")));
		setTitle(XrManagerProperties.moduleName);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 1024, 768);
		setMinimumSize(new Dimension(1024, 768));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setAlwaysOnTop(true);
		
		this.contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		contentPane.add(UiCenterMain.getInstance(), BorderLayout.CENTER);
	}
	
}
