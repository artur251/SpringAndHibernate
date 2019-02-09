<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                            ${iter.word}
                    </td>
                    <td>
                            ${iter.knownLevel}
                    </td>
                    <td>

                        <table>
                        <c:forEach var="ttt" items="${iter.translations}">
                            <tr>
                                <td>
                                    ${ttt.translation}

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

                        <td>
                            <c:url var="insertLink" value="/word/showFormForAdd">
                                <c:param name="idWord" value="${iter.id}"/>
                                <c:param name="sentence" value="${sentence}"/>
                            </c:url>
                            <a href="${insertLink}">insert</a>
                        </td>

                    </td>



                </tr>
            </c:forEach>
        </table>


    </div>
</div>
</body>
</html>
