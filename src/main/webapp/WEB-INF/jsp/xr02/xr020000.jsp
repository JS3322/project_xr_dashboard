<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Injest</title>
		<meta charset="utf-8" />
		<meta http-equiv="expires" content="0"/> 
		<meta http-equiv="pragma" content="no-cache"/>
		<link href="/css/xr02/xr020000.css" rel="stylesheet" type="text/css">
		<link href="/css/common.css" rel="stylesheet" type="text/css">
		<script src="/js/jquery/jquery.min.js"> </script>
		<script  src="js/xr02/xr020000.js"></script>
	</head>
	
	<body onload="fn_onload(); return false;">
		<form method="post" name="frm" id="frm" enctype="multipart/form-data">
		<div class="search"> 
		        <div> <span class="right-letter">Contents Code </span>
		       <input type="text" name="pPK_CONTENTS_SER"/>
		    </div>    
		      <div> <span class="right-letter">Contents Name </span>
		        <input type="text" name="pCONTENTS_NM"/>      
		       </div>		   
		       <span class="right-letter">Register Date </span>
		          <input type="date" name="pDT_ST"/>
		            -
		            <input type="date" name="pDT_LST"/>
		  <div class="top-button">
			  <span class="button-letter" onclick="fn_search(); return false;">Search</span>
			  <span class="button-letter">Clear</span>
		  </div>
		</div>	
							
				<div class="scroll-table-wrapper" style="width:90%; margin:auto;  max-height: 380px;">
			
		<table class="common-table"  style="width:100%;" id="ingest-table" >
		  <thead>
		    <tr>
		      <th>Contents Code</th>
		      <th >Contents Name</th>
		      <th >Contents Duration</th>
		      <th>Expire Date</th>
		      <th>Register Date</th>
		      <th>Modify Date</th>
		    </tr>
		  </thead>

		  <tbody >
		  <c:forEach var="resultVo" items="${resultList}">
		    <tr onclick="fn_selectRow('${resultVo.PK_CONTENTS_SER}','${resultVo.CONTENTS_NM}','${resultVo.PLY_DURATION}','${resultVo.SRC_FILE_NM}','${resultVo.PST_SRC_FILE_NM}','${resultVo.DRM_SRC_FILE_NM}','${resultVo.DRM_FILE_PATH}'); return false;">
		      <td><c:out value="${resultVo.PK_CONTENTS_SER}"/></td>
		      <td><c:out value="${resultVo.CONTENTS_NM}"/></td>
		      <td><c:out value="${resultVo.PLY_DURATION}"/></td>
		      <td><c:out value="${resultVo.EXPIRE_DT}"/></td>
		      <td><c:out value="${resultVo.REG_DT}"/></td>
		  	  <td><c:out value="${resultVo.REG_ID}"/></td>
		    </tr>
		  </c:forEach> 
		  </tbody>
		</table>
		</div>
		
	<div class="register"> <span class="table-name">Register/Update</span>
		  <hr>
		  <div class="register-contents"> <span id="poster-preview"><img src="/images/image/CLEANCODE_BG_A.png" alt=""> </span>
		   <table class="sub-table" style="width:50%;">
		      <thead>
		        <tr>
		          <th>Contents Code</th>
		          <th style="font-weight: bold">Contents Name</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <td ><input type="text" name="PK_CONTENTS_SER" id="PK_CONTENTS_SER" onclick="showMenu()" readonly="readonly"/></td>
		          <td ><input type="text" name="CONTENTS_NM"  id="CONTENTS_NM"/></td>
		        </tr>
		      </tbody>
		    </table>
		    <table class="sub-table">
		      <thead>
		        <tr>
		          <th></th>
		          <th>File Name</th>
		          <th>Duration</th>
		          <th class="download">Download</th>
		          <th class="upload">Upload</th>
		        </tr>
		      </thead>
		      <tbody>	      
		        <tr>
		          <td style="font-weight: bold; background-color: rgba(0,0,0,0.2); ">Contents File</td>
		          <td ><input type="text" name="CTS_SRC_FILE_NM" id="CTS_SRC_FILE_NM"  style="background-color:#999999" readonly="readonly"/></td>
		          <td ><input type="text" name="PLY_DURATION" id="PLY_DURATION"  style="background-color:#999999" readonly="readonly"/></td>
		          <td class="download"><div class="btn_download">
		              <label for="file-contents" >Download</label>
		              <input type="file" webkitdirectory directory id="file-contents" onchange="fn_download(); return false;"  />
		            </div></td>
		          <td class="upload"><span class="btn_upload">
		            <label for="upload-contents">Upload</label>
		            <input class="upload-name" name="FILE_CTS_LABEL" value="upload file" style="width: 130px;" disabled/>
		            <input type="file" class="upload-hidden"  id="upload-contents" name="FILE_CTS" onchange="fn_fileSelect(FILE_CTS_LABEL, this); return false;">
		            </span></td>
		        </tr>
		        <tr>
		          <td style=" background-color: rgba(0,0,0,0.2); ">Poster File</td>
		          <td id="PST_SRC_FILE_NM"></td>
		          <td>-</td>
		         <td class="download"><div class="btn_download">
		              <label for="file-poster">Download</label>
		              <input type="file" id="file-poster">
		            </div></td>
		          <td class="upload" ><span class="btn_upload">
		            <label for="upload-poster">Upload</label>
		            <input class="upload-name"   name="FILE_PST_LABEL"  value="upload file" style="width: 130px;" disabled/>
		            <input type="file"  class="upload-hidden" id="upload-poster" name="FILE_PST" onchange="fn_fileSelect(FILE_PST_LABEL, this); return false;" >
		            </span></td>
		        </tr>
		        <tr>
		          <td style="background-color: rgba(0,0,0,0.2); ">DRM</td>
		         <td id="DRM_SRC_FILE_NM">c</td>
		          <td>-</td>
		         <td class="download"><div class="btn_download">
		              <label for="upload-drm">Download</label>
		              <input type="file" id="file-drm">
		            </div></td>
		          <td class="upload"><span class="btn_upload">
		            <label for="upload-drm">Upload</label>
		            <input class="upload-name"  name="FILE_DRM_LABEL"  value="upload file" style="width: 130px;" disabled/>
		            <input type="file" class="upload-hidden"  id="upload-drm" name="FILE_DRM" onchange="fn_fileSelect(FILE_DRM_LABEL, this); return false;" >
		            </span></td>
		        </tr>
		      </tbody>
		    </table>
		    <div class="bottom-button">
		    	<span class="button-letter" id="btnAdd" onclick="fn_add(); return false;"> Add</span>
		    	<span class="button-letter caution" id="btnErase"  onclick="fn_erase(); return false;"> Erase</span>
		    	<span class="button-letter" id="btnModify"  onclick="fn_modify(); return false;"> Modify</span>
		    	<span class="button-letter caution" id="btnDelete" onclick="fn_delete(); return false;"> Delete</span>
		    </div>
		  </div>
		</div>
		
		</form>
	</body>
</html>