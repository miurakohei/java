<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.Patientbeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録結果</title>

</head>
<body>

<jsp:useBean id="Patientregister" class="beans.Patientbeans" scope="session" />






患者登録しました。

 <table border=1>
 <tr>
  <th>患者ID</th>
  <th>苗字</th>
  <th>名前</th>
  <th>保険名</th>
  <th>保険有効期限</th>
 </tr>


 <tr>
  <td><jsp:getProperty name="Patientregister" property="patid"/></td>
  <td><jsp:getProperty name="Patientregister" property="fname"/></td>
  <td><jsp:getProperty name="Patientregister" property="lname"/></td>
  <td><jsp:getProperty name="Patientregister" property="hokenmei"/></td>
  <td><jsp:getProperty name="Patientregister" property="hokenexp"/></td>
 </tr>


</table>
<a href="emproyeeloginseccess.jsp" >戻る</a>
</body>
</html>