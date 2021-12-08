package kr.cleancode.dashboard.manager.web.check.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("TableWebSqlDao")
@Mapper
public interface TableWebSqlDao {

	public int uT_CONTENTS_INFO() throws DataAccessException;
	public int uT_CONTENTS_DRM_INFO() throws DataAccessException;
	public int uT_CONTENTS_FILE_INFO() throws DataAccessException;
	public int uT_CONTENTS_PST_INFO() throws DataAccessException;
	public int uT_CONTENTS_NM_INFO() throws DataAccessException;
	public int uT_EVT_HIS_INFO() throws DataAccessException;
	public int uT_LOGIN_HIS_INFO() throws DataAccessException;
	public int uT_MNG_USR_INFO() throws DataAccessException;
	public int uT_MNG_USR_CNT_INFO() throws DataAccessException;
	public int uT_MNG_USR_DTL_HIS_INFO() throws DataAccessException;
	public int uT_MNG_USR_PW_INFO() throws DataAccessException;
	public int uT_BS_USR_LEVEL_INFO() throws DataAccessException;
	public int uT_MNG_USR_DTL_INFO() throws DataAccessException;
	public int uT_QUERY_INFO() throws DataAccessException;
	public int uT_SPL_INFO() throws DataAccessException;
	public int uT_SLOT_INFO() throws DataAccessException;
	public int uT_SLOT_HIS_INFO() throws DataAccessException;
	public int uT_SLOT_DTL_INFO() throws DataAccessException;
	public int uT_SLOT_DTL_MT_CD_INFO() throws DataAccessException;


}
