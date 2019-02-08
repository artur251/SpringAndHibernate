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
            Search customer: <input type="text" name="theSearchName" />
            <input type="submit" value="Search" class="add-button" />


        <%--<table>--%>
            <%--<tr>--%>
                <%--<th>Słowa ze zdania</th>--%>
            <%--</tr>--%>
            <%--<c:forEach var="word" items="${translations}">--%>
                <%--<tr>--%>
                    <%--<td>${word}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
        <%--</table>--%>


        </form:form>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Name</th>
                <th>Action</th>
            </tr>

            <c:forEach var="iter" items="${customers}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${iter.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="customerToDeleteId" value="${iter.id}"/>
                </c:url>

                <tr>
                    <td>${iter.name}</td>
                    <td>${iter.lastName}</td>
                    <td>${iter.email}</td>
                    <td><a href="${updateLink}">update</a>
                    |
                    <a href="${deleteLink}"
                    onclick="if(!confirm('Are you sure to delete?'))return false">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
