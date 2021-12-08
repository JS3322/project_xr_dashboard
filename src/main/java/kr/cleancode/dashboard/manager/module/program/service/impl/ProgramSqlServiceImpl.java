
package kr.cleancode.dashboard.manager.module.program.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlService;
import kr.cleancode.dashboard.manager.module.program.service.ProgramSqlVo;

@Service("ProgramSqlService")
public class ProgramSqlServiceImpl implements ProgramSqlService {

	@Resource(name = "ProgramSqlDao")
	private ProgramSqlDao programSqlDao;
	
	@Transactional
	@Override
	public String iTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException {
		programSqlDao.iTMngMiInfo(paramVo);
		return paramVo.getPK_MI_SER();
	}

	@Override
	public ProgramSqlVo sTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException {
		return programSqlDao.sTMngMiInfo(paramVo);
	}

	@Override
	public List<ProgramSqlVo> lTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException {
		return programSqlDao.lTMngMiInfo(paramVo);
	}

	@Transactional
	@Override
	public int uTMngMiInfo(ProgramSqlVo paramVo) throws DataAccessException {
		return programSqlDao.uTMngMiInfo(paramVo);
	}

}
