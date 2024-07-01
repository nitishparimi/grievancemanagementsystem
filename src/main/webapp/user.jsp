<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        /* Define your CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        div.container {
            max-width: 800px;
            margin: 0 auto;
            padding: 10px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        h1 {
            background-color: #3498db;
            color: white;
            padding: 20px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            text-align: center;
        }
        h2 {
            font-size: 24px;
            margin-top: 20px;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            margin: 10px 0;
        }
        a {
            text-decoration: none;
            color: #3498db;
        }
        a:hover {
            color: #2980b9;
        }
        form {
            margin-top: 20px;
            text-align: center;
        }
        input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, ${studentId} - ${firstName} </h1>
        
        <h2>User Dashboard</h2>
        <ul>
            <li><a href="details.jsp">User Details</a></li>
            <li><a href="/submitgrievance">Submit Grievance</a></li>
            <li><a href="/idnum">Grievance History</a></li>
            <li><a href="/track">Track Status</a></li>
        </ul>
        <form action="/logout" method="GET">
            <input type="submit" value="Log Out">
        </form>
    </div>
</body>
</html>
