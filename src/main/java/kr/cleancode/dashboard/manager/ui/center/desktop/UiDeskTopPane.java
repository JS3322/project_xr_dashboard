
package kr.cleancode.dashboard.manager.ui.center.desktop;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import kr.cleancode.dashboard.manager.ui.center.desktop.popup.UiPopupMenu;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.UiProgram;
import kr.cleancode.dashboard.manager.ui.util.XrManagerBackground;

public class UiDeskTopPane extends JDesktopPane{

	private static final long serialVersionUID = -5447136211041869616L;

	private volatile static UiDeskTopPane object = null;
	
	public static final UiDeskTopPane getInstance(){
		if(object == null){
			synchronized (UiDeskTopPane.class) {
				if(object == null){
					object = new UiDeskTopPane();
				}
			}
		}
		return object;
	}
	
	private ImageIcon imageIcon = null;
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
		this.updateUI();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(null != this.imageIcon){
			new XrManagerBackground().changeBackground(g, imageIcon, this);
		}
	}
	
	public UiDeskTopPane() {
		setInheritsPopupMenu(true);
		
		setComponentPopupMenu(new UiPopupMenu());
		
		add(UiProgram.getInstance());
	}
}
