
package kr.cleancode.dashboard.manager.module.coordinates.service;

import org.springframework.dao.DataAccessException;

public interface CoordinatesSqlService {

	public void iViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException;
	public CoordinatesSqlVo sViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException;
	public void uViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException;
	
}
