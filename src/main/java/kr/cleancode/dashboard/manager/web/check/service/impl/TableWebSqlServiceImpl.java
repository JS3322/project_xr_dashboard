package kr.cleancode.dashboard.manager.web.check.service.impl;

import kr.cleancode.dashboard.manager.web.check.service.TableWebSqlService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("TableWebSqlService")
public class TableWebSqlServiceImpl implements TableWebSqlService {

	@Resource(name = "TableWebSqlDao")
	private kr.cleancode.dashboard.manager.web.check.service.impl.TableWebSqlDao tableWebSqlDao;

	@Transactional
	@Override
	public void uT_CONTENTS_INFO() throws DataAccessException {
		tableWebSqlDao.uT_CONTENTS_INFO();

	}
	@Transactional
	@Override
	public void uT_CONTENTS_DRM_INFO() throws DataAccessException {
		tableWebSqlDao.uT_CONTENTS_DRM_INFO();
	}
	@Transactional
	@Override
	public void uT_CONTENTS_FILE_INFO() throws DataAccessException {
		tableWebSqlDao.uT_CONTENTS_FILE_INFO();
	}
	@Transactional
	@Override
	public void uT_CONTENTS_PST_INFO() throws DataAccessException {
		tableWebSqlDao.uT_CONTENTS_PST_INFO();
		
	}
	@Transactional
	@Override
	public void uT_CONTENTS_NM_INFO() throws DataAccessException {
		tableWebSqlDao.uT_CONTENTS_NM_INFO();
		
	}
	@Transactional
	@Override
	public void uT_EVT_HIS_INFO() throws DataAccessException {
		tableWebSqlDao.uT_EVT_HIS_INFO();
		
	}
	@Transactional
	@Override
	public void uT_LOGIN_HIS_INFO() throws DataAccessException {
		tableWebSqlDao.uT_LOGIN_HIS_INFO();
		
	}
	@Transactional
	@Override
	public void uT_MNG_USR_INFO() throws DataAccessException {
		tableWebSqlDao.uT_MNG_USR_INFO();
		
	}
	@Transactional
	@Override
	public void uT_MNG_USR_CNT_INFO() throws DataAccessException {
		tableWebSqlDao.uT_MNG_USR_CNT_INFO();
		
	}
	@Transactional
	@Override
	public void uT_MNG_USR_DTL_HIS_INFO() throws DataAccessException {
		tableWebSqlDao.uT_MNG_USR_DTL_HIS_INFO();
		
	}
	@Transactional
	@Override
	public void uT_MNG_USR_PW_INFO() throws DataAccessException {
		tableWebSqlDao.uT_MNG_USR_PW_INFO();
		
	}
	@Transactional
	@Override
	public void uT_BS_USR_LEVEL_INFO() throws DataAccessException {
		tableWebSqlDao.uT_BS_USR_LEVEL_INFO();
		
	}
	@Transactional
	@Override
	public void uT_MNG_USR_DTL_INFO() throws DataAccessException {
		tableWebSqlDao.uT_MNG_USR_DTL_INFO();
		
	}
	@Transactional
	@Override
	public void uT_QUERY_INFO() throws DataAccessException {
		tableWebSqlDao.uT_QUERY_INFO();
		
	}
	@Transactional
	@Override
	public void uT_SPL_INFO() throws DataAccessException {
		tableWebSqlDao.uT_SPL_INFO();
		
	}
	@Transactional
	@Override
	public void uT_SLOT_INFO() throws DataAccessException {
		tableWebSqlDao.uT_SLOT_INFO();
		
	}
	@Transactional
	@Override
	public void uT_SLOT_HIS_INFO() throws DataAccessException {
		tableWebSqlDao.uT_SLOT_HIS_INFO();
		
	}
	@Transactional
	@Override
	public void uT_SLOT_DTL_INFO() throws DataAccessException {
		tableWebSqlDao.uT_SLOT_DTL_INFO();
		
	}
	@Transactional
	@Override
	public void uT_SLOT_DTL_MT_CD_INFO() throws DataAccessException {
		tableWebSqlDao.uT_SLOT_DTL_MT_CD_INFO();
		
	}
	


	
	
}
