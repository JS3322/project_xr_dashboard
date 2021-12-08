package kr.cleancode.dashboard.manager.web.xr02.service.impl;

import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Vo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Xr020000Dao")
@Mapper
public interface Xr020000Dao {

	public List<Xr020000Vo> select(Xr020000Vo paramVo) throws DataAccessException;
	
	public void iT_CONTENTS_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void iT_CONTENTS_FILE_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void iT_CONTENTS_PST_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void iT_CONTENTS_DRM_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void iT_CONTENTS_NM_INFO(Xr020000Vo paramVo) throws DataAccessException;
	
	public int dT_CONTENTS_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public int dT_CONTENTS_FILE_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public int dT_CONTENTS_PST_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public int dT_CONTENTS_DRM_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public int dT_CONTENTS_NM_INFO(Xr020000Vo paramVo) throws DataAccessException;
	
	public Xr020000Vo sT_CONTENTS_FILE_INFO(String PK_CONTENTS_SER) throws DataAccessException;
	public Xr020000Vo sT_CONTENTS_PST_INFO(String PK_CONTENTS_SER) throws DataAccessException;
	public Xr020000Vo sT_CONTENTS_DRM_INFO(String PK_CONTENTS_SER) throws DataAccessException;
	public Xr020000Vo sT_CONTENTS_NM_INFO(String PK_CONTENTS_SER) throws DataAccessException;

	public void uT_CONTENTS_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void uT_CONTENTS_FILE_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void uT_CONTENTS_PST_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void uT_CONTENTS_DRM_INFO(Xr020000Vo paramVo) throws DataAccessException;
	public void uT_CONTENTS_NM_INFO(Xr020000Vo paramVo) throws DataAccessException;
}
