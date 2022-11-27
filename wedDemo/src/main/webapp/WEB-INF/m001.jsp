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
  <h1>Hello ~ <%=request.getParameter("username")%></h1>
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
        <tr>
          <td>1</td>
          <td><a href='m001Edit.html'>你正在為明年的年度計畫做準備，『發展全面的（綜合）標的』不是聰明的目標設定</a></td>
          <td>2021-12-20 23:12</td>
          <td>陳曉莉</td>
        </tr>
        <tr>
          <td>2</td>
          <td><a href='m001Edit.html'>Reddit提出IPO申請</a></td>
          <td>2021-12-19 23:12</td>
          <td>羅正漢</td>
        </tr>
        <tr>
          <td>3</td>
          <td><a href='m001Edit.html'>微軟更新Azure Files支援更高效率的網路檔案系統協定NFS v4.1</a></td>
          <td>2021-12-23 23:12</td>
          <td>陳曉莉</td>
        </tr>
        <tr>
          <td>4</td>
          <td><a href='m001Edit.html'>埃及流亡政客Ayman Nour的iPhone同時被植入兩種間諜程式</a></td>
          <td>2021-12-21 23:12</td>
          <td>周峻佑</td>
        </tr>
        <tr>
          <td>5</td>
          <td><a href='m001Edit.html'>【資安週報】2021年12月13日至17日</a></td>
          <td>2021-12-21 23:12</td>
          <td>羅正漢</td>
        </tr>
        <tr>
          <td>6</td>
          <td><a href='m001Edit.html'>AWS迎來雲服務發展15周年，算力、落地布局、AI戰略全面展開</a></td>
          <td>2021-12-21 23:12</td>
          <td>周峻佑</td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
