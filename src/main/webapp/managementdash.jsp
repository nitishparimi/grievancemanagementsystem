<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Grievance Management Dashboard</title>
</head>
<body>
    <h1>Management Dashboard</h1>

    <input type="text" id="searchInput" placeholder="Search by Student ID">
    
    <div id="searchResults"></div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#searchInput").on("input", function() {
                // Handle search as you type
                var inputValue = $(this).val();
                if (inputValue.length >= 3) { // You can adjust the minimum length for searching
                    $.ajax({
                        type: "GET",
                        url: "/search",
                        data: { studentId: inputValue },
                        success: function(data) {
                            $("#searchResults").html(data);
                        }
                    });
                } else {
                    $("#searchResults").empty();
                }
            });
        });
    </script>
</body>
</html>
