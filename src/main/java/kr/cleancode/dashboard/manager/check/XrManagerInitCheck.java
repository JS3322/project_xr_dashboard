/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import kr.cleancode.dashboard.manager.check.service.CheckSqlService;
import kr.cleancode.dashboard.manager.check.service.CheckSqlVo;
import kr.cleancode.dashboard.manager.check.service.TableMakeSqlService;
import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.util.Crypto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class XrManagerInitCheck {

	private final Logger logger = LogManager.getLogger(XrManagerInitCheck.class);
	
	@Resource(name = "CheckSqlService")
	private CheckSqlService checkSqlService;
	
	@Resource(name = "TableMakeSqlService")
	private TableMakeSqlService tableMakeSqlService;
	
	@PostConstruct
	public void check() {
		databaseFileCheck();
		tableCheck();
		rootAccountCheck();
	}
	
	private void databaseFileCheck() {
		try {
			final CheckSqlVo paramVo = new CheckSqlVo();
			paramVo.setRequest("Hello");
			
			final CheckSqlVo resultVo = checkSqlService.sHelloSql(paramVo);
			logger.info(String.format("Database Hello Message: %s", resultVo.getResponse()));
			
		} catch (DataAccessException e) {
			logger.error(String.format("[%s] Database File Check Exception: %s", XrManagerProperties.getValueForJava("name.version"), e.getMessage()), e);
			System.exit(1);
		}
	}
	
	private void tableCheck() {
		if(!checkSqlService.sTableExists("T_MNG_USR_INFO")) {
			logger.warn(String.format("[%s] Table[T_MNG_USR_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_MNG_USR_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_MNG_USR_INFO", checkSqlService.sTableExists("T_MNG_USR_INFO")));
		}
		
		if(!checkSqlService.sTableExists("T_BS_USR_LEVEL_INFO")) {
			logger.warn(String.format("[%s] Table[T_BS_USR_LEVEL_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_BS_USR_LEVEL_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_BS_USR_LEVEL_INFO", checkSqlService.sTableExists("T_BS_USR_LEVEL_INFO")));
			
			final CheckSqlVo paramVo = new CheckSqlVo();
			paramVo.setLEVEL_NM("Administrator");
			checkSqlService.iTBsUsrLevelInfo(paramVo);
			
			paramVo.setLEVEL_NM("Manager");
			checkSqlService.iTBsUsrLevelInfo(paramVo);
			
			paramVo.setLEVEL_NM("User");
			checkSqlService.iTBsUsrLevelInfo(paramVo);
		}
		
		if(!checkSqlService.sTableExists("T_BS_USR_LANG_INFO")) {
			logger.warn(String.format("[%s] Table[T_BS_USR_LANG_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_BS_USR_LANG_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_BS_USR_LANG_INFO", checkSqlService.sTableExists("T_BS_USR_LANG_INFO")));
			
			
			final CheckSqlVo paramVo = new CheckSqlVo();
			paramVo.setLANGUAGE_NM("한국어");
			checkSqlService.iTBsUsrLangInfo(paramVo);
			
			paramVo.setLANGUAGE_NM("English");
			checkSqlService.iTBsUsrLangInfo(paramVo);
			
			paramVo.setLANGUAGE_NM("日本語");
			checkSqlService.iTBsUsrLangInfo(paramVo);
			
			paramVo.setLANGUAGE_NM("汉语");
			checkSqlService.iTBsUsrLangInfo(paramVo);
		}
		
		if(!checkSqlService.sTableExists("T_MNG_USR_CNT_INFO")) {
			logger.warn(String.format("[%s] Table[T_MNG_USR_CNT_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_MNG_USR_CNT_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_MNG_USR_CNT_INFO", checkSqlService.sTableExists("T_MNG_USR_CNT_INFO")));
		}
		
		if(!checkSqlService.sTableExists("T_MNG_USR_DTL_HIS_INFO")) {
			logger.warn(String.format("[%s] Table[T_MNG_USR_DTL_HIS_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_MNG_USR_DTL_HIS_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_MNG_USR_DTL_HIS_INFO", checkSqlService.sTableExists("T_MNG_USR_DTL_HIS_INFO")));
		}
		
		if(!checkSqlService.sTableExists("T_MNG_USR_PW_INFO")) {
			logger.warn(String.format("[%s] Table[T_MNG_USR_PW_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_MNG_USR_PW_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_MNG_USR_PW_INFO", checkSqlService.sTableExists("T_MNG_USR_PW_INFO")));
		}
		
		if(!checkSqlService.sTableExists("T_MNG_USR_DTL_INFO")) {
			logger.warn(String.format("[%s] Table[T_MNG_USR_DTL_INFO] does not exist.", XrManagerProperties.getValueForJava("name.version")));
			tableMakeSqlService.uT_MNG_USR_DTL_INFO();
			logger.info(String.format("[%s] Table[%s] creation results are: %b", XrManagerProperties.getValueForJava("name.version"), "T_MNG_USR_DTL_INFO", checkSqlService.sTableExists("T_MNG_USR_DTL_INFO")));
		}
	}
	
	private void rootAccountCheck() {
		if(checkSqlService.sRootAccountExists()) {
			return;
		}
		
		final CheckSqlVo paramVo = new CheckSqlVo();
		paramVo.setUSR_ID("root");
		paramVo.setPASSWORD(Crypto.getSha256("root123"));
		
		checkSqlService.makeRootAccount(paramVo);
	}
}
