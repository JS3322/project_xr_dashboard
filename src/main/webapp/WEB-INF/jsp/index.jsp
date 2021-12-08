<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>menu - header</title>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link href="/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="zindex-wrapper" style="display: none">
  <div class="progress-wrapper"  >
    <p style="font-weight: bold">40%</p>
    <p style="font-size: 1.2rem;">contents.mp4</p>
    <div class="progress-bar"> <span style="width:40%"></span> </div>
  </div>
  <div class="complete-wrapper" > <img alt="" src="images/icon/emoji-wink.svg">
    <p>Complete!</p>
  </div>
</div>
<header>
  <div class="container">
    <div id="menu"><img src="./images/icon/list.svg" style="width:100%" alt="Home"></div>
    <div id="home">  
       <a href="./index.html"><img class="logo" src="images/image/impact_logo_20200301.png" alt="Home" style="width:100%"></a>

	  
	  </div>
    <div class="p-image"> <img class="btn-logo" src="images/icon/camera-fill.svg" alt="">
      <input class="file-upload" type="file" accept="image/*"/>
    </div>
    <div class="box">
		
		
		
      <ul>
       
        <li><a href="#">SPL</a>
          <div class="dropdown-content"> <a onClick="splpage();">SPL</a><a onClick="querypage();">Query</a> <a onClick="ingestpage();">Ingest</a> </div>
        </li>
        <li><a href="#">Code</a>
          <div class="dropdown-content"><a onClick="codepage();">Code</a> </div>
        </li>
        <li><a href="#">Management</a>
          <div class="dropdown-content"> <a onClick="lhistorypage();">Login History</a> <a onClick="ehistorypage();">Event History</a><a onClick="uregisterpage();">User Register</a> </div>
        </li>
      </ul>
    </div>
	  
	  
	  
    <div id="login-info">
		<a ><img src="images/icon/bookmark-plus-fill.svg" style="height:20px;vertical-align: middle"></a>
      <a onClick="pwchangepage()"><span>JS(root)&nbsp;&nbsp;</span></a>
		<span class="toggle">
		 <img src="images/icon/lightbulb.svg" alt=""><label class="switch">
        <input type="checkbox" onClick="toggle_bg(this)">
        <span class="slider round"></span> </label></span>
		<a href="pages/xr011/xr011.html"> <span class="button-letter">logout</span></a>
		
		
	  </div>
  </div>
</header>
<menu> 
<span id="close-menu"> <img src="./images/icon/x-square-fill.svg" alt="close"></span>
  <div class="container">
    <div class="box">
      <ul>
        <li><a href="./index.html">Main</a></li>
		   <li> <a onClick="#">Book Mark</a></li>
		   <li><a onClick="pwchangepage()">Change Password</a> </li>
        <li><a onClick="splpage();">SPL</a></li>
        <li><a onClick="querypage();">Query</a></li>
        <li><a onClick="ingestpage();">Ingest</a></li>
        <li><a onClick="codepage();">Code</a></li>
        <li><a onClick="lhistorypage();">Login History</a></li>
        <li><a onClick="ehistorypage();">Event History</a></li>
        <li><a onClick="uregisterpage();">User Register / Update</a></li>
      </ul>
      <ul>
        <li><a href="#">Logout</a> </li>
      </ul>
    </div>
  </div>
</menu>
<div id="mainwrapper">
  <div id ="module-activation"> <span id="page-name">Main</span>
    <div class="active" id="icvr-act"> ICVR</div>
    <div class="error" id="ics-act"> ICS </div>
    <div  id="contrabass-act"> ConTraBasS</div>
    <div id="syrup-act"> SyRUp </div>
  </div>
  <div id="main">
    <embed src="/xr010000s00controller.do" width="100%" height="800px" type="text/html" />
  </div>
</div>
</body>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'> </script>

<script  src="/js/index.js"></script>

</html>