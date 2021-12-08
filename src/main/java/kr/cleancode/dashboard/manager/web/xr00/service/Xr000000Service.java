package kr.cleancode.dashboard.manager.web.xr00.service;

//import java.util.List;

import org.springframework.dao.DataAccessException;

public interface Xr000000Service {

	public Xr000000Vo sUsrIdExists(String USR_ID) throws DataAccessException;
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException;
	
}
