/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.module.check.service;

import org.springframework.dao.DataAccessException;

public interface CheckModuleSqlService {

	public CheckModuleSqlVo sHelloSql(CheckModuleSqlVo paramVo) throws DataAccessException;
	public boolean sTableExists(String tableName) throws DataAccessException;
	public boolean sColumnExists(CheckModuleSqlVo paramVo) throws DataAccessException;
	
}
