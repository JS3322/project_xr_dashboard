/**
 * Create Time: 2021-10-27
 * Made by: JS
 */
package kr.cleancode.dashboard.manager.global.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlVo;

@Repository("CheckGlobalSqlDao")
@Mapper
public interface CheckGlobalSqlDao {

	public CheckGlobalSqlVo sHelloSql(CheckGlobalSqlVo paramVo) throws DataAccessException;

}
