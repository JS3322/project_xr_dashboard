package kr.cleancode.dashboard.manager.ui.center.desktop.program.cmd;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.init.XrManagerWindowInit;
import kr.cleancode.dashboard.manager.module.ex.ModuleFunctionUtil;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import kr.cleancode.dashboard.manager.ui.center.desktop.UiDeskTopPane;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.history.cmd.UiProgramHistoryCmd;
import kr.cleancode.dashboard.manager.ui.center.desktop.program.remove.cmd.UiProgramRemoveCmd;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.date.DateFormatUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class ProgramInstall {
	
	private Logger logger = LogManager.getLogger(ProgramInstall.class);
	
	private final JFileChooser jFileChooser = this.createJFileChooser();
	
	public void install(){
		final UiDeskTopPane uiDeskTopPane = UiDeskTopPane.getInstance();
		
		final int numberOption = jFileChooser.showOpenDialog(uiDeskTopPane);
		
		if(JFileChooser.APPROVE_OPTION != numberOption){
			return;
		}
		
		final File selectedFile = jFileChooser.getSelectedFile();
		XrManagerWindowInit.getInstance().currentDirectory = selectedFile.getParentFile();
		
		try {
			// NGS 모듈 확인
			final ModuleFunctionUtil moduleFunctionUtil = new ModuleFunctionUtil();
			if(!moduleFunctionUtil.moduleValidation(selectedFile)){
				return;
			}
			
			final ModuleLoadVo moduleLoadVo = moduleFunctionUtil.xmlToModuleLoadvo(selectedFile);
			if(null == moduleLoadVo){
				return;
			}
			
			// Database 이용
			final ProgramSqlService cmd = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
			
			// Database 조회
			final ProgramSqlVo sParamVo = new ProgramSqlVo();
			sParamVo.setPK_SW_DIV_SER(moduleLoadVo.getLisUpperPk());
			sParamVo.setMODULE_NM(moduleLoadVo.getModuleName());
			
			final ProgramSqlVo sResultVo = cmd.sTMngMiInfo(sParamVo);
			if(null == sResultVo){
				// 최초 설치
				logger.info(String.format("[%s] The following modules are to be installed: [%s %s]", XrManagerProperties.moduleName, moduleLoadVo.getModuleName(), moduleLoadVo.getVersion()));
				if(!this.moduleInstall(moduleFunctionUtil, moduleLoadVo)){
					return;
				}
			}else{
				// 업데이트, 재설치, 다운 그레이 
				if(moduleLoadVo.getVersion().equals(sResultVo.getVERSION())){
					// 재설치
					logger.info(String.format("[%s] The following modules are to be reinstalled: [%s %s -> %s %s]"
							, XrManagerProperties.moduleName
							, sResultVo.getMODULE_NM(), sResultVo.getVERSION()
							, moduleLoadVo.getModuleName(), moduleLoadVo.getVersion()));
					if(!this.moduleReInstall(moduleFunctionUtil, moduleLoadVo, sResultVo)){
						return;
					}
				}else{
					// 업데이트 또는 다운 그레이
					if(sResultVo.getVERSION().equals(this.versionCompare(moduleLoadVo.getVersion(), sResultVo.getVERSION()))){
						// 업데이트
						logger.info(String.format("[%s] The following modules are to be updated: [%s %s -> %s %s]"
								, XrManagerProperties.moduleName
								, sResultVo.getMODULE_NM(), sResultVo.getVERSION()
								, moduleLoadVo.getModuleName(), moduleLoadVo.getVersion()));
						if(!this.moduleUpdate(moduleFunctionUtil, moduleLoadVo, sResultVo)){
							return;
						}
					}else{
						// 다운 그레이
						logger.info(String.format("[%s] The following modules are to be downgrade: [%s %s -> %s %s]"
								, XrManagerProperties.moduleName
								, sResultVo.getMODULE_NM(), sResultVo.getVERSION()
								, moduleLoadVo.getModuleName(), moduleLoadVo.getVersion()));
						if(!this.moduleDowngrade(moduleFunctionUtil, moduleLoadVo, sResultVo)){
							return;
						}
					}
				}
			}
			
			if(null != sResultVo){
				// Module 중지
				final Iterator<ModuleLoadVo> iterator = XrManagerWindowInit.getInstance().modulesClasses.keySet().iterator();
				ModuleLoadVo stopModuleLoadVo = null;
				while(iterator.hasNext()){
					ModuleLoadVo checkModuleLoadVo = iterator.next(); 
					if(sResultVo.getMODULE_NM().equals(checkModuleLoadVo.getModuleName())
							&& sResultVo.getVERSION().equals(checkModuleLoadVo.getVersion())
							&& sResultVo.getPK_SW_DIV_SER().equals(checkModuleLoadVo.getLisUpperPk())){
						stopModuleLoadVo = checkModuleLoadVo;
					}
				}
				if(null != stopModuleLoadVo){
					moduleFunctionUtil.moduleStop(stopModuleLoadVo);
				}
				
				final File oldModuleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module.old"));
				if(!oldModuleFolder.exists()){
					oldModuleFolder.mkdirs();
				}
				
				final File targetFile = new File(oldModuleFolder.getAbsolutePath(), String.format("%s_%s_%s"
						, moduleLoadVo.getModuleName()
						, moduleLoadVo.getVersion()
						, DateFormatUtils.format(System.currentTimeMillis(), "YYYYMMDDHHmmssSSS")));
				
				FileUtils.copyFile(stopModuleLoadVo.getModuleFile(), targetFile);
				stopModuleLoadVo.getModuleFile().delete();
				
				final ProgramSqlVo uParamVo = new ProgramSqlVo();
				uParamVo.setPK_MI_SER(sResultVo.getPK_MI_SER());
				uParamVo.setUSE_YN("N");
				uParamVo.setPATH(targetFile.getAbsolutePath());
				
				cmd.uTMngMiInfo(uParamVo);
			}
			
			final File moduleFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.module"));
			if(!moduleFolder.exists()){
				moduleFolder.mkdirs();
			}
			
			final File targetFile = new File(moduleFolder.getAbsolutePath(), String.format("%s %s.jar", moduleLoadVo.getModuleName(), moduleLoadVo.getVersion())); 
			FileUtils.copyFile(selectedFile, targetFile);
			
			if(!moduleFunctionUtil.moduleStart(targetFile, moduleLoadVo, new Point(0, 0))) {
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
			
			logger.info(String.format("[%s] The following modules have been installed: [%s %s]"
					, XrManagerProperties.moduleName
					, iParamVo.getMODULE_NM(), iParamVo.getVERSION()));
			
			new UiProgramHistoryCmd().tableReflash();
			new UiProgramRemoveCmd().tableReflash();
		} catch (IOException e) {
			logger.error(String.format("[%s] Exception Message: %s", XrManagerProperties.moduleName, e.getMessage()), e);
		}
	}
	
	private final JFileChooser createJFileChooser(){
		final JFileChooser jFileChooser = new JFileChooser(){
			private static final long serialVersionUID = -696729171070563674L;

			@Override
			protected JDialog createDialog(java.awt.Component parent) throws java.awt.HeadlessException {
				final JDialog jDialog  = super.createDialog(parent);
				jDialog.setAlwaysOnTop(true);
				jDialog.setLocationByPlatform(true);
				jDialog.setLocationRelativeTo(UiDeskTopPane.getInstance());
				
				return jDialog;
			};
		};
		
		jFileChooser.setAcceptAllFileFilterUsed(false);
		jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XR Module", "jar"));
		jFileChooser.setMultiSelectionEnabled(false);
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jFileChooser.setCurrentDirectory(XrManagerWindowInit.getInstance().currentDirectory);
		
		return jFileChooser;
	}
	
	private final boolean moduleInstall(final ModuleFunctionUtil moduleFunctionUtil, final ModuleLoadVo moduleLoadVo){
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("Are you sure you want to install Module[%s %s]?", moduleLoadVo.getModuleName(), moduleLoadVo.getVersion())
				, XrManagerProperties.moduleName
				, JOptionPane.OK_CANCEL_OPTION
				, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private final boolean moduleUpdate(final ModuleFunctionUtil moduleFunctionUtil, final ModuleLoadVo moduleLoadVo, final ProgramSqlVo sResultVo){
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("Are you sure you want to install Module[%s %s]?", moduleLoadVo.getModuleName(), moduleLoadVo.getVersion())
				, XrManagerProperties.moduleName
				, JOptionPane.OK_CANCEL_OPTION
				, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private final boolean moduleReInstall(final ModuleFunctionUtil moduleFunctionUtil, final ModuleLoadVo moduleLoadVo, final ProgramSqlVo sResultVo){
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("There is already the same module[%s %s] that you want to install. Are you sure you want to reinstall?", moduleLoadVo.getModuleName(), moduleLoadVo.getVersion())
				, XrManagerProperties.moduleName
				, JOptionPane.OK_CANCEL_OPTION
				, JOptionPane.WARNING_MESSAGE);
	}
	
	private String versionCompare(String...strings){
		Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
		
		return strings[strings.length - 1];
	}
	
	private final boolean moduleDowngrade(final ModuleFunctionUtil moduleFunctionUtil, final ModuleLoadVo moduleLoadVo, final ProgramSqlVo sResultVo){
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(UiDeskTopPane.getInstance()
				, String.format("The version of the module[%s %s] you are installing is lower than the version of the module[%s %s] that is installed. Do you still want to install it?", sResultVo.getMODULE_NM(), sResultVo.getVERSION(), moduleLoadVo.getModuleName(), moduleLoadVo.getVersion())
				, XrManagerProperties.moduleName
				, JOptionPane.OK_CANCEL_OPTION
				, JOptionPane.WARNING_MESSAGE);
	}
}
