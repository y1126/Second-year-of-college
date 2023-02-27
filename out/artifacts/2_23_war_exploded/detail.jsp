<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>信息删除</title>
    <style>
        .a{
            margin-top: 20px;
        }
        .b{
            font-size: 20px;
            width: 160px;
            color: white;
            background-color: greenyellow;
        }
        .tb, td {
            border: 1px solid black;
            font-size: 22px;
        }
    </style>
</head>
<body>
<div align="center">
    <h1 style="color: black;">信息删除</h1>
    <a href="menu.jsp">返回主页</a>
    <table class="tb">
        <tr>
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>学生寝室</td>
        </tr>
        <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.place}</td>
                <td><a onclick="return check()"  href="Servlet?method=del&id=${list.id}">删   除</a></td>
            </tr>

        </c:forEach>
    </table>


</div>

<script type="text/javascript">
    function check() {
        if (confirm("真的要删除吗？")){
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>