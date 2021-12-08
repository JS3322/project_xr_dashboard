
package kr.cleancode.dashboard.manager.module.background.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cleancode.dashboard.manager.module.background.service.BackgroundSqlService;
import kr.cleancode.dashboard.manager.module.background.service.BackgroundSqlVo;

@Service("BackgroundSqlService")
public class BackgroundSqlServiceImpl implements BackgroundSqlService {

	@Resource(name = "BackgroundSqlDao")
	private BackgroundSqlDao backgroundSqlDao;
	
	@Transactional
	@Override
	public String iTMngBackgroundInfo(BackgroundSqlVo paramVo) throws DataAccessException {
		backgroundSqlDao.iTMngBackgroundInfo(paramVo);
		return paramVo.getPK_BACKGROUND_SER();
	}

	@Override
	public BackgroundSqlVo sTMngBackgroundInfo() throws DataAccessException {
		return backgroundSqlDao.sTMngBackgroundInfo();
	}

	@Transactional
	@Override
	public int dTMngBackgroundInfo(String PK_BACKGROUND_SER) throws DataAccessException {
		return backgroundSqlDao.dTMngBackgroundInfo(PK_BACKGROUND_SER);
	}

}
