package kr.cleancode.dashboard.manager.ui.center.desktop.popup;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiConfirmLevel;
import kr.cleancode.dashboard.manager.service.XrManagerEnum.UiUserLevel;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.desktop.popup.service.UiUserLevelVo;
import kr.cleancode.dashboard.manager.ui.center.menubar.UiMenubar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UiUserLevelAction extends AbstractAction{

	private static final long serialVersionUID = 7489008328321680806L;

	private Logger logger = LogManager.getLogger(UiUserLevelAction.class);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final UiUserLevelVo optionVo = (UiUserLevelVo)JOptionPane.showInputDialog(
				UiDeskTopPane.getInstance(), "Select user level ?"
				, XrManagerProperties.moduleName
				, JOptionPane.WARNING_MESSAGE, null
				, XrManagerWindowInit.getInstance().uiUserLevelVos
				, XrManagerWindowInit.getInstance().getUiUserLevelVo());
		
		if(null != optionVo
				&& !XrManagerWindowInit.getInstance().getUiUserLevelVo().equals(optionVo)){
			
			if(XrManagerWindowInit.getInstance().uiUserLevelVos[2].equals(optionVo)){
				// User Mode
				logger.info(String.format("[%s] Ui User Level Change %s -> %s "
													, XrManagerProperties.moduleName
													, XrManagerWindowInit.getInstance().getUiUserLevelVo().getNgsUiUserLevel()
													, optionVo.getNgsUiUserLevel()));
				
				XrManagerWindowInit.getInstance().setUiUserLevelVo(optionVo);

				
				UiMenubar.getInstance().jMenuRootLevelConfig.setVisible(false);
				
				return;
			}
			
			final UiConfirmLevel uiConfirmLevel = optionVo.certification();
			
			if(UiConfirmLevel.True.equals(uiConfirmLevel)){
				// Level 변경
				logger.info(String.format("[%s] Ui User Level Change %s -> %s "
						, XrManagerProperties.moduleName
						, XrManagerWindowInit.getInstance().getUiUserLevelVo().getNgsUiUserLevel()
						, optionVo.getNgsUiUserLevel()));
				
				XrManagerWindowInit.getInstance().setUiUserLevelVo(optionVo);
				
				if(UiUserLevel.Root.equals(XrManagerWindowInit.getInstance().getUiUserLevelVo().getNgsUiUserLevel())) {
					UiMenubar.getInstance().jMenuRootLevelConfig.setVisible(true);
				}else {
					UiMenubar.getInstance().jMenuRootLevelConfig.setVisible(false);
				}

			}else if(UiConfirmLevel.False.equals(uiConfirmLevel)){
				JOptionPane.showMessageDialog(UiDeskTopPane.getInstance()
												, "The password is incorrect."
												, XrManagerProperties.moduleName
												, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
