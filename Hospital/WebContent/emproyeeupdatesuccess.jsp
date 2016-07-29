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






登録情報を変更しました。

 <table border=1>
 <tr>
  <th>ユーザID</th>
  <th>パスワード</th>
  <th>苗字</th>
  <th>名前</th>
  <th>所属</th>
 </tr>


 <tr>
  <td><jsp:getProperty name="Emproyeelogin" property="empid"/></td>
  <td><%out.print("非表示"); %></td>
  <td><jsp:getProperty name="Emproyeelogin" property="fname"/></td>
  <td><jsp:getProperty name="Emproyeelogin" property="lname"/></td>
  <td><jsp:getProperty name="Emproyeelogin" property="role"/></td>
 </tr>


</table>
<a href="loginSuccess.jsp">戻る</a>
</body>
</html>