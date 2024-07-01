<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/grievancesr1" method="get">
            <label for="category">Category:</label>
            <select name="category" id="category" required>
                <option value="">Select a Category</option>
                <option value="P&D">P&D</option>
                <option value="CENTRAL GRIEVANCES">CENTRAL GRIEVANCES</option>
                <option value="EXAMINATION SECTION">EXAMINATION SECTION</option>
                <option value="ECM Dept.">ECM Dept.</option>
                <option value="CSE Dept.">CSE Dept.</option>
                <option value="ECE Dept.">ECE Dept.</option>
                <option value="BES-1 Dept.">BES-1 Dept.</option>
                <option value="BES-Il Dept.">BES-Il Dept.</option>
                <option value="BIO TECHNOLOGY Dept.">BIO TECHNOLOGY Dept.</option>
                <option value="B.Arch Dept.">B.Arch Dept.</option>
                <option value="BA Dept.">BA Dept.</option>
                <option value="BBA Dept.">BBA Dept.</option>
                <option value="MECHANICAL Dept.">MECHANICAL Dept.</option>
                <option value="B.Sc(Hons.) Agri Dept.">B.Sc(Hons.) Agri Dept.</option>
                <option value="B.Sc HM Dept.">B.Sc HM Dept.</option>
                <option value="CAMS Dept.">CAMS Dept.</option>
                <option value="CIVIL Dept.">CIVIL Dept.</option>
                <option value="Chemistry Dept.">Chemistry Dept.</option>
                <option value="B. Pharm Dept.">B. Pharm Dept.</option>
                <option value="BCA Dept.">BCA Dept.</option>
                <option value="EEE Dept.">EEE Dept.</option>
                <option value="English Dept.">English Dept.</option>
                <option value="LAW Dept.">LAW Dept.</option>
                <option value="MATHEMATICS Dept.">MATHEMATICS Dept.</option>
                <option value="MBA Dept.">MBA Dept.</option>
                <option value="Physics Dept.">Physics Dept.</option>
                <option value="KANCHANAGANGA GIRLS HOSTEL">KANCHANAGANGA GIRLS HOSTEL</option>
                <option value="STAFF QUARTERS">STAFF QUARTERS</option>
                <option value="CAMPUS NILAGIRI BOYS HOSTEL">NILAGIRI BOYS HOSTEL</option>
                <option value="ARAVALI GIRLS HOSTEL">ARAVALI GIRLS HOSTEL</option>
                <option value="VINDYA GIRLS HOSTEL">VINDYA GIRLS HOSTEL</option>
                <option value="SATPURA BOYS HOSTEL">SATPURA BOYS HOSTEL</option>
                <option value="SAHYADRI BOYS HOSTEL">SAHYADRI BOYS HOSTEL</option>
                <option value="HIMALAYA BOYS HOSTEL">HIMALAYA BOYS HOSTEL</option>
                <option value="CAMPUS ERP">ERP</option>
                <option value="FACULTY & STAFF AFFAIRS">FACULTY & STAFF AFFAIRS</option>
                <option value="P&D HYD">P&D HYD</option>
                <option value="Research & Development (R&D)">Research & Development (R&D)</option>
                <option value="CDOE GRIEVANCES">CDOE GRIEVANCES</option>
                <option value="ACCOUNTS & FINANCE">ACCOUNTS & FINANCE</option>
            </select>
            
            <input type="submit" value="Get Grievances">
            </form>
</body>
</html>