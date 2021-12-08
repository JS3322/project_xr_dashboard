/**
 * Create Time: 2021-10-27
 * Made by: JS
 */
package kr.cleancode.dashboard.manager.global.check.service;

import org.springframework.dao.DataAccessException;

public interface CheckGlobalSqlService {

	public CheckGlobalSqlVo sHelloSql(CheckGlobalSqlVo paramVo) throws DataAccessException;
	
}
