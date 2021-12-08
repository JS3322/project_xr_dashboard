package kr.cleancode.dashboard.manager.module.check.service;

import org.springframework.dao.DataAccessException;

public interface TableModuleSqlService {

	public void uTMngMfsInfo() throws DataAccessException;
	public void uTMngMiInfo() throws DataAccessException;
	public void uTMngMisInfo() throws DataAccessException;
	public void uTMngBackgroundInfo() throws DataAccessException;
		
}
