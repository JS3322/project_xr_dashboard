
package kr.cleancode.dashboard.manager.module.background.service;

import org.springframework.dao.DataAccessException;

public interface BackgroundSqlService {

	public String iTMngBackgroundInfo(BackgroundSqlVo paramVo) throws DataAccessException;
	public BackgroundSqlVo sTMngBackgroundInfo() throws DataAccessException;
	public int dTMngBackgroundInfo(String PK_BACKGROUND_SER) throws DataAccessException;
	
}
