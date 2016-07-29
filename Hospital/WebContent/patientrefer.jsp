<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>患者登録</title>
</head>
<body>
<form method="POST" action="PatientServlet">
入力してください<br>
患者ID:<input type="text" name="patid"><br>
苗字:<input type="text" name="patfname"><br>
名前:<input type="text" name="patlname"><br>
保険名:<input type="text" name="hokenmei"><br>
保険有効期限:<input type="text" name="year">年<input type="text"name="month">月<input type="text"name="day">日<br>
<br>
<input type="submit" name="button" value="登録">

</form>
<a href="emproyeeloginseccess.jsp" >戻る</a>

</body>
</html>