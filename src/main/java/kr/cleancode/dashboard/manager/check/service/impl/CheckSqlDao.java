/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.check.service.CheckSqlVo;

@Repository("CheckSqlDao")
@Mapper
public interface CheckSqlDao {

	public CheckSqlVo sHelloSql(CheckSqlVo paramVo) throws DataAccessException;
	public int sTableExists(String tableNAme) throws DataAccessException;
	public int sColumnExists(CheckSqlVo paramVo) throws DataAccessException;
	public void iTBsUsrLevelInfo(CheckSqlVo paramVo) throws DataAccessException;
	public void iTBsUsrLangInfo(CheckSqlVo paramVo) throws DataAccessException;
	public int sRootAccountExists() throws DataAccessException;
	public void iT_MNG_USR_INFO(CheckSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_DTL_HIS_INFO(CheckSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_PW_INFO(CheckSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_DTL_INFO(CheckSqlVo paramVo) throws DataAccessException;
	
}
