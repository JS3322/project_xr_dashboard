
package kr.cleancode.dashboard.manager.web.xr02;

import kr.cleancode.dashboard.manager.common.XrManagerProperties;
import kr.cleancode.dashboard.manager.web.common.service.FileUploadVo;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Service;
import kr.cleancode.dashboard.manager.web.xr02.service.Xr020000Vo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Controller
public class Xr020000i00controller {
	private final Logger logger = LogManager.getLogger(Xr020000i00controller.class);
	
	@Resource(name = "Xr020000Service")
	private Xr020000Service xr020000Service;
	
	@RequestMapping(value = {"xr020000i00controller.do"})
	public String controller(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info(String.format("[%s] Ingest Insert Call", XrManagerProperties.moduleName));
		
		// 등록
		final String CONTENTS_NM = request.getParameter("CONTENTS_NM");
		final Map<String, FileUploadVo> fileUploadVos = this.fileUploads(request, "");
		final Xr020000Vo insertVo = new Xr020000Vo();
		
		insertVo.setCONTENTS_NM(CONTENTS_NM);

		final Iterator<String> iterator = fileUploadVos.keySet().iterator();
	
		while (iterator.hasNext()) {
		
			final String attributeName = iterator.next();
			final FileUploadVo fileUploadVo = fileUploadVos.get(attributeName);
		
			
			if("FILE_CTS".equals(attributeName)) {
				insertVo.setCTS_SRC_FILE_NM(fileUploadVo.getSrcFileName());
				insertVo.setCTS_FILE_PATH(fileUploadVo.getFilePath());
				
				

				insertVo.setPLY_DURATION(String.format("%s", "00:00:00"));
				insertVo.setREG_ID("js");

		
			}else if("FILE_PST".equals(attributeName)) {
				insertVo.setPST_SRC_FILE_NM(fileUploadVo.getSrcFileName());
				insertVo.setPST_FILE_PATH(fileUploadVo.getFilePath());
			
			}else {
				// FILE_DRM
				insertVo.setDRM_SRC_FILE_NM(fileUploadVo.getSrcFileName());
				insertVo.setDRM_FILE_PATH(fileUploadVo.getFilePath());
				insertVo.setEXPIRE_DT(String.format("%d", 20211231));
			}
		}
		xr020000Service.insert(insertVo);
		// 조회
		final String pPK_CONTENTS_SER = request.getParameter("pPK_CONTENTS_SER");
		final String pCONTENTS_NM = request.getParameter("pCONTENTS_NM");
		final String pDT_ST = request.getParameter("pDT_ST");
		final String pDT_LST = request.getParameter("pDT_LST");
		
		request.setAttribute("pPK_CONTENTS_SER", pPK_CONTENTS_SER);
		request.setAttribute("pCONTENTS_NM", pCONTENTS_NM);
		request.setAttribute("pDT_ST", pDT_ST);
		request.setAttribute("pDT_LST", pDT_LST);
		
		final Xr020000Vo paramVo = new Xr020000Vo();
	
		paramVo.setPK_CONTENTS_SER(pPK_CONTENTS_SER.isEmpty() ? null : pPK_CONTENTS_SER);
		paramVo.setCONTENTS_NM(pCONTENTS_NM.isEmpty() ? null : pCONTENTS_NM);
		paramVo.setDT_ST(pDT_ST.isEmpty() ? null : pDT_ST);
		paramVo.setDT_LST(pDT_LST.isEmpty() ? null : pDT_LST);

		return "/xr02/xr020000";
	}
	
		private Map<String, FileUploadVo> fileUploads(HttpServletRequest request, String fileNamePrefix) throws IllegalStateException, IOException{
		
		final Map<String, FileUploadVo> resultMap = new HashMap<String, FileUploadVo>();
		final File saveFolder = new File(XrManagerProperties.getValueForJava("path.root"), XrManagerProperties.getValueForJava("name.folder.injest"));
		
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		final Iterator<Entry<String, MultipartFile>> iterator = files.entrySet().iterator();
		
		while (iterator.hasNext()) {
			final Entry<String, MultipartFile> entry = iterator.next();
			final MultipartFile multipartFile = entry.getValue();
			
			if (!"".equals(multipartFile.getOriginalFilename())) {
				final File trgtFile = new File(saveFolder.getAbsolutePath(), String.format("injest_%s_%s", multipartFile.getName(), DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd-HHmmssSSS")));
				
				final FileUploadVo fileUploadVo = new FileUploadVo();
				fileUploadVo.setSrcFileName(multipartFile.getOriginalFilename());
				fileUploadVo.setFilePath(trgtFile.getName());
				
				multipartFile.transferTo(trgtFile);
				
				resultMap.put(multipartFile.getName(), fileUploadVo);
				logger.info(String.format("[%s] Injest Upload File: %s -> Copy File: %s", XrManagerProperties.moduleName, multipartFile.getOriginalFilename(), trgtFile.getName()));
			}
		}
		
		return 0 == resultMap.size() ? null : resultMap;
	}
}
