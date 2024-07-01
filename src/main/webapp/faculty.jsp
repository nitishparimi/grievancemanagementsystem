<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Faculty Dashboard</title>
</head>
<body>
    <div>
        <h1>Welcome, ${facultyName}</h1>
        
        
        <h2>Submitted Grievances</h2>
        <ul>
            <!-- Assuming you have a list of grievances to display -->
            <li>Grievance 1: Description of grievance 1</li>
            <li>Grievance 2: Description of grievance 2</li>
            <!-- Repeat for other grievances -->
            <li><a href="/factgrievance">Assigned grievance </a></li>
        </ul>
        
        <!-- Log Out button that should be handled by your controller -->
        <form action="/logout1" method="GET">
            <input type="submit" value="Log Out">
        </form>
    </div>
</body>
</html>
