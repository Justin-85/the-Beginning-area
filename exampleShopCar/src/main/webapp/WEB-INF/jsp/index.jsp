<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "exampleShopCar.com.imsoft.dto.IndexDto" %>

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
			<jsp:include page="tool.jsp"></jsp:include> <!-- 像是每一個頁面會重複的東西，可以利用這個來放 -->
			
		</nav>
	</div>
	<hr />
	<main>
		
		<!-- 從這開始 -->
		<div style="width: 1000px; margin: 0 auto;">
			<table>
					<%
					List list = (ArrayList)request.getAttribute("index");
					//要先判斷null的問題
					if( list != null){
					  for(int i = 0 ; i<list.size();i++){
						  IndexDto indexDto = (IndexDto)list.get(i);
					  
					%>
				<tr>
				<!-- 產品圖片連結 -->
					<td rowspan="3" style="vertical-align: top; padding-top: 10px;">
						<img
						src="<%out.print(indexDto.getImg()); %>"
						width="200" style="padding-right: 20px;">
					</td>
					<!-- 標題 -->
					<td style="vertical-align: middle; height: 40px;"><span
						style="color: blue"><%=indexDto.getProdName() %></span></td>
				</tr>
				<tr>
				<!-- 敘述 -->
					<td style="vertical-align: top; height: 120px;; width: 800px;">	
						<%=indexDto.getProdDesc()%>
					</td>
				</tr>
					
				 <tr>
				<!-- 產品價格 -->		
					<td style="vertical-align: middle; text-align: right;">
						<hr> <b>價格：<span style="color: red"><%=indexDto.getPrice()%></span></b> <a
						href="/exampleShopCar/addshopcar?prodCode=<%=indexDto.getProdCode()%>"> <img style="vertical-align: middle;"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4A1jV-g_TxYq3gIIuT76Tatt-iawfwsFmioSCYM_6wm--wRfk0eiOMQUMSdIpNBOq8vw&usqp=CAU"
							width="120" > <!-- 按鈕按下去 要加進購物車 不用跳轉頁面 -->
					</a>
					</td>
					<% 
					  } 
					} 
					%>
				 </tr>
				
			</table>
		</div>
		
	</main>
</body>
</html>
