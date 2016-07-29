<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Emproyeebeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録結果</title>

</head>
<body>

<jsp:useBean id="Emproyeelogin" class="beans.Emproyeebeans" scope="session" />






変更する項目のみ修正してください。

<form method="post" action="EmproyeeServlet">
 <table border=1>
 <tr>
  <th>従業員ID</th>
  <th>パスワード</th>
  <th>パスワード(確認)</th>
  <th>苗字</th>
  <th>名前</th>
  <th>職種</th>
 </tr>


 <tr>
  <td><jsp:getProperty name="Emproyeelogin" property="empid"/></td>
  <td><input type="text"  name="password"></td>
  <td><input type="text" name="password2"></td>
  <td><input type="text"  name="empfname" value=<jsp:getProperty name="Emproyeelogin" property="fname"/>></td>
  <td><input type="text"  name="emplname" value=<jsp:getProperty name="Emproyeelogin" property="lname"/>></td>
  <td><input type="text"  name="role" value=<jsp:getProperty name="Emproyeelogin" property="role"/>></td>
 </tr>


</table>

<input type="submit" value="ユーザー情報変更" name="button">
</form>
<br>
<form method="post" action="LogOutServlet">
<input type="submit" value="ログアウト" name="button">

</form>
<a href="emproyeeloginseccess.jsp" >戻る</a>

</body>
</html>