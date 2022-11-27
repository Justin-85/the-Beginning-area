<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exampleShopCar.com.imsoft.dto.IndexDto"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	transition: all 0.3s ease-in-out;
}

.container {
	clear: both;
	overflow: auto;
}

nav {
	float: right;
}

.logo img {
	float: left;
}

ul li {
	display: inline-block;
	padding: 10px;
	font-size: 20px;
	font-family: raleway;
}

ul li:hover {
	color: red;
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
	<div class="container">
		<div class="logo">
			<img
				src="https://atimetoshop.com/wp-content/uploads/2019/06/A-time-to-shop-Logo.png"
				alt="" width="200" />
		</div>
		<nav>
			<ul>
				<li onclick="location.href='index.html'">首頁</li>
				<li onclick="location.href='orders.html'">訂單查詢</li>
				<li onclick="location.href='login.html'">購物車</li>

			</ul>
		</nav>
	</div>
	<hr />
	<table>
		<thead>
			<tr>
				<th>序號</th>
				<th>購買商品</th>
				<th>單價</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			//取得產品資料
			List car = (List) request.getAttribute("addshopcar");
			if (car != null) {
				String price = "";
				//讓資料顯示於購物車表單內 所以要先從資料庫拿出來
				for (int i = 0; i < car.size(); i++) {
					IndexDto indexDto = (IndexDto) car.get(i);
			%>
			<tr>
				<td>
					<%
					++i;
					%>
				</td>
				<td><a href='index.html'><%=indexDto.getProdName()%></a></td>
				<td style="text-align: right;">
					<%
					price = indexDto.getPrice();
					out.println(price);
					%>
				</td>
				<td><a href="shopcar.html">移除</a></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td></td>
				<td></td>
				<td style="text-align: right;">合計金額：<span style="color: red;">
						<%
						int priceInt = Integer.parseInt(price);
						out.println(priceInt);
						%>
				</span></td>
				<td><button onclick="/exampleShopCar/shopcar.jsp">確認訂單</button></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>
