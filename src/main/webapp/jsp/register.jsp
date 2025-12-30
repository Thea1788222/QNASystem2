<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册 - QNASystem</title>
</head>
<body>
<h2>用户注册</h2>

<form action="${pageContext.request.contextPath}/user" method="post">
    <input type="hidden" name="action" value="register"/>

    用户名：<input type="text" name="username" required><br><br>
    密码：<input type="password" name="password" required><br><br>

    <input type="submit" value="注册">
</form>

<br>
<a href="${pageContext.request.contextPath}/jsp/login.jsp">已有账号？返回登录</a>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

</body>
</html>
