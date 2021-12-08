package kr.cleancode.dashboard.manager.check.ex;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.module.check.service.CheckModuleSqlService;
import kr.cleancode.dashboard.manager.module.check.service.CheckModuleSqlVo;
import kr.cleancode.dashboard.manager.module.check.service.TableModuleSqlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.sqlite.date.DateFormatUtils;

import javax.annotation.Resource;

@Controller("CheckFileDatabaseModule")
public class CheckFileDatabaseModule {

	private final Logger logger = LogManager.getLogger(CheckFileDatabaseModule.class);
	
	@Resource(name = "CheckModuleSqlService")
	private CheckModuleSqlService checkModuleSqlService;
	
	@Resource(name = "TableModuleSqlService")
	private TableModuleSqlService tableModuleSqlService;
	
	public void check() {
		if(!this.checkFileDatabase()) {
			System.exit(1);
		}
		if(!this.checkTables()) {
			System.exit(1);
		}
		if(!this.checkColumns()) {
			System.exit(1);
		}
		if(!this.checkDatasBasic()) {
			System.exit(1);
		}
	}
	
	private final boolean checkFileDatabase() {
		try {
			final CheckModuleSqlVo paramVo = new CheckModuleSqlVo();
			paramVo.setRequest(String.format("Hello Module Database, %s", DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss.SSS")));
			
			final CheckModuleSqlVo resultVo = checkModuleSqlService.sHelloSql(paramVo);
			logger.info(String.format("[%s] Database Message: %s", XrManagerProperties.moduleName, resultVo.getResponse()));
			
			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database file check Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
			return false;
		}
	}
	
	private final boolean checkTables() {
		String nameTable = null;
		try {
			nameTable = "T_MNG_MFS_INFO";
			if(!checkModuleSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableModuleSqlService.uTMngMfsInfo();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName, nameTable, checkModuleSqlService.sTableExists(nameTable)));
			}
			
			nameTable = "T_MNG_MIS_INFO";
			if(!checkModuleSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableModuleSqlService.uTMngMisInfo();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName, nameTable, checkModuleSqlService.sTableExists(nameTable)));
			}
			
			nameTable = "T_MNG_MI_INFO";
			if(!checkModuleSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableModuleSqlService.uTMngMiInfo();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName, nameTable, checkModuleSqlService.sTableExists(nameTable)));
			}
			
			nameTable = "T_MNG_BACKGROUND_INFO";
			if(!checkModuleSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableModuleSqlService.uTMngBackgroundInfo();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName, nameTable, checkModuleSqlService.sTableExists(nameTable)));
			}
			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database table check Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
			return false;
		}
	}
	
	/**
	 * Version 1.0에서는 사용하지 않지만 추후에 버전을 변경시 Database의 수정이 필요할 경우에 사용한다.
	 * @return
	 */
	private final boolean checkColumns() {
		try {
			
			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database column check Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
			return false;
		}
	}
	
	private final boolean checkDatasBasic() {
		try {
			
			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database datas basic check Exception: %s", XrManagerProperties.moduleName, e.getMessage()), e);
			return false;
		}
	}
}
