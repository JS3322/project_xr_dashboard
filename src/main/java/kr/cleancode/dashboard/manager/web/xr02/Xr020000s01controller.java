
package kr.cleancode.dashboard.manager.web.xr02;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Service;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Vo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Xr020000s01controller {
	private final Logger logger = LogManager.getLogger(Xr020000s01controller.class);
	
	@Resource(name = "Xr020000Service")
	private Xr020000Service xr020000Service;
	
	@RequestMapping(value = {"xr020000s01controller.do"})
	public String controller(HttpServletRequest request, HttpServletResponse response) {
		logger.info(String.format("[%s] Ingest Search Call", XrManagerProperties.moduleName));
		
		// 조회
		final String pPK_CONTENTS_SER = request.getParameter("pPK_CONTENTS_SER");
		final String pCONTENTS_NM = request.getParameter("pCONTENTS_NM");
		final String pDT_ST = request.getParameter("pDT_ST");
		final String pDT_LST = request.getParameter("pDT_LST");
		
		request.setAttribute("pPK_CONTENTS_SER", pPK_CONTENTS_SER);
		request.setAttribute("pCONTENTS_NM", pCONTENTS_NM);
		request.setAttribute("pDT_ST", pDT_ST);
		request.setAttribute("pDT_LST", pDT_LST);
		
		logger.info(String.format("%s %s %s %s", pPK_CONTENTS_SER, pCONTENTS_NM, pDT_ST, pDT_LST));
		
		final Xr020000Vo paramVo = new Xr020000Vo();
		
		paramVo.setPK_CONTENTS_SER(pPK_CONTENTS_SER.isEmpty() ? null : pPK_CONTENTS_SER);
		paramVo.setCONTENTS_NM(pCONTENTS_NM.isEmpty() ? null : pCONTENTS_NM);
		paramVo.setDT_ST(pDT_ST.isEmpty() ? null : pDT_ST);
		paramVo.setDT_LST(pDT_LST.isEmpty() ? null : pDT_LST);
		
		final List<Xr020000Vo> resultList = xr020000Service.select(paramVo);
		
		request.setAttribute("resultList", resultList);
		
		return "/xr02/xr020000";
	}
}
