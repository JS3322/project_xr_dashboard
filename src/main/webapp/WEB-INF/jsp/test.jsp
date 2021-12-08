<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cleancode</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="cleancode" href="/images/xr00/impact_logo_20200301.png" />
		<script src="/js/jquery/jquery.min.js"></script>
		<script src="/js/test.js"></script>
	</head>
	<body>
		<form name="frm" method="post" action="#">
			<button onclick="fn_statusOn(); return false;">Thread 상태 정보 On</button>
			<button onclick="fn_statusOff(); return false;">Thread 상태 정보 Off</button>
			<button onclick="fn_windowOn(); return false;">화면 켜기</button>
			<button onclick="fn_windowOff(); return false;">화면 끄기</button>
			<input type="text" name="status" readonly="readonly">
		</form>
	</body>
</html>