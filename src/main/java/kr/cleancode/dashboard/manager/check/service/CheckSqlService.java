/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check.service;

import org.springframework.dao.DataAccessException;

public interface CheckSqlService {

	public CheckSqlVo sHelloSql(CheckSqlVo paramVo) throws DataAccessException;
	public boolean sTableExists(String tableNAme) throws DataAccessException;
	public boolean sColumnExists(CheckSqlVo paramVo) throws DataAccessException;
	public String iTBsUsrLevelInfo(CheckSqlVo paramVo) throws DataAccessException;
	public String iTBsUsrLangInfo(CheckSqlVo paramVo) throws DataAccessException;
	public boolean sRootAccountExists() throws DataAccessException;
	public void makeRootAccount(CheckSqlVo paramVo) throws DataAccessException;
	
}
