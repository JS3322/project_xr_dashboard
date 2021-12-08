package kr.cleancode.dashboard.manager.web.xr02.service.impl;

import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Service;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Vo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("Xr020000Service")
public class Xr020000ServiceImpl implements Xr020000Service {
	
	@Resource(name = "Xr020000Dao")
	private Xr020000Dao xr020000Dao;

	@Override
	public List<Xr020000Vo> select(Xr020000Vo paramVo) throws DataAccessException {
		return xr020000Dao.select(paramVo);
	}

	@Override
	public Xr020000Vo selectRow(String PK_CONTENTS_SER) throws DataAccessException {
		final Xr020000Vo resultVo = new Xr020000Vo();
		final Xr020000Vo contentsVo = xr020000Dao.sT_CONTENTS_FILE_INFO(PK_CONTENTS_SER);

		if(null != contentsVo) {
			resultVo.setCTS_SRC_FILE_NM(contentsVo.getCTS_SRC_FILE_NM());
			resultVo.setCTS_FILE_PATH(contentsVo.getCTS_FILE_PATH());
			resultVo.setPLY_DURATION(contentsVo.getPLY_DURATION());

		}
		System.out.println(contentsVo);

		final Xr020000Vo pstVo = xr020000Dao.sT_CONTENTS_PST_INFO(PK_CONTENTS_SER);
		if(null != pstVo) {
			resultVo.setPST_SRC_FILE_NM(pstVo.getPST_SRC_FILE_NM());
			resultVo.setPST_FILE_PATH(pstVo.getPST_FILE_PATH());
		}

		final Xr020000Vo drmVo = xr020000Dao.sT_CONTENTS_DRM_INFO(PK_CONTENTS_SER);
		if(null != drmVo) {
			resultVo.setDRM_SRC_FILE_NM(drmVo.getDRM_SRC_FILE_NM());
			resultVo.setDRM_FILE_PATH(drmVo.getDRM_FILE_PATH());
			resultVo.setEXPIRE_DT(drmVo.getEXPIRE_DT());
		}

		final Xr020000Vo nameVo = xr020000Dao.sT_CONTENTS_NM_INFO(PK_CONTENTS_SER);
		if(null != nameVo) {
			resultVo.setCONTENTS_NM(nameVo.getCONTENTS_NM());
		}

		return resultVo;
	}
	
	@Transactional
	@Override
	public String insert(Xr020000Vo paramVo) throws DataAccessException {
		final String PK_CONTENTS_SER = this.iT_CONTENTS_INFO(paramVo);
		if(null == PK_CONTENTS_SER) {
			return null;
		}
		
		if(null != paramVo.getCTS_SRC_FILE_NM() && null != paramVo.getCTS_FILE_PATH()) {
			this.iT_CONTENTS_FILE_INFO(paramVo);
		}
		
		if(null != paramVo.getPST_SRC_FILE_NM() && null != paramVo.getPST_FILE_PATH()) {
			this.iT_CONTENTS_PST_INFO(paramVo);
		}

		if(null != paramVo.getDRM_SRC_FILE_NM() && null != paramVo.getDRM_FILE_PATH()) {
			this.iT_CONTENTS_DRM_INFO(paramVo);
		}
		
		this.iT_CONTENTS_NM_INFO(paramVo);
		
		return PK_CONTENTS_SER;
	}

	@Transactional
	@Override
	public int update(Xr020000Vo paramVo) throws DataAccessException {
		if(null != paramVo.getCTS_SRC_FILE_NM() && null != paramVo.getCTS_FILE_PATH()) {
			xr020000Dao.uT_CONTENTS_FILE_INFO(paramVo);

		}
		if(null != paramVo.getCTS_SRC_FILE_NM() && null != paramVo.getCTS_FILE_PATH()) {
			xr020000Dao.uT_CONTENTS_PST_INFO(paramVo);
		}
		
		if(null != paramVo.getPST_SRC_FILE_NM() && null != paramVo.getCTS_FILE_PATH()) {
			xr020000Dao.uT_CONTENTS_PST_INFO(paramVo);
		}

		if(null != paramVo.getDRM_SRC_FILE_NM() && null != paramVo.getDRM_FILE_PATH()) {
			xr020000Dao.uT_CONTENTS_DRM_INFO(paramVo);
		}
		
		if(null != paramVo.getCONTENTS_NM()) {
			xr020000Dao.uT_CONTENTS_NM_INFO(paramVo);
		}
		
		return 0;
	}

	@Transactional
	@Override
	public int delete(Xr020000Vo paramVo) throws DataAccessException {
		return xr020000Dao.dT_CONTENTS_INFO(paramVo);
	}

	public String iT_CONTENTS_INFO(Xr020000Vo paramVo) throws DataAccessException {
		xr020000Dao.iT_CONTENTS_INFO(paramVo);
		return paramVo.getPK_CONTENTS_SER();
	}
	
	public String iT_CONTENTS_FILE_INFO(Xr020000Vo paramVo) throws DataAccessException {
		xr020000Dao.iT_CONTENTS_FILE_INFO(paramVo);
		return paramVo.getPK_CONTENTS_FILE_SER();
	}
	
	public String iT_CONTENTS_PST_INFO(Xr020000Vo paramVo) throws DataAccessException {
		xr020000Dao.iT_CONTENTS_PST_INFO(paramVo);
		return paramVo.getPK_CONTENTS_PST_SER();
	}
	
	public String iT_CONTENTS_DRM_INFO(Xr020000Vo paramVo) throws DataAccessException {
		xr020000Dao.iT_CONTENTS_DRM_INFO(paramVo);
		return paramVo.getPK_CONTENTS_DRM_SER();
	}
	
	public String iT_CONTENTS_NM_INFO(Xr020000Vo paramVo) throws DataAccessException {
		xr020000Dao.iT_CONTENTS_NM_INFO(paramVo);
		return paramVo.getPK_CONTENTS_NM_SER();
	}
}
