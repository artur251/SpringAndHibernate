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
            <table>
                <tr>
                    <th>Słowa ze zdania</th>
                </tr>
                <c:forEach var="iter" items="${sentenceWords}">
                    <tr>
                        <td>${iter}</td>
                    </tr>
                </c:forEach>
            </table>


        </form:form>
        <table>
            <tr>
                <th>Language</th>
                <th>Word</th>
                <th>Translation</th>
                <th>Sentence</th>
                <th>Known Level</th>
                <th>Source</th>

                <th>Action</th>

            </tr>

            <%--<c:forEach var="iter" items="${translations}">--%>

            <%--&lt;%&ndash;<c:url var="updateLink" value="/customer/showFormForUpdate">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:param name="customerId" value="${iter.id}"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:url>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:url var="deleteLink" value="/customer/deleteCustomer">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<c:param name="customerToDeleteId" value="${iter.id}"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:url>&ndash;%&gt;--%>

            <%--<tr>--%>
            <%--<td>${iter.language}</td>--%>
            <%--<td>${iter.word}</td>--%>
            <%--<td>${iter.translation}</td>--%>
            <%--<td>${iter.sentence}</td>--%>
            <%--<td>${iter.knownLevel}</td>--%>
            <%--<td>${iter.source}</td>--%>

            <%--<td><a href="${updateLink}">update</a>--%>
            <%--|--%>
            <%--<a href="${deleteLink}"--%>
            <%--onclick="if(!confirm('Are you sure u want to delete?'))return false">delete</a></td>--%>
            <%--</tr>--%>
            <%--</c:forEach>--%>
        </table>


        <table>
            <tr>
                <th>Słowo</th>
                <th>TłumaczenieXXX</th>
            </tr>

            <c:forEach var="iter" items="${wordTranslationsAll}">
                <tr>
                    <td>
                            ${iter.word.word}
                    </td>
                    <td>

                        <table>
                        <c:forEach var="ttt" items="${iter.translation}">
                            <tr>
                                <td>
                                    ${ttt.translation}
                                </td>
                            </tr>
                        </c:forEach>
                        </table>

                    </td>
                </tr>
            </c:forEach>
        </table>


    </div>
</div>
</body>
</html>
