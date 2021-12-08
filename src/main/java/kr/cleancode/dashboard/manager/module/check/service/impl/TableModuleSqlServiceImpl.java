package kr.cleancode.dashboard.manager.module.check.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cleancode.dashboard.manager.module.check.service.TableModuleSqlService;

@Service("TableModuleSqlService")
public class TableModuleSqlServiceImpl implements TableModuleSqlService {

	@Resource(name = "TableModuleSqlDao")
	private TableModuleSqlDao tableModuleSqlDao;

	@Transactional
	@Override
	public void uTMngMfsInfo() throws DataAccessException {
		tableModuleSqlDao.uTMngMfsInfo();
	}

	@Transactional
	@Override
	public void uTMngMiInfo() throws DataAccessException {
		tableModuleSqlDao.uTMngMiInfo();
	}

	@Transactional
	@Override
	public void uTMngMisInfo() throws DataAccessException {
		tableModuleSqlDao.uTMngMisInfo();
	}

	@Transactional
	@Override
	public void uTMngBackgroundInfo() throws DataAccessException {
		tableModuleSqlDao.uTMngBackgroundInfo();
	}

}
