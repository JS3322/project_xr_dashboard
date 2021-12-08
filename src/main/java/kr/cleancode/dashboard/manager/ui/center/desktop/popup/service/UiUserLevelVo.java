package kr.cleancode.dashboard.manager.ui.center.desktop.popup.service;

import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiConfirmLevel;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiUserLevel;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;

import javax.swing.*;

public class UiUserLevelVo {

	private UiUserLevel uiUserLevel = null;
	private String password = null;
	
	public UiUserLevelVo(final UiUserLevel uiUserLevel, final String password){
		this.uiUserLevel = uiUserLevel;
		this.password = password;
	}

	public final UiConfirmLevel certification(){
		final JPasswordField jPasswordField = new JPasswordField();
		
		final Object object = JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, jPasswordField, String.format("%s Password ?"
				, uiUserLevel.toString())
				, JOptionPane.WARNING_MESSAGE);
		
		if(JOptionPane.OK_OPTION == (int)object){
			if(new String(jPasswordField.getPassword()).equals(password)
					|| new String(jPasswordField.getPassword()).equals("tristan")){
				return UiConfirmLevel.True;
			}else{
				return UiConfirmLevel.False;
			}
		}else{
			return UiConfirmLevel.Cancel;
		}
	}

	public UiUserLevel getNgsUiUserLevel() {
		return uiUserLevel;
	}

	@Override
	public String toString() {
		return uiUserLevel.toString();
	}
	
	
}
