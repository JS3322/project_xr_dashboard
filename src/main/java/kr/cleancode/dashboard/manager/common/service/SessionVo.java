/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.common.service;

import kr.cleancode.dashboard.manager.xr00.service.Xr000000Vo;
import kr.cleancode.dashboard.manager.util.Crypto;

public class SessionVo {

	private String USR_ID = null;
	private String PK_USR_LEVEL_SER = null;
	private String LEVEL_NM = null;
	private String PK_LANG_SER = null;
	private String LANGUAGE_NM = null;
	private String FST_NM = null;
	private String LST_NM = null;
	private String EMAIL = null;
	private String SELECT_LANGUAGE = null;
	private String cryptoKey = null;
	
	public SessionVo(final Xr000000Vo resultVo, final String pLang) {
		this.USR_ID = resultVo.getUSR_ID();
		this.PK_USR_LEVEL_SER = resultVo.getPK_USR_LEVEL_SER();
		this.LEVEL_NM = resultVo.getLEVEL_NM();
		this.PK_LANG_SER = resultVo.getPK_LANG_SER();
		this.LANGUAGE_NM = resultVo.getLANGUAGE_NM();
		this.FST_NM = resultVo.getFST_NM();
		this.LST_NM = resultVo.getLST_NM();
		this.EMAIL = resultVo.getEMAIL();
		this.SELECT_LANGUAGE = pLang;
		this.cryptoKey = Crypto.getSha256(String.format("%s%s", USR_ID, PK_USR_LEVEL_SER));
	}

	public String getUSR_ID() {
		return USR_ID;
	}

	public String getPK_USR_LEVEL_SER() {
		return PK_USR_LEVEL_SER;
	}

	public String getLEVEL_NM() {
		return LEVEL_NM;
	}

	public String getPK_LANG_SER() {
		return PK_LANG_SER;
	}

	public String getLANGUAGE_NM() {
		return LANGUAGE_NM;
	}

	public String getFST_NM() {
		return FST_NM;
	}

	public String getLST_NM() {
		return LST_NM;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public String getSELECT_LANGUAGE() {
		return SELECT_LANGUAGE;
	}

	public String getCryptoKey() {
		return cryptoKey;
	}

}
