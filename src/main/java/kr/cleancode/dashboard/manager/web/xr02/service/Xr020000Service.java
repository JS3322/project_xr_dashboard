package kr.cleancode.dashboard.manager.web.xr02.service;

import java.util.List;

//import java.util.List;

import org.springframework.dao.DataAccessException;

public interface Xr020000Service {

	public List<Xr020000Vo> select(Xr020000Vo paramVo) throws DataAccessException;
	public Xr020000Vo selectRow(String PK_CONTENTS_SER) throws DataAccessException;
	
	public String insert(Xr020000Vo paramVo) throws DataAccessException;
	public int update(Xr020000Vo paramVo) throws DataAccessException;
	public int delete(Xr020000Vo paramVo) throws DataAccessException;
	
}
