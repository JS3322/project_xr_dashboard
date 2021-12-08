/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.check.service.impl;

import kr.cleancode.dashboard.manager.web.check.service.CheckWebSqlService;
import kr.cleancode.dashboard.manager.web.check.service.CheckWebSqlVo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CheckWebSqlService")
public class CheckWebSqlServiceImpl implements CheckWebSqlService {

	@Resource(name = "CheckWebSqlDao")
	private kr.cleancode.dashboard.manager.web.check.service.impl.CheckWebSqlDao checkWebSqlDao;
	
	@Override
	public CheckWebSqlVo sHelloSql(CheckWebSqlVo paramVo) throws DataAccessException {
		return checkWebSqlDao.sHelloSql(paramVo);
	}

	@Override
	public boolean sTableExists(String tableName) throws DataAccessException {
		return 1 == checkWebSqlDao.sTableExists(tableName);
	}

	@Override
	public boolean sColumnExists(CheckWebSqlVo paramVo) throws DataAccessException {
		return 1 == checkWebSqlDao.sColumnExists(paramVo);
	}

}
