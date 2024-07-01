<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grievance List</title>
</head>
<body>
    <h1>Grievance List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Description</th>
        </tr>
        <%@ page import="com.example.demo.Grievance, java.util.List" %>
<%for(Grievance s : (List<Grievance>)request.getAttribute("grievances")) {%>
 <tr>
  <td><%=s.getId()%></td>
  <td><%=s.getCategory()%></td>
  <td><%=s.getDescription()%></td>
 </tr>
<%}%>
    </table>
</body>
</html>
 --%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.example.demo.Grievance, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grievance List</title>
    <style>
        /* Custom CSS for the Grievance List */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            background-color: #3498db;
            color: white;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        img {
            max-width: 100px;
            max-height: 100px;
        }
        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

    <h1>Grievance List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Description</th>
            <th>Image</th>
        </tr>
        <% for (Grievance s : (List<Grievance>)request.getAttribute("grievances")) { %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getCategory() %></td>
                <td><%= s.getDescription() %></td>
                <td>
                    <img src="data:image/jpeg;base64,<%= s.getImage() %>" alt="Grievance Image">
                </td>
            </tr>
        <% } %>
    </table>
    <a href="user">Back</a>
</body>
</html>
