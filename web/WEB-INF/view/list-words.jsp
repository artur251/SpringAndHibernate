<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.11.2018
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Customer Manager</h1>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Customer"
               class="add-button"
               onclick="window.location.href='/customer/showFormForAdd'; return false;"/>
        <form:form action="search" method="POST">
            Search customer: <input type="text" name="theSearchName"/>

            <input type="submit" value="Search" class="add-button"/>


            <h1>Zdanie do analizy:</h1>
            <h2>${sentence}</h2>

        </form:form>

        <table>
            <tr>
                <th>Słowo</th>
                <th>Poziom poznania</th>
                <th>Tłumaczenie</th>
                <th>Akcja</th>
            </tr>

            <c:forEach var="iter" items="${wordTranslationsAll}">
                <tr>
                    <td>
                            ${iter.word.word}
                    </td>
                    <td>
                            ${iter.word.knownLevel}
                    </td>
                    <td>

                        <table>
                        <c:forEach var="ttt" items="${iter.translation}">
                            <tr>
                                <td>
                                    ${ttt.translation}

                                    <%--if     --%>
                                    <c:url var="updateLink" value="/word/showFormForUpdate">
                                        <c:param name="id" value="${ttt.id}"/>
                                    </c:url>

                                </td>

                                <td>
                                    <a href="${updateLink}">update</a>
                                </td>

                            </tr>
                        </c:forEach>
                        </table>

                    </td>


                    <%--<c:url var="updateLink" value="/word/showFormForUpdate">--%>
                        <%--<c:param name="wordId" value="${iter.word.id}"/>--%>
                    <%--</c:url>--%>


                    <%--<c:url var="deleteLink" value="/customer/deleteCustomer">--%>
                        <%--<c:param name="customerToDeleteId" value="${iter.id}"/>--%>
                    <%--</c:url>--%>




                </tr>
            </c:forEach>
        </table>


    </div>
</div>
</body>
</html>
