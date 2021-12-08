/**
 * Made by: JS
 */
package kr.cleancode.dashboard.manager.global.check.service.impl;

import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlService;
import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlVo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CheckGlobalSqlService")
public class CheckGlobalSqlServiceImpl implements CheckGlobalSqlService {

	@Resource(name = "CheckGlobalSqlDao")
	private CheckGlobalSqlDao checkGlobalSqlDao;
	
	@Override
	public CheckGlobalSqlVo sHelloSql(CheckGlobalSqlVo paramVo) throws DataAccessException{
		return checkGlobalSqlDao.sHelloSql(paramVo);
	}

}
