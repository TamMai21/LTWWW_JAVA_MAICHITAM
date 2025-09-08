<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Multi-language Demo</title>
</head>
<body>

<c:set var="languageCode" value="${param.radLanguageCode}"/>
<c:if test="${not empty languageCode}">
    <fmt:setLocale value="${languageCode}" scope="session"/>
</c:if>

<fmt:setBundle basename="resource" scope="session"/>

<form action="bai3" method="get">
    <p><fmt:message key="languageMessage"/></p>
    <input type="radio" name="radLanguageCode" value="vi"
           <c:if test="${languageCode == 'vi'}">checked</c:if>/>
    <fmt:message key="vn"/>
    <input type="radio" name="radLanguageCode" value="en"
           <c:if test="${languageCode == 'en'}">checked</c:if>/>
    <fmt:message key="en"/>
    <input type="submit" value="<fmt:message key='chooseButton'/>"/>
</form>

<hr/>

<form action="login" method="post">
    <table>
        <tr>
            <td><fmt:message key="userName"/></td>
            <td><input type="text" name="txtUserName"/></td>
        </tr>
        <tr>
            <td><fmt:message key="pass"/></td>
            <td><input type="password" name="txtPassword"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key='login'/>"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
