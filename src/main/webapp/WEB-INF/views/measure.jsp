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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Add measure</title>
  <style>
    .error {
      color: #ff0000;
    }
    .errorblock {
      color:#000;
      background-color: #ffEEEE;
      border: 3px solid #ff0000;
      padding: 8px;
      margin: 16 px;
    }
  </style>
</head>
<body>
  <h1>Add measures</h1>

  Language: <a href="?language=en">English</a> | <a href="?language=rus">Русский</a>
  <form:form commandName="measure">
    <table>
      <tr>
        <td>
          <spring:message text="Age"/>
        </td>
        <td>
          <form:input path="age" />
        </td>
      </tr>
      <tr>
        <td>
          <spring:message text="Weight"/>
        </td>
        <td>
          <form:input path="weight" />
          <form:errors path="weight" />
        </td>
      </tr>
      <tr>
        <td>
          <spring:message text="High"/>
        </td>
        <td>
          <form:input path="high" />
        </td>
      </tr>
      <tr>
        <td colspan="3">
          <input type="submit" value="Enter weight"/></td>
      </tr>
    </table>

  </form:form>

  <h3>Measures List</h3>
  <c:if test="${!empty listMeasures}">
    <table class="tg">
      <tr>
        <th width="120">Date of measure</th>
        <th width="120">Kid age</th>
        <th width="120">Kid weight</th>
        <th width="120">Kid high</th>
      </tr>
      <c:forEach items="${listMeasures}" var="measure">
        <tr>
          <td>${measure.date}</td>
          <td>${measure.age}</td>
          <td>${measure.weight}</td>
          <td>${measure.high}</td>

        </tr>
      </c:forEach>
    </table>
  </c:if>

</body>
</html>
