<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員登録</title>
</head>
<body>
<form method="POST" action="EmproyeeServlet">
入力してください<br>
従業員ID:<input type="text" name="empid"><br>
パスワード:<input type="text" name="password"><br>
苗字:<input type="text" name="empfname"><br>
名前:<input type="text" name="emplname"><br>
識別番号 1(受付)2(医師):<input type="text" name="role"><br>
<br>
<input type="submit" name="button" value="登録">

</form>

</body>
</html>