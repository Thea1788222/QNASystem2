<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>话题讨论 - QNASystem</title>
</head>
<body>

<h2>话题回复列表</h2>

<c:forEach var="reply" items="${replies}">
    <div style="border:1px solid #aaa; padding:10px; margin:10px;">
        <p><b>用户 ${reply.userid}：</b></p>
        <p style="white-space: pre-wrap;">${reply.content}</p>
    </div>
</c:forEach>

<hr>

<h3>添加你的回复</h3>
<form action="${pageContext.request.contextPath}/reply" method="post">
    <input type="hidden" name="action" value="add"/>
    <input type="hidden" name="topicid" value="${param.topicid}"/>

    回复内容：<br>
    <textarea name="content" required></textarea><br><br>

    <input type="submit" value="提交回复">
</form>

<br>
<a href="${pageContext.request.contextPath}/topic">返回话题列表</a>

</body>
</html>
