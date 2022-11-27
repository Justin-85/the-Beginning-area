<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <a href="m001.html">最新消息</a>
      <a class="active" href="m002.html">訂單資料</a>
      <a href="about.html">個人資料</a>
      <a href="index.html" style="float:right;">登出</a>
    </div>
    <table>
      <tbody>
        <tr>
          <td style="background-color: gray;">訂單編號</td>
          <td><input type="text"></td>
          <td style="background-color: gray;">商品名稱</td>
          <td><input type="text"></td>
        </tr>
        <tr>
          <td></td>
          <td colspan="3"><button>查詢</button></td>
        </tr>
      </tbody>
    </table>
    <BR>
    <table>
      <thead>
        <tr>
          <th>訂單編號</th>
          <th>商品名稱</th>
          <th>單價</th>
          <th>數量</th>
          <th>總價</th>
          <th>訂單時間</th>
        </tr>
      </thead>
      <tbody>
        <tr>
        		<%  %>
          <td><a href="#">P20211115007</a></td>
          <td>產品名稱-AAAA</td>
          <td>3</td>
          <td>200000</td>
          <td>600000</td>
          <td>2021-12-19 23:12</td>
        </tr>
       
      </tbody>
      <caption><a href="#" style='padding:5px;'>1</a><a href="#" style='padding:5px;'>2</a><a href="#" style='padding:5px;'>3</a><a href="#" style='padding:5px;'>4</a></caption>
    </table>
  </body>
</html>
