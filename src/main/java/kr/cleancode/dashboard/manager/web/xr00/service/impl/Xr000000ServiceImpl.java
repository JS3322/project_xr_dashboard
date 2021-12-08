package kr.cleancode.dashboard.manager.web.xr00.service.impl;

import javax.annotation.Resource;

import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Service;
import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Vo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


@Service("Xr000000Service")
public class Xr000000ServiceImpl implements Xr000000Service {

	@Resource(name = "Xr000000Dao")
	private Xr000000Dao xr000000Dao;


	@Override
	public Xr000000Vo sUsrIdExists(String USR_ID) throws DataAccessException {
		return xr000000Dao.sUsrIdExists(USR_ID);
	}

	@Override
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException {
		return xr000000Dao.sUsrInfo(paramVo);
	}

}
