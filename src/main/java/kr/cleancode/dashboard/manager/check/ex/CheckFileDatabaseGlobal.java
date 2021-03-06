package kr.cleancode.dashboard.manager.check.ex;

import javax.annotation.Resource;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
//import org.sqlite.date.DateFormatUtils;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlService;
import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlVo;

@Controller("CheckFileDatabaseGlobal")
public class CheckFileDatabaseGlobal {

	private final Logger logger = LogManager.getLogger(CheckFileDatabaseGlobal.class);

	@Resource(name = "CheckGlobalSqlService")
	private CheckGlobalSqlService checkGlobalSqlService;

	public void check() {
		if (!this.checkFileDatabase()) {
			System.exit(1);
		}
		if (!this.checkTables()) {
			System.exit(1);
		}
		if (!this.checkColumns()) {
			System.exit(1);
		}
		if (!this.checkDatasBasic()) {
			System.exit(1);
		}
	}

	private final boolean checkFileDatabase() {
		try {
			final CheckGlobalSqlVo paramVo = new CheckGlobalSqlVo();
			paramVo.setRequest(String.format("Hello Global Database, %s",
					DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss.SSS")));

			final CheckGlobalSqlVo resultVo = checkGlobalSqlService.sHelloSql(paramVo);
			logger.info(
					String.format("[%s] Database Message: %s", XrManagerProperties.moduleName, resultVo.getResponse()));

			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database file check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}

	private final boolean checkTables() {
		String nameTable = null;
		try {

			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database table check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}

	/**
	 * Version 1.0????????? ???????????? ????????? ????????? ????????? ????????? Database??? ????????? ????????? ????????? ????????????.
	 * 
	 * @return
	 */
	private final boolean checkColumns() {
		try {

			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database column check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}

	private final boolean checkDatasBasic() {
		try {

			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database datas basic check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}
}
