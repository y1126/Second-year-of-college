<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/24
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

</head>
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
<body>
<%

    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<div align="center">
    <h1 style="color: black;">信息列表</h1>
    <a href="menu.jsp">返回主页</a>
    <table class="tb">
        <tr>
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>学生寝室</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="list">
            <form action="Servlet?method=update&id=${list.id}" method="post" onsubmit="return check()">
                <td><input type="text" id="id" name="id"value="${list.id}" /></td>
                <td><input type="text" id="name" name="name" value="${list.name}" /></td>
                <td><input type="text" id="place" name="place" value="${list.place}"/></td>
                <td><button type="submit" class="b">修改</button></td>
            </form>
            <tr></tr>>
        </c:forEach>

    </table>
</div>

</body>
</html>