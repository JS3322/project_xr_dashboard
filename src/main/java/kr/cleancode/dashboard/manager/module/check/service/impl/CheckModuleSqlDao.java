/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.module.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.module.check.service.CheckModuleSqlVo;

@Repository("CheckModuleSqlDao")
@Mapper
public interface CheckModuleSqlDao {

	public CheckModuleSqlVo sHelloSql(CheckModuleSqlVo paramVo) throws DataAccessException;
	public int sTableExists(String tableName) throws DataAccessException;
	public int sColumnExists(CheckModuleSqlVo paramVo) throws DataAccessException;
	
}
