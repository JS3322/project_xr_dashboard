/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.web.xr04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Xr040000s00controller {
	private final Logger logger = LogManager.getLogger(Xr040000s00controller.class);

	
	@RequestMapping(value = {"xr040000s00controller.do"})
	public String controller(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info(String.format("Requester Information: Host: %s Address: %s, Port: %d, User: %s"
				, request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort(), request.getRemoteUser()));

		return "/xr04/xr040000";
	}
}
