<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li onclick="location.href='/exampleShopCar/index01'">首頁</li>
		<li onclick="location.href='/exampleShopCar/orders'">訂單查詢</li> 
		<!-- 其他兩個是導去servlet 在網址列上打上servlet的路徑即可進入，orders是jsp 且放在WEB-INF裡面，所以打上去也進不去 -->
		<li onclick="location.href='/exampleShopCar/shopcar'">購物車</li>
	</ul>
</body>
</html>