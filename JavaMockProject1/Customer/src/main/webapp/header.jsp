<%@page import="com.onlineshoping.bean.Product"%>
<%@page import="com.onlineshoping.bean.ProductList"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineshoping.bean.Customer"%>
<%@page import="com.onlineshoping.bean.Item"%>
<%@page import="com.onlineshoping.bean.ItemList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./navbar.css">
</head>
<body>
	<nav>
<img src="Publicis_Sapient_Logo.jpg" alt="add crt Logo" class="logo">
 <ul> <li><a class="a1">  ${fn: toUpperCase(sessionScope.customer.customerName)} !</a> </li><li><a class="a4" href="./main.jsp"> Home</a> </li> <li><a class="a2" href="./mycart"> Cart</a> </li><li><a href="./logout"  class="a3"> Log Out</a> </li>
</ul>
</nav>
</body>
</html>