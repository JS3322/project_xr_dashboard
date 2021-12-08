/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.ui.center.menubar.ex;

import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiUserLevel;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.service.UiUserLevelVo;
import kr.cleancode.dashboard.manager.ui.util.XrManagerImageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UiMenuIcon extends JButton{

	private static final long serialVersionUID = 4727763161706279943L;

	private Logger logger = LogManager.getLogger(UiMenuIcon.class);
	
	private String iconName = null;
	private Image image = null; 
	
	@Override
	protected void paintComponent(Graphics g) {
		if(null != image) {
			final Graphics2D graphics2d = (Graphics2D)g;
			graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
			graphics2d.drawImage(image, 0, 2, getWidth() - 5, getHeight() - 5, this);
			graphics2d.finalize();
		}else {
			super.paintComponent(g);
		}
	}

	public UiMenuIcon(final Class<?> loadGuiClass, final Object objectGui){
		final JInternalFrame jInternalFrame = (JInternalFrame)objectGui;
		
		// 바탕 화면 아이콘 제거
		jInternalFrame.getDesktopIcon().setUI(null);
		
		// Titlebar 제거
		if(UiUserLevel.User.equals(XrManagerWindowInit.getInstance().getUiUserLevelVo().getNgsUiUserLevel())){
			final BasicInternalFrameUI basicInternalFrameUI = (BasicInternalFrameUI)jInternalFrame.getUI();
			basicInternalFrameUI.setNorthPane(null);
			jInternalFrame.getJMenuBar().setVisible(false);
			jInternalFrame.revalidate();
			jInternalFrame.repaint();
			jInternalFrame.setResizable(false);
		}
		
		this.iconName = jInternalFrame.getName();
		setToolTipText(jInternalFrame.getName());
		
		try {
			Method method = loadGuiClass.getMethod("getModuleIconImage");
			this.image = (Image) method.invoke(objectGui);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			logger.warn(String.format("[%s] UiMenuIcon Exception.", e));
		}
		
		if(null == image){
			setText(iconName);
		}else{
			setIcon(XrManagerImageUtil.imageSizeChange(image, 32, 32));
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				updateUI();
			}
		});
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					final UiUserLevelVo uiUserLevelVo = XrManagerWindowInit.getInstance().getUiUserLevelVo();
					
					if(UiUserLevel.User.equals(uiUserLevelVo.getNgsUiUserLevel())) {
						if(!jInternalFrame.isIcon()) {
							jInternalFrame.setIcon(true);
							jInternalFrame.setIcon(false);
						}
						return;
					}
					
					if(!jInternalFrame.isShowing()){
						jInternalFrame.setIcon(false);
						jInternalFrame.setSelected(true);
					}else{
						jInternalFrame.setIcon(true);
					}
				} catch (PropertyVetoException e1) {
					logger.warn(String.format("[%s] UiMenuIcon Exception.", e));
				}
			}
		});
	}

	public String getIconName() {
		return iconName;
	}

	public Image getImage() {
		return image;
	}
	
	
}
