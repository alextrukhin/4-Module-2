<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Article</title>
    </head>
    <body>
        <c:if test="${addArticleSuccess}">
            <div>Successfully added Article with title: ${savedArticle.title}</div>
        </c:if>

        <c:url var="add_article_url" value="/articles/addArticle"/>
        <form:form action="${add_article_url}" method="post" modelAttribute="article">
            <form:label path="title">Title: </form:label> <form:input type="text" path="title"/>
            <form:label path="content">Content: </form:label> <form:input type="text" path="content"/>
            <input type="submit" value="submit"/>
        </form:form>

        <a href="<c:url value="/articles/viewArticles"/>">Back to Articles</a>
    </body>
</html>