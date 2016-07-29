<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.Cuserbeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<jsp:useBean id="cuserlogin" class="beans.Cuserbeans" scope="session" />


ログインしました。
<br>
<jsp:getProperty name="cuserlogin" property="fname"/>
さん、こんにちは。<br>
<a href="emproyerefer.jsp">従業員登録</a><br>
<form method="post" action="EmproyeetableServlet">
<input type="submit" value="従業員一覧表示"name="button">
</form>
<br>
<a href="tabyouinrefer.jsp">他病院検索</a><br>

<br>
<form method="post" action="LogOutServlet">
<input type="submit" value="ログアウト" name="button">
</form>

</body>
</html>