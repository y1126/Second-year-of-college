<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>信息删除</title>

</head>
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
    <h1 style="color: black;">信息删除</h1>
    <a href="menu.jsp">返回主页</a>
    <form action="Servlet?method=getdel" method="post" onsubmit="return check()">
        <div class="a">
            学生学号<input type="text" id="id" name="id"/>
        </div>
        <div class="a">
            <button type="submit" class="b">查   找</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    function check() {
        var id= document.getElementById("id");;
//非空
        if(id.value == '') {
            alert('学生名为空');
            name.focus();
            return false;
        }
    }
</script>
</body>
</html>
