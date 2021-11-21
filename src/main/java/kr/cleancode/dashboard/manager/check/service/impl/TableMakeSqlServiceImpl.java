/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.check.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cleancode.dashboard.manager.check.service.TableMakeSqlService;

@Service("TableMakeSqlService")
public class TableMakeSqlServiceImpl implements TableMakeSqlService {

	@Resource(name = "TableMakeSqlDao")
	private TableMakeSqlDao tableMakeSqlDao;
	
	@Transactional
	@Override
	public void uT_MNG_USR_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_MNG_USR_INFO();
	}

	@Transactional
	@Override
	public void uT_BS_USR_LEVEL_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_BS_USR_LEVEL_INFO();
	}

	@Transactional
	@Override
	public void uT_BS_USR_LANG_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_BS_USR_LANG_INFO();
	}

	@Transactional
	@Override
	public void uT_MNG_USR_CNT_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_MNG_USR_CNT_INFO();
	}

	@Transactional
	@Override
	public void uT_MNG_USR_DTL_HIS_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_MNG_USR_DTL_HIS_INFO();
	}

	@Transactional
	@Override
	public void uT_MNG_USR_PW_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_MNG_USR_PW_INFO();
	}

	@Transactional
	@Override
	public void uT_MNG_USR_DTL_INFO() throws DataAccessException {
		tableMakeSqlDao.uT_MNG_USR_DTL_INFO();
	}

}
