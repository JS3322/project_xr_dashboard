package kr.cleancode.dashboard.manager.web.check.service.impl;

import kr.cleancode.dashboard.manager.web.check.service.DataBasicWebSqlVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("DataBasicWebSqlDao")
@Mapper
public interface DataBasicWebSqlDao {

	public void iTBsUsrLevelInfo(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public void iTBsUsrLangInfo(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public int sRootAccountExists() throws DataAccessException;
	public void iT_MNG_USR_INFO(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_DTL_HIS_INFO(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_PW_INFO(DataBasicWebSqlVo paramVo) throws DataAccessException;
	public void iT_MNG_USR_DTL_INFO(DataBasicWebSqlVo paramVo) throws DataAccessException;
	
}
