<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录 - QNASystem</title>
</head>
<body>
<h2>用户登录</h2>

<form action="${pageContext.request.contextPath}/user" method="post">
    <input type="hidden" name="action" value="login"/>

    用户名：<input type="text" name="username" required><br><br>
    密码：<input type="password" name="password" required><br><br>
    验证码：
    <input type="text" name="captchaInput" required />
    <br>
    <img src="${pageContext.request.contextPath}/captcha" onclick="this.src='${pageContext.request.contextPath}/captcha?'+Math.random()"/>
    (点击图片刷新)
    <br><br>


    <input type="submit" value="登录">
</form>

<br>
<a href="${pageContext.request.contextPath}/jsp/register.jsp">没有账号？点击注册</a>

<%-- 登录失败提示 --%>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

</body>
</html>
