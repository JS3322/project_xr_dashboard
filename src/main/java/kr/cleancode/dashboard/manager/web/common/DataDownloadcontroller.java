package kr.cleancode.dashboard.manager.web.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.cleancode.dashboard.manager.common.XrManagerProperties;


@Controller
public class DataDownloadcontroller {
	
	private final Logger logger = LogManager.getLogger(DataDownloadcontroller.class);


	@RequestMapping(value = {"download.do"})
	public void downloadFile (HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info(String.format("[%s] download Call", XrManagerProperties.moduleName));
		
		String FILE_SRC_NM =request.getParameter("CTS_SRC_FILE_NM");
		String FILE_PATH = request.getParameter("CTS_FILE_PATH");
		logger.info(String.format("[%s] download File Path", FILE_PATH));
		logger.info(String.format("[%s] download File NM", FILE_SRC_NM));

		
		final File saveFolder = new File(XrManagerProperties.getValueForJava("path.root"));
		
		if(null == request.getParameter("CTS_SRC_FILE_NM") || null == request.getParameter("CTS_FILE_PATH")){
			return;
		}
		


		File uFile = new File(saveFolder, FILE_PATH);
		
		int fSize = (int) uFile.length();
		
		if (fSize > 0) {
			BufferedInputStream bufferedInputStream = null;
			try {
				bufferedInputStream = new BufferedInputStream(new FileInputStream(uFile));
				String mimetype = "text/html; charset=UTF-8";
	 
				response.setBufferSize(fSize);
				response.setContentType(mimetype);
				
				String userCharset = request.getCharacterEncoding();
				if("UTF-8".equalsIgnoreCase(userCharset)){
					FILE_SRC_NM = URLEncoder.encode(FILE_SRC_NM, "UTF-8");
				}else{
					FILE_SRC_NM = new String(FILE_SRC_NM.getBytes(userCharset), "ISO-8859-1");
				}
				response.setHeader("Content-Disposition", "attachment; filename=\""	+ FILE_SRC_NM + "\"");
				response.setHeader("Content-Transfer-Encoding", "binary");
				response.setCharacterEncoding("utf-8");
				response.setContentLength(fSize);
	 
				FileCopyUtils.copy(bufferedInputStream, response.getOutputStream());
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (Exception e) {
			} finally {
				if(bufferedInputStream != null){
					bufferedInputStream.close();
				}
				try {
					response.getOutputStream().flush();
					response.getOutputStream().close();
				} catch (Exception e2) {
				}
			}
		}
	}

}
