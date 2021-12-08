/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.check.service;

import org.springframework.dao.DataAccessException;

public interface CheckWebSqlService {

	public CheckWebSqlVo sHelloSql(CheckWebSqlVo paramVo) throws DataAccessException;
	public boolean sTableExists(String tableName) throws DataAccessException;
	public boolean sColumnExists(CheckWebSqlVo paramVo) throws DataAccessException;
	
}
