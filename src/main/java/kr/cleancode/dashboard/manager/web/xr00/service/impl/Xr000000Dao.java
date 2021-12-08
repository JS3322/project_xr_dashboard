package kr.cleancode.dashboard.manager.web.xr00.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Vo;

@Repository("Xr000000Dao")
@Mapper
public interface Xr000000Dao {

	public Xr000000Vo sUsrIdExists(String USR_ID) throws DataAccessException;
	public Xr000000Vo sUsrInfo(Xr000000Vo paramVo) throws DataAccessException;
	
}
