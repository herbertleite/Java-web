<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body { margin:0; padding: 0;}
.containerh {
	position: relative;
	top: -7px;
	left: -7px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.29);
	width: 100.5%;
	opacity: 1;
	background-color: DarkRed;
	color:green;
	height: 120px;
	padding-top: 25px;
	font-family: Times New Roman;
}


.containerh img {
	margin-left: 3px;
}


.navbar {
  overflow: hidden;
  background-color: #1C1C1C;
  font-family: Times New Roman;
  width:100%;
}

/* Dropdown button */
.dropdown .dropbtn {
  font-size: 20px;
  border: 2px;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color:#1C1C1C ;
  font-family: inherit; /* Important for vertical align on mobile phones */
  margin: 0; /* Important for vertical align on mobile phones */
}

/* Links inside the navbar */
.navbar a {
  float: left;
  font-size: 20px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* The dropdown container */
.dropdown {
  float: left;
  overflow: hidden;
}


/* Add a background color to navbar links on hover */
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #8B1A1A ;
}

/* Dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #CD3333;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  float: none;
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a background color to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #1C1C1C;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

.active {
    background-color: black;
    color: white;
}
</style>
</head>
<body>

	<div class="containerh">
		<table>
		
		<tr><td><span><img src="Imag/eu.jpg" style="width: 6vw; margin-left: 85px; width="30px"; height="90px"; " /></span></td>
		<td><span style="font-size: 50px; padding-left: 2px;color:#FFE1FF; margin-left: 30px;">Herbert Leite</span></td>
		<td><span>&nbsp;&nbsp;</span></td>
		<td><span style="font-size: 50px;color: #FFE1FF;"> Soares</span> <br></td></tr>
		<tr></tr>		
		 </table>		
	</div>
	
  <div class="navbar">
  <a href="index.jsp">INICIO</a>
  <div class="dropdown">
    <button class="dropbtn">SOBRE
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="History.jsp">History</a>
      <a href="Founder.jsp">Founder</a>
      <a href="Chairman.jsp">Chairman</a>
      <a href="Members.jsp">Members</a>
    </div>
  </div>

   <div class="dropdown">
    <button class="dropbtn">CURSOS CERTIFICADOS
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Technical.jsp">Technical Courses</a>
      <a href="NonTechnical.jsp">Non Technical Courses</a>
    </div>
  </div>
   <div class="dropdown">
    <button class="dropbtn">GALERIA
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="PressGallery.jsp">Press</a>
      <a href="Fotos.jsp">Fotos</a>
    </div>
  </div>
    <a href="Experiencias.jsp">EXPERIÊNCIAS PROFISSIONAIS</a>
    <a href="Contact.jsp">CONTATO</a>
</div> 

</body>
</html>