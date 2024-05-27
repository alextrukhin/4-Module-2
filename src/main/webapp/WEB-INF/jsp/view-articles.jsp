<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>View Articles</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>title</th>
        <th>content</th>
        <th>created at</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td><a href="<c:url value="/articles/article/${article.id}"/>">${article.title}</a></td>
            <td>${article.content}</td>
            <td>${article.created_at}</td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="<c:url value="/articles/addArticle"/>">Add new</a>
</table>
</body>
</html>