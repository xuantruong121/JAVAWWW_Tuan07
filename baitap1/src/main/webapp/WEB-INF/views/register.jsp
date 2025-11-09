<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-5">

<h2 class="text-center mb-4">
    <c:choose>
        <c:when test="${employee.id != null}">UPDATE EMPLOYEE</c:when>
        <c:otherwise>REGISTRATION EMPLOYEE</c:otherwise>
    </c:choose>
</h2>

<div class="container" style="max-width: 600px;">
    <%--@elvariable id="employee" type="iuh.fit.se.entities.Employee"--%>
    <form:form action="${pageContext.request.contextPath}/employees/save" method="post" modelAttribute="employee">
        <form:hidden path="id"/>

        <div class="mb-3">
            <label class="form-label">First Name</label>
            <form:input path="firstName" cssClass="form-control"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Last Name</label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Date of Birth</label>
            <form:input path="dateOfBirth" type="date" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Phone Number</label>
            <form:input path="phone" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Gender</label><br/>
            <form:radiobutton path="gender" value="male"/> Male
            <form:radiobutton path="gender" value="female"/> Female
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-primary">
                <c:choose>
                    <c:when test="${employee.id != null}">Update</c:when>
                    <c:otherwise>Register</c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>

</body>
</html>
