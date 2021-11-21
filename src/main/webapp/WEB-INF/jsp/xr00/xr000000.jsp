<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String pId = request.getAttribute("pId") != null ? (String)request.getAttribute("pId") : "";
String pIdSave = request.getAttribute("pIdSave") != null ? (String)request.getAttribute("pIdSave") : "";

Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(int i = 0 ; i < cookies.length ; i++){
		String KEY = cookies[i].getName();
		if((KEY != null) && KEY.trim().equals("XR_Manager_ID")){
			pId = cookies[i].getValue();
			pIdSave = "on";
			request.setAttribute("pId", pId);
			request.setAttribute("pIdSave", pIdSave);
			break;
		}
	}
}

String message = request.getAttribute("message") != null ? (String)request.getAttribute("message") : "";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CJ 4DPLEX Content Distribution System</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/css/login.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="/css/loginIe8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="/css/loginIe9.css" /><![endif]-->
	</head>
	<body>
		<!-- Part : Header -->
		<header id="header">
			<h1>&nbsp;XR Manager System</h1>
			<p>
				We provide a manager system that handles the system through UI in virtual reality or augmented reality<br />
				This is a prototype, the design will change
			</p>
		</header>

		<!-- Part : Signup Form -->
		<form id="signup-form" method="post" action="#">
			<input type="text" name="pId" id="pId" value="<c:out value="${pId}"/>" placeholder="User ID" />
			<input type="password" name="pPassword" id="pPassword" placeholder="User Password" />
			<input type="submit" value="Login" onclick="fn_login(); return false;" />
			<div class="select-wrapper" style="width: 200px;">
				<select id="pLang" name="pLang">
					<c:forEach var="resultVo" items="${lTBsUsrLangInfo}">
						<option value="<c:out value="${resultVo.PK_LANG_SER}"/>" <c:if test="${resultVo.PK_LANG_SER eq pLang}">selected="selected"</c:if>><c:out value="${resultVo.LANGUAGE_NM}"/></option>
					</c:forEach>
				</select>
			</div>
			<input type="checkbox" id="pIdSave" name="pIdSave"
				<c:if test="${not empty pIdSave}">checked="checked"</c:if>
			/>
			<label for="pIdSave">Save ID</label>
		</form>

		<!-- Part : Footer -->
		<footer id="footer">
			<p>Recommended web browsers: Internet Explorer Version 11, Chrome Version 49</p>
			<ul class="copyright">
				<li>Copyright &copy; 2021 by <a href="https://cleancode.kr/" id="cleancode">Clean Code</a>.
			</ul>
		</footer>

		<!-- Scripts -->
		<!--[if lte IE 8]><script src="/css/ie/respond.min.js"></script><![endif]-->
		<script src="/js/util/sha256.js"></script>
		<script src="/js/xr00/xr000000.js"></script>
		<script src="/js/jquery/jquery.min.js"></script>
		<script type="text/javascript">
			$('#cleancode').click(function(e) {
				e.preventDefault();
				var scr_width = screen.availWidth;
				var scr_height = screen.availHeight;
				var option = "height=" + scr_height + ", width=" + scr_width +  ", 'toolbar=no, menubar=no, location=no, directions=no, resizable=1, scrollbars=yes, status=no, fullscreen=no'";
				window.open(this.href, 'cleancode Homepage', option);
			});
		</script>
		<c:choose>
			<c:when test="${not empty message}">
				<script type="text/javascript">
					alert('<c:out value="${message}"/>');
				</script>
			</c:when>
		</c:choose>
	</body>
</html>