<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.Medicinebeans"  %>
    <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%String patid=null;%>

<%try{
	patid=request.getParameter("patid");
	HttpSession sessionmedicine=request.getSession(true);
	if(patid!=null){
		sessionmedicine.setAttribute("name", patid);
	}
	patid=(String)sessionmedicine.getAttribute("name");
	Medicinebeans medicinebeans;
	medicinebeans=new Medicinebeans();
	ArrayList<Medicinebeans> medicineList = new ArrayList<Medicinebeans>();
	medicineList = medicinebeans.getMedicineIchiran();
	sessionmedicine.setAttribute("medicineList",medicineList);
}catch(Exception e){

}

%>
<%= patid %>さんの薬剤投与指示画面


<jsp:useBean id="medicineList" class="java.util.ArrayList" scope="session" />

<table border=1>

 <tr>
  <th>数を入力して薬剤投与</th>
  <th>薬剤ID</th>
  <th>名前</th>
  <th>ユニット</th>
 </tr>


 <%
  for(int i = 0; i < medicineList.size();i++){
   Medicinebeans medicine = (Medicinebeans)medicineList.get(i);
 %>


 <tr>
 <td><form action="MedicineServlet" method="post">
  <input type="hidden" name="medicineid"value="<%= medicine.getMedicineid()%>">
 	数量:<input type="text" value="0" name="example">
	  <br>
	  <input type="submit" value="薬剤投与"name="button">
	  </form>
</td>
  <td><%= medicine.getMedicineid()%></td>
  <td><%= medicine.getMedicinename()%></td>
  <td><%= medicine.getUnit()%></td>
</tr>

<%} %>

</table>
<a href="patientlistmedicine.jsp" >患者一覧に戻る</a><br><br>


<jsp:useBean id="touyoList" class="java.util.ArrayList" scope="session" />
<%if(touyoList.size()!=0){%>
投与指示済み薬剤リスト

<table border=1>

 <tr>
  <th>数を入力して解除</th>
  <th>薬剤ID</th>
  <th>名前</th>
  <th>投与数</th>
 </tr>

 <%
  for(int i = 0; i < touyoList.size();i++){
   Medicinebeans medicine = (Medicinebeans)touyoList.get(i);
 %>


 <tr>
 <td><form action="MedicineServlet" method="post">
  <input type="hidden" name="medicineid"value="<%= medicine.getMedicineid()%>">
 	数量:<input type="text" value="0" name="example">
	  <br>
	  <input type="submit" value="リストから削除"name="button">
	  </form>
</td>
  <td><%= medicine.getMedicineid()%></td>
  <td><%= medicine.getMedicinename()%></td>
  <td><%= medicine.getSu()%><%= medicine.getUnit()%></td>
</tr>

<%}} %>

</table>
<form action="TouyoServlet" method="post" >
<input type="submit"value="薬剤投与確定"name="button">
</form>

</body>
</html>