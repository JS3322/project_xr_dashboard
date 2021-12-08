
package kr.cleancode.dashboard.manager.module.coordinates.service.impl;

import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlService;
import kr.cleancode.dashboard.manager.module.coordinates.service.CoordinatesSqlVo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("CoordinatesSqlService")
public class CoordinatesSqlServiceImpl implements CoordinatesSqlService {

	@Resource(name = "CoordinatesSqlDao")
	private CoordinatesSqlDao coordinatesSqlDao;

	@Transactional
	@Override
	public void iViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException {
		final CoordinatesSqlVo paramVo00 = new CoordinatesSqlVo();
		paramVo00.setPK_SW_DIV_SER(paramVo.getPK_SW_DIV_SER());
		paramVo00.setMODULE_NM(paramVo.getMODULE_NM());
		paramVo00.setAXIS_X(paramVo.getAXIS_X());
		paramVo00.setAXIS_Y(paramVo.getAXIS_Y());
		paramVo00.setRTG_WIDTH(paramVo.getRTG_WIDTH());
		paramVo00.setRTG_HEIGHT(paramVo.getRTG_HEIGHT());
		paramVo00.setMAXIMUM(paramVo.getMAXIMUM());
		paramVo00.setMINIMUM(paramVo.getMINIMUM());
		
		coordinatesSqlDao.iTMngMfsInfo(paramVo00);
		final String PK_MFS_SER = paramVo00.getPK_MFS_SER();
		
		if(null == PK_MFS_SER){
			return;
		}
		
		final CoordinatesSqlVo paramVo01 = new CoordinatesSqlVo();
		paramVo01.setPK_MFS_SER(PK_MFS_SER);
		paramVo01.setICON_AXIS_X(paramVo.getICON_AXIS_X());
		paramVo01.setICON_AXIS_Y(paramVo.getICON_AXIS_Y());
		
		coordinatesSqlDao.iTMngMisInfo(paramVo01);
	}

	@Override
	public CoordinatesSqlVo sViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException {
		return coordinatesSqlDao.sViewHistory(paramVo);
	}

	@Transactional
	@Override
	public void uViewHistory(CoordinatesSqlVo paramVo) throws DataAccessException {
		final CoordinatesSqlVo paramVo00 = new CoordinatesSqlVo();
		paramVo00.setPK_MFS_SER(paramVo.getPK_MFS_SER());
		paramVo00.setAXIS_X(paramVo.getAXIS_X());
		paramVo00.setAXIS_Y(paramVo.getAXIS_Y());
		paramVo00.setRTG_WIDTH(paramVo.getRTG_WIDTH());
		paramVo00.setRTG_HEIGHT(paramVo.getRTG_HEIGHT());
		paramVo00.setMAXIMUM(paramVo.getMAXIMUM());
		paramVo00.setMINIMUM(paramVo.getMINIMUM());
		
		if(0 == coordinatesSqlDao.uTMngMfsInfo(paramVo00)){
			return;
		}
		
		final CoordinatesSqlVo paramVo01 = new CoordinatesSqlVo();
		paramVo01.setPK_MIS_SER(paramVo.getPK_MIS_SER());
		paramVo01.setICON_AXIS_X(paramVo.getICON_AXIS_X());
		paramVo01.setICON_AXIS_Y(paramVo.getICON_AXIS_Y());
		
		coordinatesSqlDao.uTMngMisInfo(paramVo01);
	}
	
}
