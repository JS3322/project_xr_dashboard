/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.ui.center.menubar.ex;

import kr.cleancode.dashboard.manager.ui.util.XrManagerImageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UiMenuProgramIcon extends JMenuItem{

	private static final long serialVersionUID = -2739276071768291852L;

	private Logger logger = LogManager.getLogger(UiMenuProgramIcon.class);
	
	private String iconName = null;
	private Image image = null; 
	
	public UiMenuProgramIcon(final Class<?> loadGuiClass, final Object objectGui){
		final JInternalFrame jInternalFrame = (JInternalFrame)objectGui;
		
		// 바탕 화면 아이콘 제거
		jInternalFrame.getDesktopIcon().setUI(null);
		
		this.iconName = jInternalFrame.getName();
		setText(jInternalFrame.getName());
		
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
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
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
