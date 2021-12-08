/**
 * Create Time: 2021-11-20
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.xr00;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Service;
import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Vo;

@Controller
public class Xr000000s00controller {
	private final Logger logger = LogManager.getLogger(Xr000000s00controller.class);
	
	@Resource(name = "Xr000000Service")
	private Xr000000Service xr000000Service;
	
	@RequestMapping(value = {"xr000000s00controller.do"})
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info(String.format("Requester Information: Host: %s Address: %s, Port: %d, User: %s"
				, request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort(), request.getRemoteUser()));
		return "index";
	}
}
