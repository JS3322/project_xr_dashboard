<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>SPL</title>

<link href="/css/xr03/xr030000.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	
<div class="wrapper">
 

  <div class="left">
	  <div class="table-name">Slot</div>

    <table id="slot-table" class="common-table">
      <thead>
        <tr>
          <th>Slot</th>
          <th >Motion Code</th>
          <th>Environment Code</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
        <tr>
          <td>2</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
        <tr>
          <td>3</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
        <tr>
          <td>4</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>5</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>6</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>7</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>8</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>9</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>10</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>11</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>12</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>13</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>14</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>15</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>16</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>17</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>18</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>19</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
		       <tr>
          <td>20</td>
          <td>motion 123</td>
          <td>env 123</td>
        </tr>
      </tbody>
    </table>
	</div>
	  
	    <div class="right">
				  <div class="table-name">Model</div>
	      <div class="table-top">
      <label>Slot </label>
      <select id="select-slot">
        <option >--Select Slot--</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
      </select>

    <div> Environment  <span class="btn_upload">
			  
	<label for="upload-sample">Upload</label>
			   <input class="upload-name" value="upload file" style="width: 130px;" disabled/>
    <input type="file"  class="upload-hidden" id="upload-sample">
</span>
			 
    <span class="button-letter">Transfer</span> <span class="button-letter caution" >Erase</span> </div>
     </div>
    <table id="setting-table" class="common-table">
      <thead>
       <tr>
          <th>Model</th>
          <th>Strong</th>
          <th>Board</th>
          <th>Motion File</th>
        </tr>
      </thead>
      <tbody>
  
        <tr>
          <td>nx1</td>
          <td>3</td>
          <td>sample board</td>
          <td>  <div class="btn_upload">
			  
	<label for="upload-sample1">Upload</label>
			   <input class="upload-name"  value="upload file" disabled/>
    <input type="file" class="upload-hidden" id="upload-sample1">
</div></td>
        </tr>
        <tr>
          <td>nx1</td>
          <td>3</td>
          <td>sample board</td>
          <td>
              <div class="btn_upload">
			  
	<label for="upload-sample2">Upload</label>
			   <input class="upload-name" value="upload file" disabled/>
    <input type="file" class="upload-hidden" id="upload-sample2">
</div>
            </td>
        </tr>
        <tr>
          <td>nx1</td>
          <td>3</td>
          <td>sample board</td>
          <td>   <div class="btn_upload">
			  
	<label for="upload-sample3">Upload</label>
			   <input class="upload-name" value="upload file" disabled/>
    <input type="file" class="upload-hidden" id="upload-sample3">
</div></td>
        </tr>
        <tr>
          <td>nx1</td>
          <td>3</td>
          <td>sample board</td>
          <td>
            <div class="btn_upload">
			  
	<label for="upload-sample4">Upload</label>
			   <input class="upload-name" value="upload file" disabled/>
    <input type="file" class="upload-hidden" id="upload-sample4">
</div>
            </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
</body>
<script src="/js/jquery/jquery.min.js"> </script>

<script  src="js/xr03/xr030000.js"></script>
</html>