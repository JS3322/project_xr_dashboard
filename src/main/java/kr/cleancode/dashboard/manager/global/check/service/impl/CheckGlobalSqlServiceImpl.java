/**
 * Made by: JS
 */
package kr.cleancode.dashboard.manager.global.check.service.impl;

import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlService;
import kr.cleancode.dashboard.manager.global.check.service.CheckGlobalSqlVo;

@Service("CheckGlobalSqlService")
public class CheckGlobalSqlServiceImpl implements CheckGlobalSqlService {

	@Resource(name = "CheckGlobalSqlDao")
	private CheckGlobalSqlDao checkGlobalSqlDao;

	@Override
	public CheckGlobalSqlVo sHelloSql(CheckGlobalSqlVo paramVo) throws DataAccessException {
		return checkGlobalSqlDao.sHelloSql(paramVo);
	}

}
