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
<meta charset="UTF-8">
<title>Login</title>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link href="/css/xr00/xr000000.css" rel="stylesheet" type="text/css">
</head>

<body>
  <div class="login-form">
    <form>
      <h1>Login</h1>
      <div class="form-group">
        <input type="email" name="email" placeholder="ID">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input type="password" name="psw" placeholder="Password">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>      
      <button class="login-btn">Login</button>      
      <a class="reset-psw" href="#">Forgot your password?</a>
<!--      <div class="seperator"><b></b></div>-->
      <!-- Social login buttons -->

    </form>
  </div>
</body>
</html>