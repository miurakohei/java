<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<form method="post" action="CuserLoginServlet">
ユーザーID<input type="text" name="cuserid">
パスワード<input type="password" name="password">

<input type="submit" value="ログイン" name="button">
</form>


</body>
</html>