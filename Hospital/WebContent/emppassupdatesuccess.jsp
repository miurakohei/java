<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="beans.Emproyeebeans"%>

<html>
<body>
<jsp:useBean id="emproyeeList" class="java.util.ArrayList" scope="session" />


変更しました。

<%= emproyeeList.size()%>件登録されています。


<table border=1>

 <tr>
  <th>従業員id</th>
  <th>パスワード</th>
  <th>苗字</th>
  <th>名前</th>
  <th>職種</th>

 </tr>


 <%
  for(int i = 0; i < emproyeeList.size();i++){
   Emproyeebeans emproyee = (Emproyeebeans)emproyeeList.get(i);
 %>


 <tr>
  <td><%= emproyee.getEmpid()%></td>
  <td>非表示</td>
  <td><%= emproyee.getFname()%></td>
  <td><%= emproyee.getLname()%></td>
  <td><%= emproyee.getRole()%></td>
</tr>

<%} %>

</table>
<br>
パスワードの変更<br>
<br>
<form action="EmproyeetableServlet"method="post" >
従業員id<input type="text" name="empid">

新しいパスワード<input type="text"name="pass">もう一度入力<input type="text"name="pass2">
<br>
<input type="submit"name="button"value="パスワード変更">

</form>

<a href="loginSuccess.jsp" >戻る</a>
<br>
</body>
</html>