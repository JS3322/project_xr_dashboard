package kr.cleancode.dashboard.manager.module.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("TableModuleSqlDao")
@Mapper
public interface TableModuleSqlDao {

	public void uTMngMfsInfo() throws DataAccessException;
	public void uTMngMiInfo() throws DataAccessException;
	public void uTMngMisInfo() throws DataAccessException;
	public void uTMngBackgroundInfo() throws DataAccessException;
	
}
