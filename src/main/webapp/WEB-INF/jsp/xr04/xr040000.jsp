<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Login History</title>
<link href="/css/xr04/xr040000.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">

		
		    <div class="search">
		 <div class="common_form">
				 
				 
				 <table>
              <colgroup>
                <col width="30%"/>
                <col width="auto"/>
              </colgroup>
              <tbody>
                <tr>
                  <th><span>ID </span></th>
					<td><input type="text"  /></td>
					 </tr>
			
				  <tr>
                  <th><span>Login Date  </span></th>
					<td>  <input type="date" id="login-date-start" />
        -
        <input type="date" id="login-date-end"/>
					   
					  </td>
					 </tr>
				   </tbody>
			 </table>
		</div>
		 <div class="top-button"> <span class="button-letter">Search</span> <span class="button-letter">Clear</span> </div>
      
    </div>
    <table id="login-table" class="common-table">
      <thead>
        <tr>
          <th>No</th>
          <th >ID</th>
   
          <th>Login Date</th>
          <th>Login Success</th>
			 <th>IP Address</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>Y</td>
 <td>192.333.222.111</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
         <tr>
          <td>2</td>
          <td>Root</td>
          <td>2021-08-23:12:23:00</td>
          <td>N</td>
  <td>192.333.222.111</td>
        </tr>
       

	

      </tbody>
    </table>
  
	</div>
<div class="pagination">
  <a href="#">&laquo;</a>
  <a href="#">1</a>
  <a href="#" class="active">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">&raquo;</a>
</div>
</body>
<script src="/js/jquery/jquery.min.js"> </script>
</html>