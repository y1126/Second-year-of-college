<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2023/2/23
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寝室添加</title>
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
    <h1 style="color: black;">寝室添加</h1>
    <a href="menu.jsp">返回主页</a>
    <form  action="Servlet?method=add" method="post" onsubmit="return check()">
        <div class="a">
            学生学号<input type="text"  name="id" id="id" >
        </div>
        <div class="a">
            学生姓名<input type="text"  name="name"  >
        </div>
        <div class="a">
            学生寝室<input type="text"  name="place" >
        </div>
        <div class="a">
            <button type="submit" class="b">提交</button>
            <input type="reset">
        </div>
    </form>
</div>
<script type="text/javascript">

    function check() {
        var id =document.getElementById("id");

        if(id.value == '') {
            alert('学生名为空');
            id.focus();
            return false;
        }
        if(id.value.length >=20) {
            alert('不符合字数要求');
            id.focus();
            return false;
        }
    }
</script>
</body>
</html>

