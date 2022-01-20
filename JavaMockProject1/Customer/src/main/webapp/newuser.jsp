<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PS Online Shop-Sign up Page</title>
<link rel="stylesheet" href="./newuser.css"> 
</head>
<body class="first">
	<div  class="logo1">
	<h2 class="h2"> PS Online Shop</h2>
	<img src="Publicis_Sapient_Logo.jpg" alt="add crt logo" class="logo"></div>
	<div class="container">
		<main>
			<form action="./signup" method="post">
					Enter Name : <input type="text" name="name" placeholder="Name" required class="namepass"><br><br>
					Enter Email : <input type="email" name="email" placeholder="Email" required class="namepass"><br><br>
					Enter Password : <input type="password" name="password" placeholder="Password" required class="namepass"><br><br>
					<a href="./index.jsp"><input type="submit" value="submit" class="btn"></a>
			</form>
		</main>
</div>
</body>
</html>