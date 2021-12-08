/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.xr02;

import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Service;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Vo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Xr020000s02controller {
	private final Logger logger = LogManager.getLogger(Xr020000s02controller.class);
	
	@Resource(name = "Xr020000Service")
	private Xr020000Service xr020000Service;
	
	@RequestMapping(value = {"xr020000s02controller.do"})
	public String controller(HttpServletRequest request, HttpServletResponse response) {
		logger.info(String.format("[%s] ", Xr020000s02controller.class.getName()));
		
		// 조회
		final String PK_CONTENTS_SER = request.getParameter("PK_CONTENTS_SER");
		final Xr020000Vo resultVo = xr020000Service.selectRow(PK_CONTENTS_SER);
		
		if(null == resultVo) {
			return null;
		}
			
		request.setAttribute("resultVo", resultVo);		
	
		return "/xr02/xr020000";
	}
}
