
package kr.cleancode.dashboard.manager.web;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.ui.JFrameMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class XrGlobalcontroller {
	
	private final Logger logger = LogManager.getLogger(XrGlobalcontroller.class);
	
	@RequestMapping(value = {"test.do"})
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "/test";
	}
	
	@RequestMapping(value = {"XrManagerSetVisible.do"})
	public void setVisible(HttpServletRequest request, HttpServletResponse response) {
		final String screen = request.getParameter("screen");
		JFrameMain.getInstance().setVisible(Boolean.parseBoolean(screen));
		
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(screen);
			printWriter.flush();
		} catch (IOException e) {
			logger.warn(String.format("[%s] Call: %s, Exception: %s", XrManagerProperties.moduleName, request.getRemoteAddr(), e.getMessage()), e);
		} finally {
			printWriter.close();
		}
	}
	
	@RequestMapping(value = {"XrManagerIsVisible.do"})
	public void isVisible(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("IsVisible", JFrameMain.getInstance().isVisible());
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(JFrameMain.getInstance().isVisible());
			printWriter.flush();
		} catch (IOException e) {
			logger.warn(String.format("[%s] Call: %s, Exception: %s", XrManagerProperties.moduleName, request.getRemoteAddr(), e.getMessage()), e);
		} finally {
			printWriter.close();
		}
	}
}
