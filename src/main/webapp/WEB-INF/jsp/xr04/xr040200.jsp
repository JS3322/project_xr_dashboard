<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
<link href="css/xr04/xr040200.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="wrap wd668">
  <div class="container">
    <div class="form_txtInput">
      <div class="common_form">
        <table>
          <colgroup>
          <col width="30%"/>
          <col width="auto"/>
          </colgroup>
          <tbody>
            <tr>
              <th><span>Policy</span></th>
              <td><table class="sub-table">
                  <thead>
                    <tr>
                      <th></th>
                      <th >Read</th>
                      <th>Create</th>
                      <th>Update</th>
                      <th>Delete</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>contents</td>
                      <td>Y</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                    <tr>
                      <td>Ingest</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                    <tr>
                      <td>Query</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                    <tr>
                      <td>SPL</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                    <tr>
                      <td>Code</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                    <tr>
                      <td>Management</td>
                      <td>Y</td>
                      <td>N</td>
                      <td>N</td>
                      <td>N</td>
                    </tr>
                  </tbody>
                </table></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="common_form">
        <table>
          <colgroup>
          <col width="30%"/>
          <col width="auto"/>
          </colgroup>
          <tbody>
            <tr>
              <th><span>ID</span></th>
              <td><input type="text" placeholder="ID 를 입력하세요.">
                <span class="button-letter">Search</span></td>
            </tr>
            <tr>
              <th> </th>
              <td>* [JS] Already a member. change information.</td>
            </tr>
            <tr>
              <th> </th>
              
              <!--				  	<td>* 존재하지 않는 ID 입니다.신규 등록을 진행합니다.</td> --> 
            </tr>
            <tr>
              <th><span>Select</span></th>
              <td><input type="radio" name="chk_account" value="root">
                Root
                <input type="radio" name="chk_account" value="manager">
                Manager
                <input type="radio" name="chk_account" value="user" checked="checked">
                User </td>
            </tr>
            <tr>
              <th><span>Password</span></th>
              <td><input type="text" placeholder="Password"></td>
            </tr>
            <tr>
              <th><span>Password Confirm</span></th>
              <td><input type="text" placeholder="Password Confirm"></td>
            </tr>
          </tbody>
        </table>
        <div class="exform_txt"><span>Please fill in the required information.</span></div>
      </div>
      <div class="btn_wrap"> <a href="#">Save</a> </div>
    </div>
  </div>
</div>
</body>
</html>