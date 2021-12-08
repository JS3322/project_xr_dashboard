
package kr.cleancode.dashboard.manager.web.xr02;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Xr020000s00controller {
	
	private final Logger logger = LogManager.getLogger(Xr020000s00controller.class);
	
	@RequestMapping(value = {"xr020000s00controller.do"})
	public String controller(HttpServletRequest request, HttpServletResponse response) {
		logger.info(String.format("[%s] Ingest Call", XrManagerProperties.moduleName));
		
		return "/xr02/xr020000";
	}
}
