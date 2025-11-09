<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-5">

<h2 class="text-center mb-4">EMPLOYEE LIST</h2>

<div class="d-flex justify-content-between mb-3">
    <form class="d-flex" method="get" action="#">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>

    <a href="${pageContext.request.contextPath}/employees/show-form" class="btn btn-primary">Add Employee</a>
</div>

<table class="table table-striped table-bordered text-center align-middle">
    <thead class="table-dark">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employees/update/${employee.id}" class="text-primary">Update</a> |
                <a href="${pageContext.request.contextPath}/employees/delete/${employee.id}" class="text-danger"
                   onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
