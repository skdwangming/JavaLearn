<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Founder
  Date: 2019/6/26
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! int i; %>

<%
    out.println(i);
    String s = "111";
    String addr = request.getRemoteAddr();
    out.println(addr + "省的");
%>

今天的日期是：<%= new Date() %>

<% for (int i = 0; i < 5; i++) {
%>
<font color="green" size="<%= i %>">
    菜鸟教程
</font><br />i
<%
    }%>

</body>
</html>
