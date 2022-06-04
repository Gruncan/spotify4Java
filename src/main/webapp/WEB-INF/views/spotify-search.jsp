<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Search spotify</title>
    <link href="<c:url value="/css/search.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div id="searchForm">
    <c:url var="search_url" value="/search/"/>
    <form:form action="${search_url}" method="post" modelAttribute="search">
        <div id="searchDiv">
            <label>
                <form:input path="value" id="searchValue" type="text" required="required"/>
                <ul>
                    <li s>s</li>
                    <li e>e</li>
                    <li a>a</li>
                    <li r>r</li>
                    <li c>c</li>
                    <li h>h</li>
                </ul>
            </label>
        </div>
        <input type="submit" value="submit" hidden>
    </form:form>
</div>
<div id="searchResult">
    <div id="searchContainer">
        <c:choose>
            <c:when test="${success}">
                <ul>
                    <c:forEach items="${results}" var="trackArtist">
                        <li>
                                ${trackArtist.name} : "${trackArtist.id}"
                            Genres[
                            <c:forEach items="${trackArtist.genres}" var="genre">
                                ${genre},
                            </c:forEach>
                            ]
                            Followers: ${trackArtist.followers}

                                <%--                            <jsp:useBean id="" type="java.util.ArrayList" scope="session" />--%>
                                <%--                            <c:forEach items="${trackArtist.images}" var="images">--%>
                                <%--                                <img src="${images.url}">--%>
                                <%--                            </c:forEach>--%>

                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p> No results</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>


</body>
</html>