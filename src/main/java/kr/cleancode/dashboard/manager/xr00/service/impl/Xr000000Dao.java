/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.xr00.service.impl;

import java.util.List;

import kr.cleancode.dashboard.manager.xr00.service.Xr000000Vo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("Xr000000Dao")
@Mapper
public interface Xr000000Dao {

	public List<Xr000000Vo> lT_BS_USR_LANG_INFO() throws DataAccessException;
	public int sUsrIdExists(Xr000000Vo paramVo) throws DataAccessException;
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException;
	
}
