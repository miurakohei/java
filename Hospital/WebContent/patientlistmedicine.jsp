<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="beans.Patientbeans"%>

<html>
<body>
<jsp:useBean id="patientList" class="java.util.ArrayList" scope="session" />




<%= patientList.size()%>件登録されています。<br>
患者IDをクリックで薬剤投与指示画面へ。

<table border=1>

 <tr>
  <th>患者id</th>
  <th>苗字</th>
  <th>名前</th>
  <th>保険</th>
  <th>保険有効期限</th>


 </tr>


 <%
  for(int i = 0; i < patientList.size();i++){
   Patientbeans patient = (Patientbeans)patientList.get(i);
 %>


 <tr>
  <td><a href="medicine.jsp?patid=<%= patient.getPatid() %>"><%= patient.getPatid()%></a></td>
  <td><%= patient.getFname()%></td>
  <td><%= patient.getLname()%></td>
  <td><%= patient.getHokenmei()%></td>
  <td><%= patient.getHokenexp() %></td>
</tr>

<%} %>


</table>
<a href="emproyeeloginseccess.jsp" >戻る</a>
</body>
</html>
