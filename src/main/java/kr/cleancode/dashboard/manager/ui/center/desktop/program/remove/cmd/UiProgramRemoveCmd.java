package kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.ex.ModuleFunctionUtil;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.cmd.UiProgramHistoryCmd;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.UiProgramRemove;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd.ex.UiProgramRemoveUtil;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.date.DateFormatUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UiProgramRemoveCmd {

	private Logger logger = LogManager.getLogger(UiProgramRemoveCmd.class);
	
	public void tableEraser(){
		final DefaultTableModel defaultTableModel = UiProgramRemove.defaultTableModel;
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
		final DefaultTableModel defaultTableModel = UiProgramRemove.defaultTableModel;
		
		final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
		
		final ProgramSqlVo paramVo = new ProgramSqlVo();
		paramVo.setUSE_YN("Y");
		
		final List<ProgramSqlVo> lTMngMiInfo = cmd.lTMngMiInfo(paramVo);
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
	
	public void moduleRemove(final ProgramSqlVo programSqlVo){
		if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("Are you sure you want to delete the module[%s %s]?", programSqlVo.getMODULE_NM(), programSqlVo.getVERSION())
				, XrManagerProperties.moduleName, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)){
			return;
		}
		
		final Iterator<ModuleLoadVo> iterator = XrManagerWindowInit.getInstance().modulesClasses.keySet().iterator();
		ModuleLoadVo stopModuleLoadVo = null;
		while(iterator.hasNext()){
			ModuleLoadVo checkModuleLoadVo = iterator.next(); 
			if(programSqlVo.getMODULE_NM().equals(checkModuleLoadVo.getModuleName())
					&& programSqlVo.getVERSION().equals(checkModuleLoadVo.getVersion())
					&& programSqlVo.getPK_SW_DIV_SER().equals(checkModuleLoadVo.getLisUpperPk())){
				stopModuleLoadVo = checkModuleLoadVo;
			}
		}
		
		if(null != stopModuleLoadVo){
			new ModuleFunctionUtil().moduleStop(stopModuleLoadVo);
			
			final File oldModuleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module.old"));
			if(!oldModuleFolder.exists()){
				oldModuleFolder.mkdirs();
			}
			
			final File targetFile = new File(oldModuleFolder.getAbsolutePath(), String.format("%s_%s_%s"
					, stopModuleLoadVo.getModuleName()
					, stopModuleLoadVo.getVersion()
					, DateFormatUtils.format(System.currentTimeMillis(), "YYYYMMDDHHmmssSSS")));
			
			try {
				FileUtils.copyFile(stopModuleLoadVo.getModuleFile(), targetFile);
				stopModuleLoadVo.getModuleFile().delete();
			
				final ProgramSqlVo uParamVo = new ProgramSqlVo();
				uParamVo.setPK_MI_SER(programSqlVo.getPK_MI_SER());
				uParamVo.setUSE_YN("N");
				uParamVo.setPATH(targetFile.getAbsolutePath());
				
				final boolean rebootCheck = UiProgramRemoveUtil.deleteRebootCheck(stopModuleLoadVo.getLisUpperPk());
				
				// Database 이용
				final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
				cmd.uTMngMiInfo(uParamVo);
				
				logger.info(String.format("[%s] Module[%s %s] Remove", XrManagerProperties.moduleName, stopModuleLoadVo.getModuleName(), stopModuleLoadVo.getVersion()));
				
				new UiProgramHistoryCmd().tableReflash();
				new UiProgramRemoveCmd().tableReflash();
				
				if(rebootCheck) {

					final String message = String.format("The following modules can be used after reboot.[%s]", stopModuleLoadVo.getModuleName());
					JOptionPane.showMessageDialog(UiProgramRemove.getInstance(), message, XrManagerProperties.moduleName, JOptionPane.WARNING_MESSAGE);
					System.exit(1);
				}
			} catch (IOException e) {
				logger.error(String.format("[%s] Module[%s %s] Remove Exception", XrManagerProperties.moduleName, programSqlVo.getMODULE_NM(), programSqlVo.getVERSION()), e);
			}
		}
	}
}
