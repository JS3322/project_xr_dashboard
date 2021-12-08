/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.module.check.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.cleancode.dashboard.manager.module.check.service.CheckModuleSqlService;
import kr.cleancode.dashboard.manager.module.check.service.CheckModuleSqlVo;

@Service("CheckModuleSqlService")
public class CheckModuleSqlServiceImpl implements CheckModuleSqlService {

	@Resource(name = "CheckModuleSqlDao")
	private CheckModuleSqlDao checkModuleSqlDao;
	
	@Override
	public CheckModuleSqlVo sHelloSql(CheckModuleSqlVo paramVo) throws DataAccessException{
		return checkModuleSqlDao.sHelloSql(paramVo);
	}

	@Override
	public boolean sTableExists(String tableName) throws DataAccessException {
		return 1 == checkModuleSqlDao.sTableExists(tableName);
	}

	@Override
	public boolean sColumnExists(CheckModuleSqlVo paramVo) throws DataAccessException {
		return 1 == checkModuleSqlDao.sColumnExists(paramVo);
	}

}
