package kr.cleancode.dashboard.manager.web.check.service.impl;

import kr.cleancode.dashboard.manager.web.check.service.DataBasicWebSqlService;
import kr.cleancode.dashboard.manager.web.check.service.DataBasicWebSqlVo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("DataBasicWebSqlService")
public class DataBasicWebSqlServiceImpl implements DataBasicWebSqlService {

	@Resource(name = "DataBasicWebSqlDao")
	private DataBasicWebSqlDao dataBasicWebSqlDao;
	
	@Transactional
	@Override
	public String iTBsUsrLevelInfo(DataBasicWebSqlVo paramVo) throws DataAccessException {
		dataBasicWebSqlDao.iTBsUsrLevelInfo(paramVo);
		return paramVo.getPK_USR_LEVEL_SER();
	}

	@Transactional
	@Override
	public String iTBsUsrLangInfo(DataBasicWebSqlVo paramVo) throws DataAccessException {
		dataBasicWebSqlDao.iTBsUsrLangInfo(paramVo);
		return paramVo.getPK_LANG_SER();
	}

	@Override
	public boolean sRootAccountExists() throws DataAccessException {
		return 1 == dataBasicWebSqlDao.sRootAccountExists();
	}

	@Transactional
	@Override
	public void makeRootAccount(DataBasicWebSqlVo paramVo) throws DataAccessException {
		paramVo.setREG_ID(paramVo.getUSR_ID());
		dataBasicWebSqlDao.iT_MNG_USR_INFO(paramVo);
		dataBasicWebSqlDao.iT_MNG_USR_DTL_HIS_INFO(paramVo);
		dataBasicWebSqlDao.iT_MNG_USR_PW_INFO(paramVo);
		
		paramVo.setPK_USR_LEVEL_SER("PULS0000000000000000000000000001");
		paramVo.setPK_LANG_SER("PLS00000000000000000000000000001");
		paramVo.setFST_NM("Kim");
		paramVo.setLST_NM("JS");
		paramVo.setEMAIL("js@cleancode.kr");
		paramVo.setTEL("");
		paramVo.setNOTE("Administrator Account");
		
		dataBasicWebSqlDao.iT_MNG_USR_DTL_INFO(paramVo);
	}

}
