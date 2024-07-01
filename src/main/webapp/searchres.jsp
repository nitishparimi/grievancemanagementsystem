<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.Grievance, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grievance Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    
    <c:forEach var="grievance" items="${grievances}">
        <!-- Display grievance details here -->
        <p>ID: ${grievance.id}</p>
        <p>Category: ${grievance.category}</p>
        <!-- Add more details as needed -->
    </c:forEach>
</body>
</html>

