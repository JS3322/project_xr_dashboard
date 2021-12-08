package kr.cleancode.dashboard.manager.web.check.service;

import org.springframework.dao.DataAccessException;

public interface DataBasicWebSqlService {

	public String iTBsUsrLevelInfo(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public String iTBsUsrLangInfo(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public boolean sRootAccountExists() throws DataAccessException;
	public void makeRootAccount(DataBasicWebSqlVo paramVo) throws DataAccessException;
	
}
