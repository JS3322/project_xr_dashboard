
package kr.cleancode.dashboard.manager.module.background.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.module.background.service.BackgroundSqlVo;

@Repository("BackgroundSqlDao")
@Mapper
public interface BackgroundSqlDao {

	public void iTMngBackgroundInfo(BackgroundSqlVo paramVo) throws DataAccessException;
	public BackgroundSqlVo sTMngBackgroundInfo() throws DataAccessException;
	public int dTMngBackgroundInfo(String PK_BACKGROUND_SER) throws DataAccessException;

}
