<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
* {box-sizing: border-box}
body { margin:0; padding: 0;}
.container {
	position: relative;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.29);
	width: 100%;
	background-color: white;
	height: 500px;
	font-family: Arial;
}
</style>
<body>
<jsp:include page="Header.jsp" />
<div class="container">
<table><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><span><h2 style="font-family:Arial; color:blue">Founder</h2>
</span>
</td>
</table>
<h2 style="margin-left:20px;">Mr.Ramesh Korivi</h2>
<h4 style="margin-left:15px"> Founder & CEO</h4>
<table  style="margin-left:20px;"><td><img src="Imag/.jpg" alt="Hello Avi" width="20%"/></td><br>
</table>
<table width="60%"><td>
<!-- <p style="margin-left:20px;font-family:verdana">Oracle Certified Corporate Trainer and Motivational Speaker,
Conducted Technology Workshops in 100+ Colleges and Universities.,
Attended 20+ Conferences.</p> -->
</td>
</table>
</div>
<jsp:include page="Footer.jsp" />
</body>
</html>