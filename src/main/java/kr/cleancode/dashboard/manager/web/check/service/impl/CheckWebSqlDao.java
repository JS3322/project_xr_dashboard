/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.check.service.impl;

import kr.cleancode.dashboard.manager.web.check.service.CheckWebSqlVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("CheckWebSqlDao")
@Mapper
public interface CheckWebSqlDao {

	public CheckWebSqlVo sHelloSql(CheckWebSqlVo paramVo) throws DataAccessException;
	public int sTableExists(String tableName) throws DataAccessException;
	public int sColumnExists(CheckWebSqlVo paramVo) throws DataAccessException;
	
}
