<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>query</title>

<link href="/css/xr02/xr020100.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper">
<div class="search">
	 <div> 
		 <span class="right-letter">Query Code </span>
		<input type="text" name=""/>
	 </div>
		<div> 
		<span class="right-letter">Query Name </span>
		<input type="text" name=""/>
	 </div>
	  <span class="right-letter">Register Date </span>
		<input type="date" name="pDT_ST"/>
		            -
		 <input type="date" name="pDT_LST"/>
		
		  
		   
		
		  <div class="top-button"> <span class="button-letter">Search</span> <span class="button-letter">Clear</span> </div>
  </div>
  <table class="common-table" id="query-table" >
    <thead>
      <tr>
        <th>Query Code</th>
        <th >Query Name</th>
        <th>Register Date</th>
        <th>Modify Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Query1</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Query2</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Query3</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>4</td>
        <td>Query4</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>5</td>
        <td>Query5</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>6</td>
        <td>Query6</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>7</td>
        <td>Query7</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>8</td>
        <td>Query8</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>9</td>
        <td>Query9</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
      <tr>
        <td>10</td>
        <td>Query10</td>
        <td>2021-08-23:12:23:00</td>
        <td>2021-05-21:11:13:00</td>
      </tr>
    </tbody>
  </table>
  <div class="pagination"> <a href="#">&laquo;</a> <a href="#">1</a> <a href="#" class="active">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">&raquo;</a> </div>
  <!--	div 나누기-->
  <div class="register">
    <div class="register-title"> <span class="table-name">Register/Update</span>
      <hr>
    </div>
    <div class="register-query">
      <table>
        <thead>
          <tr>
            <th style="font-weight: normal;">Query Code</th>
            <th style="font-weight: bold;">Query Name</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td ><input id="select-code" type="text" disabled/></td>
            <td ><input id="select-name" type="text" /></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="bottom-button"> <span class="button-letter" id="ingest-table-add"> Add</span> <span class="button-letter" id="ingest-table-erase"> Erase</span> <span class="button-letter" id="ingest-table-modify"> Modify</span> <span class="button-letter" id="ingest-table-delete"> Delete</span> </div>
  </div>
</div>
</body>
<script src="/js/jquery/jquery.min.js"> </script>

<!--  <script src='http:ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'> </script>-->
<script  src="js/xr02/xr020100.js"></script>

</html>