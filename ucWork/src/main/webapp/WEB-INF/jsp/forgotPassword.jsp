<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>忘記密碼</title>
<link rel="stylesheet" href="../css/forgotPassword.css">
</head>
<body>
<h1>忘記密碼</h1>

<form action="forgotPassword" class="forgotPassword">
	帳號    <input type="text" name="account" ><br>
	e-mail <input type="text" name="email"><br>
	<button type="reset">←返回登入頁</button>
	<button type="submit" value="getPassword">獲取驗證碼</button>

</form> 



</body>
</html>