<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<html>
<head><title>他病院検索</title></head>
<body>

<form method="post" action="TabyouinReferServlet">
<hr>
資本金:<input type="number" name="num" value=0>円以上

<input type="submit" value="資本金検索" name="button">
<hr>
<input type="submit" value="全件検索" name="button">
</form>

<form method="post" action="LogOutServlet">
<input type="submit" value="ログアウト" name="button">
</form>

</body>
</html>
</html>