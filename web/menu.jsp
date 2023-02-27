<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寝室管理系统</title>
</head>
<body>
<div align="center">
    <div class="a">
        <input type="button" value="信息登记" onclick="location.href='add.jsp'" />
    </div>
    <div class="a">
        <input type="button" value="信息修改" onclick="location.href='h.jsp'" />
    </div>
    <div class="a">
        <input type="button" value="信息删除" onclick="location.href='del.jsp'" />

    </div>
    <div class="a">
        <input type="button" value="信息查询" onclick="location.href='searchlist.jsp'" />

    </div>
    <div class="a">
        <input type="button" value="信息浏览" onclick="location.href='Servlet?method=list'" />
    </div>
</div>
</body>
</html>
