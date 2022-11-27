<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_1019.demo.com.imsoft.dto.M000Dto" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="utf-8">
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

      table,
      th,
      td {
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
      <a class="active" href="m001.html">最新消息</a>
      <a href="m002.html">訂單資料</a>
      <a href="about.html">個人資料</a>
      <a href="index.html" style="float:right;">登出</a>
    </div>

    <table>
      <thead>
        <tr>
          <th>序號</th>
          <th>主旨</th>
          <th>時間</th>
          <th>作者</th>
        </tr>
      </thead>
      <tbody>
      <%
      		List list =(ArrayList) request.getAttribute("abc");
      		for(int i = 0 ;i < list.size() ;i++ ){
      			M000Dto dto =(M000Dto)list.get(i);
      			
      %>
        <tr>
          <td><%out.print(dto.getId()); %></td>
          <td><a href='m001Edit.html'><%=dto.getTitle() %></a></td>
          <td>2021-12-20 23:12</td>
          <td>陳曉莉</td>
        </tr>
        <%
      		}
        %>
        
      </tbody>
    </table>
  </body>
</html>
