<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="beans.Patientbeans"%>

<html>
<body>
<jsp:useBean id="patientList" class="java.util.ArrayList" scope="session" />




<%= patientList.size()%>件の患者が保険切れです。<br>



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
  <td><%= patient.getPatid()%></td>
  <td><%= patient.getFname()%></td>
  <td><%= patient.getLname()%></td>
  <td><%= patient.getHokenmei()%></td>
  <td><%= patient.getHokenexp() %></td>
</tr>

<%} %>

</table>
<br>
保険情報の変更<br>
<form action="PatientServlet"method="post" >
変更したい患者id<input type="text" name="patid"><br>

新しい保険名<input type="text"name="hokenmei"><br>
保険有効期限:<input type="text" name="year">年<input type="text"name="month">月<input type="text"name="day">日<br>
<br>
<input type="submit"value="保険情報変更"name="button">

</form>

<a href="emproyeeloginseccess.jsp" >戻る</a>
<br>
</body>
</html>