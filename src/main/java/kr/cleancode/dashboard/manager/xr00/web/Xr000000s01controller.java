/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.xr00.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.cleancode.dashboard.manager.xr00.service.Xr000000Vo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.common.service.SessionVo;
import kr.cleancode.dashboard.manager.xr00.service.Xr000000Service;

@Controller
public class Xr000000s01controller {

	private final Logger logger = LogManager.getLogger(Xr000000s01controller.class);
	
	@Resource(name = "Xr000000Service")
	private Xr000000Service xr000000Service;
	
	@RequestMapping(value = {"xr000000s01controller.do"})
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		this.deleteCookie(request, response);
		
		final String pId = request.getParameter("pId");
		
		final Xr000000Vo paramVo = new Xr000000Vo();
		paramVo.setUSR_ID(pId);
		if(!xr000000Service.sUsrIdExists(paramVo)) {
			request.setAttribute("message", "ID가 존재 하지 않습니다.");
			return "/xr00/xr000000";
		}
		request.setAttribute("pId", pId);
		
		final String pPassword = request.getParameter("pPassword");
		paramVo.setPASSWORD(pPassword);
		
		final Xr000000Vo resultVo = xr000000Service.sUsrInfo(paramVo);
		if(null == resultVo) {
			request.setAttribute("message", "Password가 일치 하지 않습니다.");
			return "/xr00/xr000000";
		}
		
		final String pIdSave = request.getParameter("pIdSave");
		if(pIdSave != null && "on".equals(pIdSave)){
			this.createCookie(request, response);
		}else{
			this.deleteCookie(request, response);
		}
		
		final String pLang = request.getParameter("pLang");
		this.createSession(request, resultVo, pLang);
		
		return "/xr00/xr000000";
	}
	
	/**
	 * 쿠키를 생성한다.
	 * @param request
	 * @param response
	 * @return HttpServletResponse
	 */
	private HttpServletResponse createCookie(HttpServletRequest request, HttpServletResponse response){
		String pId = request.getParameter("pId");
		
		Cookie cookie = new Cookie("XR_Manager_ID", pId);
		cookie.setMaxAge(86400); // 1 Day
		//cookie.setDomain("http://localhost:8090//");
		
		response.addCookie(cookie);
		
		return response;
	}
	
	/**
	 * 쿠키를 제거 한다.
	 * @param request
	 * @param response
	 * @return HttpServletResponse
	 */
	private HttpServletResponse deleteCookie(HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie("XR_Manager_ID", "");
		
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		return response;
	}
	
	private void createSession(HttpServletRequest request, final Xr000000Vo resultVo, String pLang) {
		final SessionVo sessionVo = new SessionVo(resultVo, pLang);
		
		final HttpSession httpSession = request.getSession(false);
		httpSession.setAttribute("SessionVo", sessionVo);
		
		logger.info(String.format("[%s] Create session Licensee: %s, id: %s, level: %s"
												, XrManagerProperties.getValueForJava("name.version")
												, sessionVo.getCryptoKey()
												, sessionVo.getUSR_ID()
												, sessionVo.getPK_USR_LEVEL_SER()
												));
	}
}
