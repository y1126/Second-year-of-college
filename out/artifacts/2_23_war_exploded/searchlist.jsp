<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>寝室信息查询</title>

</head>
<body>
<div align="center">
    <h1 style="color: black;">信息查询</h1>
    <a href="menu.jsp">返回主页</a>
    <form action="Servlet?method=search" method="post" onsubmit="return check()">
        <div class="a">
            学生学号<input type="text" id="id" name="id"/>
        </div>
        <div class="a">
            学生姓名<input type="text" id="name" name="name" />
        </div>
        <div class="a">
            学生寝室<input type="text" id="place" name="place" />
        </div>
        <div class="a">
              <button type="submit" class="b">查&nbsp;询</button>
        </div>
    </form>
</div>
</body>
</html>
