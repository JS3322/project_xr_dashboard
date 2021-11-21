/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("TableMakeSqlDao")
@Mapper
public interface TableMakeSqlDao {

	public void uT_MNG_USR_INFO() throws DataAccessException;
	public void uT_BS_USR_LEVEL_INFO() throws DataAccessException;
	public void uT_BS_USR_LANG_INFO() throws DataAccessException;
	public void uT_MNG_USR_CNT_INFO() throws DataAccessException;
	public void uT_MNG_USR_DTL_HIS_INFO() throws DataAccessException;
	public void uT_MNG_USR_PW_INFO() throws DataAccessException;
	public void uT_MNG_USR_DTL_INFO() throws DataAccessException;
	
}
