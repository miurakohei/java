<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="beans.Tabyouinbeans"%>

<html>
<body>
<jsp:useBean id="tabyouinList" class="java.util.ArrayList" scope="session" />


検索結果


<%= tabyouinList.size()%>件登録されています。


<table border=1>

 <tr>
  <th>他病院ID</th>
  <th>名前</th>
  <th>住所</th>
  <th>電話番号</th>
  <th>資本金</th>
  <th>救急</th>
  <th>電話番号修正</th>
 </tr>


 <%
  for(int i = 0; i < tabyouinList.size();i++){
   Tabyouinbeans tabyouin = (Tabyouinbeans)tabyouinList.get(i);
 %>


 <tr>
  <td><%= tabyouin.getTabid()%></td>
  <td><%= tabyouin.getName()%></td>
  <td><%= tabyouin.getAddress()%></td>
  <td><%= tabyouin.getTel()%></td>
  <td><%= tabyouin.getSihon()%></td>
  <td><%= tabyouin.getKyukyu()%></td>
  <td><form action="TabyouinServlet"method="post">
 		<input type="hidden" name="tabid"value="<%= tabyouin.getTabid()%>">
 		<input type="text"name="tel"value="変更後の番号を入力"><br>
 		<input type="submit"name="button"value="変更を確定">
 </form>
 </td>
</tr>

<%} %>

</table>
<a href="tabyouinrefer.jsp" >検索画面に戻る</a>
<br>
</body>
</html>