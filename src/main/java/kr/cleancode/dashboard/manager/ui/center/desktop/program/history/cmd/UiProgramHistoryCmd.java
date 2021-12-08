
package kr.cleancode.dashboard.manager.ui.center.desktop.program.history.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.ex.ModuleFunctionUtil;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.UiProgramHistory;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd.UiProgramRemoveCmd;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.date.DateFormatUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UiProgramHistoryCmd {

	private Logger logger = LogManager.getLogger(UiProgramHistoryCmd.class);
	
	public void tableEraser(){
		final DefaultTableModel defaultTableModel = UiProgramHistory.defaultTableModel;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				while (0 < defaultTableModel.getRowCount()) {
					defaultTableModel.removeRow(0);
				}
			}
		});
	}
	
	public void tableReflash(){
		this.tableEraser();
		final DefaultTableModel defaultTableModel = UiProgramHistory.defaultTableModel;
		final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
		final List<ProgramSqlVo> lTMngMiInfo = cmd.lTMngMiInfo(null);
		if(null != lTMngMiInfo && !lTMngMiInfo.isEmpty()){
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					for(ProgramSqlVo programSqlVo : lTMngMiInfo){
						defaultTableModel.addRow(new Object[]{programSqlVo});
					}
				}
			});
		}
	}
	
	public void restoreModule(final ProgramSqlVo programSqlVo){
		if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("Do you want to repair the module[%s %s]?", programSqlVo.getMODULE_NM(), programSqlVo.getVERSION())
				, XrManagerProperties.moduleName, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)){
			return;
		}
		
		final ModuleFunctionUtil moduleFunctionUtil = new ModuleFunctionUtil();
		
		final File srcFile = new File(programSqlVo.getPATH());
		if(!srcFile.exists()){
			JOptionPane.showMessageDialog(UiDeskTopPane.getInstance()
					, String.format("Module[%s %s] has been deleted and cannot be recovered.", programSqlVo.getMODULE_NM(), programSqlVo.getVERSION())
					, XrManagerProperties.moduleName, JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		final ModuleLoadVo moduleLoadVo = moduleFunctionUtil.xmlToModuleLoadvo(srcFile);
		if(null == moduleLoadVo){
			JOptionPane.showMessageDialog(UiDeskTopPane.getInstance()
					, String.format("Module[%s %s] is damaged and cannot be recovered.", programSqlVo.getMODULE_NM(), programSqlVo.getVERSION())
					, XrManagerProperties.moduleName, JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		final Iterator<ModuleLoadVo> iterator = XrManagerWindowInit.getInstance().modulesClasses.keySet().iterator();
		ModuleLoadVo stopModuleLoadVo = null;
		while(iterator.hasNext()){
			ModuleLoadVo checkModuleLoadVo = iterator.next(); 
			if(programSqlVo.getMODULE_NM().equals(checkModuleLoadVo.getModuleName())
					&& programSqlVo.getPK_SW_DIV_SER().equals(checkModuleLoadVo.getLisUpperPk())){
				stopModuleLoadVo = checkModuleLoadVo;
			}
		}
		
		// Database 이용
		final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
		try {
			if(null != stopModuleLoadVo){
				moduleFunctionUtil.moduleStop(stopModuleLoadVo);
			
				final File oldModuleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module.old"));
				if(!oldModuleFolder.exists()){
					oldModuleFolder.mkdirs();
				}
				
				final File targetFile = new File(oldModuleFolder.getAbsolutePath(), String.format("%s_%s_%s"
						, stopModuleLoadVo.getModuleName()
						, stopModuleLoadVo.getVersion()
						, DateFormatUtils.format(System.currentTimeMillis(), "YYYYMMDDHHmmssSSS")));
				
				FileUtils.copyFile(stopModuleLoadVo.getModuleFile(), targetFile);
				stopModuleLoadVo.getModuleFile().delete();
			
				final ProgramSqlVo sParamVo = new ProgramSqlVo();
				sParamVo.setPK_SW_DIV_SER(stopModuleLoadVo.getLisUpperPk());
				sParamVo.setMODULE_NM(stopModuleLoadVo.getModuleName());
				final ProgramSqlVo sResultVo = cmd.sTMngMiInfo(programSqlVo);
				
				final ProgramSqlVo uParamVo = new ProgramSqlVo();
				uParamVo.setPK_MI_SER(sResultVo.getPK_MI_SER());
				uParamVo.setUSE_YN("N");
				uParamVo.setPATH(targetFile.getAbsolutePath());
				
				cmd.uTMngMiInfo(uParamVo);
				
				logger.info(String.format("[%s] Module[%s %s] Remove", XrManagerProperties.moduleName, stopModuleLoadVo.getModuleName(), stopModuleLoadVo.getVersion()));
				
				final File moduleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module"));
				if(!moduleFolder.exists()){
					moduleFolder.mkdirs();
				}
			}
			
			// 복구
			final File moduleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module"));
			if(!moduleFolder.exists()){
				moduleFolder.mkdirs();
			}
			
			final File targetFile = new File(moduleFolder.getAbsolutePath(), String.format("%s %s.jar", programSqlVo.getMODULE_NM(), programSqlVo.getVERSION()));
			
			FileUtils.copyFile(srcFile, targetFile);
			
			if(!moduleFunctionUtil.moduleStart(targetFile, moduleLoadVo, new Point(0, 0))) {
				// DIO 는 재기동 해야만 한다.
				return;
			}
			
			final ProgramSqlVo iParamVo = new ProgramSqlVo();
			iParamVo.setPK_SW_DIV_SER(moduleLoadVo.getLisUpperPk());
			iParamVo.setMODULE_NM(moduleLoadVo.getModuleName());
			iParamVo.setMANUFACTURER(moduleLoadVo.getManufacturer());
			iParamVo.setDEVELOPER(moduleLoadVo.getDeveloper());
			iParamVo.setVERSION(moduleLoadVo.getVersion());
			iParamVo.setDESCRIPTION(moduleLoadVo.getDescription());
			iParamVo.setSIZE(String.format("%d", targetFile.length()));
			iParamVo.setPATH(targetFile.getAbsolutePath());
			
			cmd.iTMngMiInfo(iParamVo);
			
			this.tableReflash();
			new UiProgramRemoveCmd().tableReflash();
		} catch (IOException e) {
			logger.error(String.format("[%s] Exception Message: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
}
