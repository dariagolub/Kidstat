<%--
  Created by IntelliJ IDEA.
  User: darya
  Date: 28/01/15
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add measure</title>
</head>
<body>
  <h1>Add measures</h1>

  Language: <a href="?language=en">English</a> | <a href="?language=rus">Русский</a>
  <form:form commandName="measure">
    <table>
      <tr>
        <td><spring:message code="weight.text"/> </td>
        <td> <form:input path="weight"/> </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Enter weight"/></td>
      </tr>
    </table>

  </form:form>

<h1>My new measure is: ${measure.weight}</h1>

</body>
</html>
