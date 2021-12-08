<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>SPL</title>
<!--<link href="../../xr001/css/xr001.css" rel="stylesheet" type="text/css">-->
<!--<link href="../../xr001/css/xr001.css" rel="stylesheet" type="text/css">-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<link href="/css/xr02/xr020200.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="modal_2" class="modal">

     <table class="scroll-table" >
		   	<colgroup>
		<col width="8%">
		<col width="22%">
		<col width="30%">
			<col width="20%">
			<col width="20%">
	</colgroup>
        <thead>
          <tr>
			      <th></th>
            <th>order</th>
            <th>Contents</th>
            <th>Validation</th>
            <th>play Time</th>
        
          </tr>
        </thead>
		</table>
	<div class="scroll-table-wrapper">
<table table class="scroll-table" >
<colgroup>
		<col width="8%">
		<col width="22%">
		<col width="30%">
			<col width="20%">
			<col width="20%">
	</colgroup>
		<tbody>
          <tr>
			  <td><input type="checkbox"></td>
            <td>1</td>
            <td>contents1</td>
            <td>Confirmrd</td>
            <td>2:35</td>
             
          </tr>
			<tr>
				<td></td>
            <td></td>
            <td>→ query A</td>
            <td></td>
            <td></td>
                      
          </tr>
			<tr>
				<td></td>
            <td></td>
             <td>→ query B</td>
            <td></td>
            <td></td>
                       
          </tr>
          <tr>
			   <td><input type="checkbox"></td>
            <td>2</td>
            <td>contents2</td>
            <td>Deleted</td>
            <td>5:11</td>
                       
          </tr>

	
        </tbody>
      </table>
		</div>
  <a href="#" rel="modal:close">닫기</a> </div>
	
<div class="wrapper">
<div class="left">
    <div class="left-top-table"><p class="table-name">Injest Table</p>
	<div class="scroll-table-wrapper">
		<table class="scroll-table" id="ingest-table" >
		  		   	<colgroup>
		<col width="10%">
		<col width="30%">
		<col width="30%">
		<col width="30%">

	</colgroup>
        <thead>
          <tr>
			   <th></th>
          	<th>Contents Code</th>
        	<th >Contents Name</th>
            <th>Expire Date</th>
 
          </tr>
        </thead>
		 <tbody>
          <tr>
            <td><input type="checkbox" /></td>
            <td>1</td>
            <td>contents1</td>
            <td>2021-08-23:12:23:00</td>

          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>2</td>
            <td>contents2</td>
            <td>2021-08-23:12:23:00</td>
    
          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>
			   <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>
			   <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>
			   <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>
			   <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>
			   <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>contents3</td>
            <td>2021-08-23:12:23:00</td>
     
          </tr>

			 
        </tbody>
      </table>
		</div>
     
    </div>
    <div class="left-bottom-table" ><p class="table-name">Query Table</p>       	<div class="scroll-table-wrapper">
 <table class="scroll-table" id="query-table" >
		  		   	<colgroup>
		<col width="10%">
		<col width="30%">
		<col width="60%">

	</colgroup>
         <thead>
          <tr>
            <th></th>
            <th>Query Code</th>
            <th>Query Name</th>

          </tr>
        </thead>
	

	
        <tbody>
          <tr>
            <td><input type="checkbox" /></td>
            <td>1</td>
            <td>Query1</td>

          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>2</td>
            <td>Query2</td>
   
          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>3</td>
            <td>Query3</td>
           
          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>4</td>
            <td>Query4</td>
 
          </tr>
			      <tr>
            <td><input type="checkbox" /></td>
            <td>4</td>
            <td>Query4</td>

          </tr>
			      <tr>
            <td><input type="checkbox" /></td>
            <td>4</td>
            <td>Query4</td>

          </tr>
			
        </tbody>
      </table>
    </div>
  </div>
	  </div>

	  
<div class="center">
	<div>
<p>Contents Add</p>
	<span class="button-icon"> <img src="/images/icon/chevron-right.svg" alt=""></span></div>
	<div><p>Query Add</p>
	<span class="button-icon"> <img src="/images/icon/chevron-right.svg" alt=""></span></div>
</div>
<div class="right">

	<div class="right-table"> <p class="table-name">SPL Table</p>
	 		  <div class="table-top">
		  <span class="button-letter">Save</span>  <span class="button-letter">Erase</span> <a href="#modal_2" rel="modal:open" style="text-decoration: none; color: black"><span class="button-letter">Load</span> </a>
 
     </div> 

		  <div class="scroll-table-wrapper">
	   <table class="scroll-table" id="spl-table">
		   	<colgroup>
			<col width="8%">
		<col width="35%">
		<col width="17%">
		<col width="30%">
		<col width="10%">
	</colgroup>
        <thead>
          <tr>
            <th></th>
            <th>Contents</th>
            <th>Validation</th>
            <th>play Time</th>
            <th>Delete</th>
          </tr>
        </thead>
		
		<tbody>
          <tr>
           <td><input type="checkbox"></td>
            <td>contents1</td>
            <td>Confirmrd</td>
            <td>2:35</td>
              <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
			<tr>
            <td></td>
            <td>→ query A</td>
            <td></td>
            <td></td>
                      <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
			<tr>
            <td></td>
             <td>→ query B</td>
            <td></td>
            <td></td>
                        <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
          <tr>
     <td><input type="checkbox"></td>
            <td>contents2</td>
            <td>Deleted</td>
            <td>5:11</td>
                       <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
          <tr>
            <td><input type="checkbox" /></td>
            <td>contents3</td>
            <td>Deleted</td>
            <td>5:11</td>
                        <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
    <tr>
            <td><input type="checkbox" /></td>
            <td>contents3</td>
        <td>Deleted</td>
            <td>5:11</td>
                    <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
			    <tr>
             <td><input type="checkbox" /></td>
            <td>contents3</td>
      <td>Deleted</td>
            <td>5:11</td>
                   <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
		    <tr>
             <td><input type="checkbox" /></td>
            <td>contents3</td>
       <td>Deleted</td>
            <td>5:11</td>
            <td><span class="delete"><img src="/images/icon/trash-fill.svg"></span></td>
          </tr>
        </tbody>
      </table>
		</div>
		
</div>
</div></div>
	
</body>
<!-- 테스트용 제이쿼리 라이브러리 import-->
<script src="/js/jquery/jquery.min.js"> </script>
<script src="/js/jquery/jquery.modal.min.js"></script>
<!--  <script src='http:ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'> </script>-->
</html>