<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>menu - header</title>
<link href="/css/xr01/xr010000.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>

	
	
	<div id="modal_1" class="modal">
  <p>motion code 정보</p>
  <a href="#" rel="modal:close">닫기</a> </div>
	
	<div id="modal_2" class="modal">

     <table class="scroll-table" id="spl-table">
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
	
	
<div class="mainwrapper"> 
  
  <!--	  <embed src="../xr003/xr003.html" width="100%" height="700px"/>-->
  <section class="video-section">
    <div class="poster"> <img src="images/image/CLEANCODE_BG_A.png"  alt="contents"/> </div>
    <div class="playinfo"> 
      <!--
        <div class="playLineHolder">
          <div class="playLine"></div>
        </div>
-->
      <div class="progress-bar"> <span style="width:40%"></span></div>
      <div class="playinfo-text">
        <div class="contents_name">ContentsName.mp4</div>
        <div class="time"><span id="now_time">00:00 </span>/<span id="total"> 00:00</span></div>
      </div>
      <div class="playicon"> <img src="images/icon/play-fill.svg"> 
        <!--			   <img src="./Assets/icon/stop.svg"> --> 
      </div>
    </div>
  </section>
  <div id="tabs">
    <input id="tab1" type="radio" name="tab" checked="checked" style="display: none" />
    <input id="tab2" type="radio" name="tab" style="display: none"/>
    <label for="tab1"> HMD </label>
    <label for="tab2"> Contents </label>
    <div class="tab1_content">`
      <div id="content">
        <div id="hmdcontents">
			
          <div class="block_header"><span>HMD</span><span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span><span class="toggle"><img src="images/icon/justify.svg" style="height: 22px">
            <label class="switch">
              <input type="checkbox" onClick="toggle_hmd(this)">
              <span class="slider round"></span> </label>
            </span></div>
          <div id="hmd_array">
			  <div id="hmdcontents_block">
            <div class="hmd">  <a href="#modal_1" rel="modal:open" style="text-decoration: none; color: black"> <span class="hmd_num">101</span> </a>
				<span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span>
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" />38.9℃ </div>
				  
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" />50% </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" />contents <span> 00:00:01</span></div>
                <div class="staterow" > XR </div>
              </div>
            </div>
           
            <div class="hmd"> <a href="#modal_1" rel="modal:open" style="text-decoration: none; color: black"><span class="hmd_num">102</span></a>
             <span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span> <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" />38.9℃ </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" />50% </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" />contents <span> 00:00:01</span> </div>
                <div class="staterow" > SCREEN </div>
              </div>
            </div>
            <div class="hmd">  <a href="#modal_1" rel="modal:open" style="text-decoration: none; color: black"><span class="hmd_num">103</span></a>
             <span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span> <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" />contents <span> 00:00:01</span> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd">  <a href="#modal_1" rel="modal:open" style="text-decoration: none; color: black"><span class="hmd_num">104</span></a>
             <span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span> <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
             <span class="btn_align"><span class="button-icon"> <img src="images/icon/align-middle.svg"> </span> </span> <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
            <div class="hmd"> 103
              <hr/>
              <div class="hmdstate">
                <div class="staterow" > <img src="images/icon/thermometer-high.svg" alt="thermometer" /> </div>
                <div class="staterow" > <img src="images/icon/battery-half.svg" alt="battery" /> </div>
                <div class="staterow" > <img src="images/icon/play-fill.svg" alt="play" /> </div>
                <div class="staterow" > - </div>
              </div>
            </div>
          </div>
        </div>
			
			<div id="hmdcontents_table" style="display:none">
			
			
			 <table class="common-table" >
        <thead>
          <tr>
            <th style="width:5%">HMD</th>
            <th>Contents</th>
            <th>Screen Type</th>
            <th>Contents</th>
			  <th>Time Code</th>
			  <th>Temperature</th>
			    <th>Align</th>
			  <th>Battery</th>
          </tr>
        </thead>
        <tbody>
          <tr class="row-contents">
            <td>101</td>
            <td>a</td>
			  <td>b</td>
			  <td>c</td>
			  <td>d</td>
            <td>e</td>
            <td>f</td>
			     <td>g</td>
          </tr>
          
        </tbody>
      </table>
			</div>
      </div>
		  </div>
    </div>
    <div class="tab2_content">
      <div class="block_header"><span>Contents</span> <span class="button-letter"> Clear</span>  <a href="#modal_2" rel="modal:open" style="text-decoration: none; color: black"><span class="button-letter"> Load</span></a> </div>
      <table class="common-table" >
        <thead>
          <tr>
            <th style="width:15%">Order</th>
            <th>Contents</th>
            <th>Validation</th>
            <th>Play Time</th>
          </tr>
        </thead>
        <tbody>
          <tr class="row-contents">
            <td>1</td>
            <td>video1</td>
            <td>Confirmed</td>
            <td>3:57</td>
          </tr>
          <tr>
            <td></td>
            <td><img src="images/icon/arrow-right.svg"> Query1</td>
            <td></td>
            <td></td>
          </tr>
          <tr class="row-contents">
            <td>2</td>
            <td>video2</td>
            <td>Deleted</td>
            <td>10:11</td>
          </tr>
          <tr class="row-contents">
            <td>3</td>
            <td>video1</td>
            <td>Confirmed</td>
            <td>3:57</td>
          </tr>
          <tr>
            <td></td>
            <td><img src="images/icon/arrow-right.svg"> Query1</td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td></td>
            <td><img src="images/icon/arrow-right.svg"> Query1</td>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>

<!-- 테스트용 제이쿼리 라이브러리 import-->
<script src="/js/jquery/jquery.min.js"> </script>
<script src="/js/jquery/jquery.modal.min.js"></script>
<script  src="/js/xr01/xr010000.js"></script>
</html>