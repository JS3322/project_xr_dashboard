
package kr.cleancode.dashboard.manager.module.program.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ProgramSqlService {
	
	public String iTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public ProgramSqlVo sTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public List<ProgramSqlVo> lTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	public int uTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException;
	
}
