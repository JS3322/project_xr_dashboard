/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.xr00.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface Xr000000Service {

	public List<Xr000000Vo> lT_BS_USR_LANG_INFO() throws DataAccessException;
	public boolean sUsrIdExists(Xr000000Vo paramVo) throws DataAccessException;
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException;
	
}
