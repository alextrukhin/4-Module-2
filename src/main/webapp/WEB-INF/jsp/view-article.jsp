<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${article.title}</title>
</head>
<body>

<h1>${article.title}</h1>

<p>${article.content}</p>

<p>Created at: ${article.created_at}</p>

<a href="<c:url value="/articles/viewArticles"/>">All articles</a>
</body>
</html>