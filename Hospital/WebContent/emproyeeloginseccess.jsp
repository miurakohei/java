<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="beans.Emproyeebeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

<jsp:useBean id="Emproyeelogin" class="beans.Emproyeebeans" scope="session" />

ログインしました。

<%if(Emproyeelogin.getRole()==1){%>
職種（受付）<br>
<jsp:getProperty name="Emproyeelogin" property="fname"/>
さん、こんにちは。
<br>
<a href="patientrefer.jsp">新規患者登録</a>
<form method="post" action="PatientServlet">
<input type="hidden"value="1"name="flag">
<input type="submit" value="患者情報変更"name="button">
</form>

<% }else{%>
職種（医者）<br>
<jsp:getProperty name="Emproyeelogin" property="fname"/>
さん、こんにちは。
<br>
<form method="post" action="PatientServlet">
<input type="hidden"value="2"name="flag">
<input type="submit" value="患者一覧表示"name="button">
</form>
<%} %>

<br><br>


<a href="emproyeeupdate.jsp">登録情報変更</a><br>
<form method="post" action="LogOutServlet">
<input type="submit" value="ログアウト" name="button">
</form>


</body>
</html>