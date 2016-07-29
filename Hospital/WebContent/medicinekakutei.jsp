<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.Medicinebeans"  %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession sessionmedicine=request.getSession(true);
String patid=(String)sessionmedicine.getAttribute("name");
%>
<%= patid %>さんへの薬剤投与を確定しました

<jsp:useBean id="touyoList" class="java.util.ArrayList" scope="session" />


<table border=1>

 <tr>
  <th>薬剤ID</th>
  <th>名前</th>
  <th>投与数</th>
 </tr>

 <%
  for(int i = 0; i < touyoList.size();i++){
   Medicinebeans medicine = (Medicinebeans)touyoList.get(i);
 %>


 <tr>
  <td><%= medicine.getMedicineid()%></td>
  <td><%= medicine.getMedicinename()%></td>
  <td><%= medicine.getSu()%><%= medicine.getUnit()%></td>
</tr>

<%} %>
</table>

<a href="patientlistmedicine.jsp" >患者一覧に戻る</a><br><br>
</body>
</html>