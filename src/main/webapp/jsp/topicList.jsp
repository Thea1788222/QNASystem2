<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>话题列表 - QNASystem</title>
</head>
<body>

<h2>所有话题</h2>

<c:forEach var="topic" items="${topics}">
    <div style="border:1px solid #aaa; padding:10px; margin:10px;">
        <h3>${topic.title}</h3>
        <p>发布者：${topic.username}</p>
        <p>发布者id：${topic.userid}</p>
        <p style="white-space: pre-wrap;">内容：${topic.content}</p>
        <a href="${pageContext.request.contextPath}/reply?topicid=${topic.topicid}">查看/回复</a>
    </div>
</c:forEach>

<hr>

<h3>创建新话题</h3>
<form action="${pageContext.request.contextPath}/topic" method="post">
    <input type="hidden" name="action" value="create"/>

    标题：<input type="text" name="title" required><br><br>
    内容：<textarea name="content" required></textarea><br><br>

    <input type="submit" value="发布话题">
</form>

</body>
</html>
