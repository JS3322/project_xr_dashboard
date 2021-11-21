/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.xr00.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.cleancode.dashboard.manager.xr00.service.Xr000000Service;
import kr.cleancode.dashboard.manager.xr00.service.Xr000000Vo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service("Xr000000Service")
public class Xr000000ServiceImpl implements Xr000000Service {

	@Resource(name = "Xr000000Dao")
	private Xr000000Dao xr000000Dao;
	
	@Override
	public List<Xr000000Vo> lT_BS_USR_LANG_INFO() throws DataAccessException {
		return xr000000Dao.lT_BS_USR_LANG_INFO();
	}

	@Override
	public boolean sUsrIdExists(Xr000000Vo paramVo) throws DataAccessException {
		return 1 == xr000000Dao.sUsrIdExists(paramVo);
	}

	@Override
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException {
		return xr000000Dao.sUsrInfo(paramVo);
	}

}
