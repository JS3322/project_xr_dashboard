package kr.cleancode.dashboard.manager.check.ex;

import javax.annotation.Resource;
// import org.sqlite.date.DateFormatUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.util.Crypto;
import kr.cleancode.dashboard.manager.web.check.service.CheckWebSqlService;
import kr.cleancode.dashboard.manager.web.check.service.CheckWebSqlVo;
import kr.cleancode.dashboard.manager.web.check.service.DataBasicWebSqlService;
import kr.cleancode.dashboard.manager.web.check.service.DataBasicWebSqlVo;
import kr.cleancode.dashboard.manager.web.check.service.TableWebSqlService;

@Controller("CheckFileDatabaseWeb")
public class CheckFileDatabaseWeb {

	private final Logger logger = LogManager.getLogger(CheckFileDatabaseWeb.class);

	@Resource(name = "CheckWebSqlService")
	private CheckWebSqlService checkWebSqlService;

	@Resource(name = "TableWebSqlService")
	private TableWebSqlService tableWebSqlService;

	@Resource(name = "DataBasicWebSqlService")
	private DataBasicWebSqlService dataBasicWebSqlService;

	/**
	 * checkFileDatabase()
	 * checkTables()
	 * checkColumns()
	 * checkDatasBasic()
	 * 를 실행하고 한개라도 실패시 프로그램이 종료 된다.
	 */
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
			final CheckWebSqlVo paramVo = new CheckWebSqlVo();
			paramVo.setRequest(String.format("Hello Web Database, %s",
					DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd hh:mm:ss.SSS")));

			final CheckWebSqlVo resultVo = checkWebSqlService.sHelloSql(paramVo);
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

			nameTable = "T_CONTENTS_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_CONTENTS_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_CONTENTS_DRM_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_CONTENTS_DRM_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_CONTENTS_FILE_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_CONTENTS_FILE_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_CONTENTS_PST_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_CONTENTS_PST_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_CONTENTS_NM_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_CONTENTS_NM_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_EVT_HIS_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_EVT_HIS_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_LOGIN_HIS_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_LOGIN_HIS_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_MNG_USR_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_MNG_USR_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_MNG_USR_CNT_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_MNG_USR_CNT_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_MNG_USR_DTL_HIS_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_MNG_USR_DTL_HIS_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_MNG_USR_PW_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_MNG_USR_PW_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}

			nameTable = "T_BS_USR_LEVEL_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_BS_USR_LEVEL_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));

				final DataBasicWebSqlVo paramVo = new DataBasicWebSqlVo();
				paramVo.setLEVEL_NM("Administrator");
				dataBasicWebSqlService.iTBsUsrLevelInfo(paramVo);

				paramVo.setLEVEL_NM("Manager");
				dataBasicWebSqlService.iTBsUsrLevelInfo(paramVo);

				paramVo.setLEVEL_NM("User");
				dataBasicWebSqlService.iTBsUsrLevelInfo(paramVo);
			}
			nameTable = "T_MNG_USR_DTL_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_MNG_USR_DTL_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_QUERY_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_QUERY_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_SPL_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_SPL_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_SLOT_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_SLOT_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_SLOT_HIS_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_SLOT_HIS_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_SLOT_DTL_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_SLOT_DTL_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			nameTable = "T_SLOT_DTL_MT_CD_INFO";
			if (!checkWebSqlService.sTableExists(nameTable)) {
				logger.warn(String.format("[%s] Table[%s] does not exist.", XrManagerProperties.moduleName, nameTable));
				tableWebSqlService.uT_SLOT_DTL_MT_CD_INFO();
				logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.moduleName,
						nameTable, checkWebSqlService.sTableExists(nameTable)));
			}
			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database table check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}

	/**
	 * Version 1.0에서는 사용하지 않지만 추후에 버전을 변경시 Database의 수정이 필요할 경우에 사용한다.
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
			if (dataBasicWebSqlService.sRootAccountExists()) {
				return true;
			}

			logger.warn(String.format("[%s] Root Account does not exist.", XrManagerProperties.moduleName));

			final DataBasicWebSqlVo paramVo = new DataBasicWebSqlVo();
			paramVo.setUSR_ID("root");
			paramVo.setPASSWORD(Crypto.getSha256("root123"));

			dataBasicWebSqlService.makeRootAccount(paramVo);
			logger.info(String.format("[%s] Root Account results are: %b", XrManagerProperties.moduleName,
					dataBasicWebSqlService.sRootAccountExists()));

			return true;
		} catch (DataAccessException e) {
			logger.warn(String.format("[%s] Database datas basic check Exception: %s", XrManagerProperties.moduleName,
					e.getMessage()), e);
			return false;
		}
	}
}
