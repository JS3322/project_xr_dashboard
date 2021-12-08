
package kr.cleancode.dashboard.manager.module.ex;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlService;
import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ModuleGuiFunctionUtil {

	private Logger logger = LogManager.getLogger(ModuleGuiFunctionUtil.class);
	
	public final CoordinatesSqlVo getCoordinates(final String lisUpperPk, final String moduleName){
		final CoordinatesSqlVo paramVo = new CoordinatesSqlVo();
		paramVo.setPK_SW_DIV_SER(lisUpperPk);
		paramVo.setMODULE_NM(moduleName);
		
		final CoordinatesSqlService cmd = (CoordinatesSqlService)SpringInit.getBean("CoordinatesSqlService");
		
		return cmd.sViewHistory(paramVo);
	}
	
	public void setCoordinates(){
		final Iterator<ModuleLoadVo> iterator = XrManagerWindowInit.getInstance().modulesClasses.keySet().iterator();
		
		while (iterator.hasNext()) {
			final ModuleLoadVo moduleLoadVo = iterator.next();
			
			final JInternalFrame jInternalFrame = (JInternalFrame)moduleLoadVo.getObjectGui();
			final Rectangle rectangle = jInternalFrame.getBounds();
			
			final int axisX = rectangle.x;
			final int axisY = rectangle.y;
			final int width = rectangle.width;
			final int height = rectangle.height;
			
			final boolean isMaximum = jInternalFrame.isMaximum();
			final boolean isIcon = jInternalFrame.isIcon();
			
			final int iconAxisX = jInternalFrame.getDesktopIcon().getBounds().x;
			final int iconAxisY = jInternalFrame.getDesktopIcon().getBounds().y;
			
			// 이전 조회
			final CoordinatesSqlVo coordinatesSqlVo = this.getCoordinates(moduleLoadVo.getLisUpperPk(), moduleLoadVo.getModuleName());
			
			final CoordinatesSqlService cmd = (CoordinatesSqlService)SpringInit.getBean("CoordinatesSqlService");
			if(null == coordinatesSqlVo){
				final CoordinatesSqlVo paramVo = new CoordinatesSqlVo();
				paramVo.setPK_SW_DIV_SER(moduleLoadVo.getLisUpperPk());
				paramVo.setMODULE_NM(moduleLoadVo.getModuleName());
				paramVo.setAXIS_X(axisX);
				paramVo.setAXIS_Y(axisY);
				paramVo.setRTG_WIDTH(width);
				paramVo.setRTG_HEIGHT(height);
				paramVo.setMAXIMUM(isMaximum ? "Y" : "N");
				paramVo.setMINIMUM(isIcon ? "Y" : "N");
				paramVo.setICON_AXIS_X(iconAxisX);
				paramVo.setICON_AXIS_Y(iconAxisY);
				
				cmd.iViewHistory(paramVo);
				
				logger.debug(String.format("[%s] Record module(%s) status at shutdown, x: %d, y: %d, width: %d, height: %d isMaximum: %b, isIcon: %b iconX: %d, iconY: %d"
						, XrManagerProperties.moduleName, moduleLoadVo.getModuleName()
						, axisX, axisY, width, height, isMaximum, isIcon
						, iconAxisX, iconAxisY));
			}else{
				final CoordinatesSqlVo paramVo = new CoordinatesSqlVo();
				paramVo.setPK_MFS_SER(coordinatesSqlVo.getPK_MFS_SER());
				paramVo.setPK_SW_DIV_SER(moduleLoadVo.getLisUpperPk());
				paramVo.setMODULE_NM(moduleLoadVo.getModuleName());
				paramVo.setAXIS_X(axisX);
				paramVo.setAXIS_Y(axisY);
				paramVo.setRTG_WIDTH(width);
				paramVo.setRTG_HEIGHT(height);
				paramVo.setMAXIMUM(isMaximum ? "Y" : "N");
				paramVo.setMINIMUM(isIcon ? "Y" : "N");
				paramVo.setPK_MIS_SER(coordinatesSqlVo.getPK_MIS_SER());
				paramVo.setICON_AXIS_X(iconAxisX);
				paramVo.setICON_AXIS_Y(iconAxisY);
				
				cmd.uViewHistory(paramVo);
				
				logger.debug(String.format("[%s] Modify module(%s) status at shutdown, x: %d, y: %d, width: %d, height: %d isMaximum: %b, isIcon: %b iconX: %d, iconY: %d"
						, XrManagerProperties.moduleName, moduleLoadVo.getModuleName()
						, axisX, axisY, width, height, isMaximum, isIcon
						, iconAxisX, iconAxisY));
			}
		}
	}
}
