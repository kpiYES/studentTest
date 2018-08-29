<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Misha
  Date: 28.08.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="vertical-menu">
    <p class="active">Tests</p>

    <ul>
        <c:forEach var="test" items="${sessionScope.testSet}">
            <li>
                <a href="dispatcher?command=showTestToPassTestFragment&testId=${test.id}"><c:out value="${test.name}"/></a>
            </li>
        </c:forEach>
    </ul>
</div>

<c:if test="${requestScope.subSubPageFragment!=null}">
    <c:import url="${requestScope.subSubPageFragment}"/>
</c:if>

</body>
</html>
