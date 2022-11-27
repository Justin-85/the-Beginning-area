<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="examplem002.com.imsoft.servlet.M002Servlet"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exampleShopCar.com.imsoft.dto.IndexDto"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* Add a black background color to the top navigation */
.topnav {
	background-color: #333;
	overflow: hidden;
	margin-bottom: 10px;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #04aa6d;
	color: white;
}

table, th, td {
	border: solid 1px #000;
	padding: 10px;
}

table {
	border-collapse: collapse;
	caption-side: bottom;
	width: 100%;
}

caption {
	font-size: 16px;
	font-weight: bold;
	padding-top: 5px;
}
</style>
</head>
<body>
	<div class="topnav">
		<a href="m001.html">最新消息</a> <a class="active" href="m002.html">訂單資料</a>
		<a href="about.html">個人資料</a> <a href="index.html"
			style="float: right;">登出</a>
	</div>
	
	<%
	//當下會沒有顯示出來，可能是因為servlet那邊沒有拿到prodCode 所以在跑查詢的時候就是null 也就是連資料庫的東西都沒有撈到，所以也沒有東西存進car裡面
		List car = (ArrayList) request.getAttribute("addshopcar");
		if (car != null) {
			for (int i = 0; i < car.size(); i++) {
				//M002Servlet m002 = (M002Servlet)list.get(i);  
				IndexDto indexDto = (IndexDto) car.get(i);
	%>

	
	<table>
		<thead>
			<tr>
				<td><%=indexDto.getProdName()%></td>
				<td>商品名稱</td>
				<td>單價</td>
				<td>數量</td>
				<td>總價</td>
				<td>訂單時間</td>
			</tr>
		</thead>



		<tr>
			<td>213</td>
			<td></td>
			<td>3</td>
			<td>200000</td>
			<td>600000</td>
			<td>2021-12-19 23:12</td>
		</tr>
		<%
		 }
		}
		%>


		<caption>
			<a href="#" style='padding: 5px;'>1</a><a href="#"
				style='padding: 5px;'>2</a><a href="#" style='padding: 5px;'>3</a><a
				href="#" style='padding: 5px;'>4</a>
		</caption>
	</table>
</body>
</html>
