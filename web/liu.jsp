<%@ page import="qsap.qsap" %><%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="qsap.qsap" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
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
<div align="center">
    <h1 style="color: black;">信息列表</h1>
    <a href="menu.jsp">返回主页</a>
    <table class="tb">
        <tr>
            <td>学生学号</td>
            <td>学生姓名</td>
            <td>学生寝室</td>
        </tr>
        <%
            List<qsap> list =(List<qsap>)request.getAttribute("list");
            int i=list.size();

            for(int k=0;k<i;k++)
            {out.print("<tr>");
                qsap p=list.get(k);
                out.println("<td>"+p.getId()+"</td>"+"<td>"+p.getName()+"</td>"+"<td>"+p.getPlace()+"</td>");
                out.print("</tr>");
                out.print("<br>");
        %>
        <p>

                <%}

        %>
    </table>


</div>
</body>
</html>
