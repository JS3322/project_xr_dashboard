
package kr.cleancode.dashboard.manager.module.program.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;

@Repository("ProgramSqlDao")
@Mapper
public interface ProgramSqlDao {

	public void iTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public ProgramSqlVo sTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public List<ProgramSqlVo> lTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public int uTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	
}
