
package kr.cleancode.dashboard.manager.module.coordinates.service.impl;

import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("CoordinatesSqlDao")
@Mapper
public interface CoordinatesSqlDao {

	public void iTMngMfsInfo(CoordinatesSqlVo paramVo) throws DataAccessException;
	public void iTMngMisInfo(CoordinatesSqlVo paramVo) throws DataAccessException;
	public CoordinatesSqlVo sViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException;
	public int uTMngMfsInfo(CoordinatesSqlVo paramVo) throws DataAccessException;
	public int uTMngMisInfo(CoordinatesSqlVo paramVo) throws DataAccessException;
	
}
