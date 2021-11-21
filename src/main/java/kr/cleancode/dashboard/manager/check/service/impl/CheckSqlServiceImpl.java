/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check.service.impl;

import javax.annotation.Resource;

import kr.cleancode.dashboard.manager.check.service.CheckSqlService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cleancode.dashboard.manager.check.service.CheckSqlVo;

@Service("CheckSqlService")
public class CheckSqlServiceImpl implements CheckSqlService {

	@Resource(name = "CheckSqlDao")
	private CheckSqlDao checkSqlDao;
	
	@Override
	public CheckSqlVo sHelloSql(CheckSqlVo paramVo) throws DataAccessException{
		return checkSqlDao.sHelloSql(paramVo);
	}

	@Override
	public boolean sTableExists(String tableNAme) throws DataAccessException{
		return 1 == checkSqlDao.sTableExists(tableNAme);
	}

	@Override
	public boolean sColumnExists(CheckSqlVo paramVo) throws DataAccessException{
		return 1 == checkSqlDao.sColumnExists(paramVo);
	}

	@Transactional
	@Override
	public String iTBsUsrLevelInfo(CheckSqlVo paramVo) throws DataAccessException {
		checkSqlDao.iTBsUsrLevelInfo(paramVo);
		return paramVo.getPK_USR_LEVEL_SER();
	}

	@Transactional
	@Override
	public String iTBsUsrLangInfo(CheckSqlVo paramVo) throws DataAccessException {
		checkSqlDao.iTBsUsrLangInfo(paramVo);
		return paramVo.getPK_LANG_SER();
	}
	
	@Override
	public boolean sRootAccountExists() throws DataAccessException {
		return 1 == checkSqlDao.sRootAccountExists();
	}
	
	@Transactional
	@Override
	public void makeRootAccount(CheckSqlVo paramVo) throws DataAccessException {
		paramVo.setREG_ID(paramVo.getUSR_ID());
		checkSqlDao.iT_MNG_USR_INFO(paramVo);
		checkSqlDao.iT_MNG_USR_DTL_HIS_INFO(paramVo);
		checkSqlDao.iT_MNG_USR_PW_INFO(paramVo);
		
		paramVo.setPK_USR_LEVEL_SER("PULS0000000000000000000000000001");
		paramVo.setPK_LANG_SER("PLS00000000000000000000000000001");
		paramVo.setFST_NM("Kim");
		paramVo.setLST_NM("JS");
		paramVo.setEMAIL("js@cleancode.kr");
		paramVo.setTEL("");
		paramVo.setNOTE("Administrator Account");
		
		checkSqlDao.iT_MNG_USR_DTL_INFO(paramVo);
	}
}
