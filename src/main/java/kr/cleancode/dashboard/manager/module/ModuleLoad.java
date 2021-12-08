
package kr.cleancode.dashboard.manager.module;

import java.awt.Point;
import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.module.ex.ModuleFunctionUtil;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;
import kr.cleancode.dashboard.manager.module.service.ModuleLoadVo;
import kr.cleancode.dashboard.manager.spring.SpringInit;
import kr.cleancode.dashboard.manager.util.ThreadSleep;

public class ModuleLoad {

	private Logger logger = LogManager.getLogger(ModuleLoad.class);
	
	public void load() {
		final ProgramSqlService programSqlService = (ProgramSqlService)SpringInit.getBean("ProgramSqlService");
		
		final ProgramSqlVo paramVo = new ProgramSqlVo();
		paramVo.setUSE_YN("Y");
		
		final List<ProgramSqlVo> programSqlVos = programSqlService.lTMngMiInfo(paramVo);
		if(null == programSqlVos){
			return;
		}else if(programSqlVos.isEmpty()) {
			return;
		}
		
		logger.info(String.format("[%s] Module Load Sequence", XrManagerProperties.moduleName));
		for(final ProgramSqlVo programSqlVo : programSqlVos){
			logger.info(String.format("[%s] Module: %s", XrManagerProperties.moduleName, programSqlVo.getMODULE_NM()));
		}
		logger.info(String.format("[%s] Module Load Sequence End", XrManagerProperties.moduleName));
		
		int pointX = 0;
		int pointY = 0;
		
		final ModuleFunctionUtil moduleUtil = new ModuleFunctionUtil();
		
		for(final ProgramSqlVo programSqlVo : programSqlVos){
			ThreadSleep.sleep(1000);
			
			final File moduleFile = new File(programSqlVo.getPATH());
			if(!moduleFile.exists()){
				logger.warn(String.format("[%s] Module[%s] File Does Not Exists", XrManagerProperties.moduleName, programSqlVo.getMODULE_NM()));
				continue;
			}
			
			if(moduleUtil.moduleValidation(moduleFile)){
				final ModuleLoadVo moduleLoadVo = moduleUtil.xmlToModuleLoadvo(moduleFile);
				if(null == moduleLoadVo){
					continue;
				}
				
				final Point point = new Point(pointX, pointY);
				if(moduleUtil.moduleStart(moduleFile, moduleLoadVo, point)) {
					pointX += 50;
					pointY -= 40;
				}
			}
		}
	}
	
	
}
