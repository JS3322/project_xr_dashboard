
package kr.cleancode.dashboard.manager.web.xr03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Service;
import kr.cleancode.dashboard.manager.web.xr00.service.Xr000000Vo;

@Controller
public class Xr030000s00controller {
	private final Logger logger = LogManager.getLogger(Xr030000s00controller.class);

	@RequestMapping(value = {"xr030000s00controller.do"})
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info(String.format("Requester Information: Host: %s Address: %s, Port: %d, User: %s"
				, request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort(), request.getRemoteUser()));

		return "/xr03/xr030000";
	}
}
