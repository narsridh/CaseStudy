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
<title>PS Online Shop-Cart Page</title>
<link rel="stylesheet" href="./mycart.css">
<%--<script type="text/javascript">
function refresh() {
	 if (confirm("Refresh...!") == true) {
		 location.replace("http://localhost:8086/Customer/mycart");
		  } else {
		  }
	
}
function deleteOne() {
	if (confirm("Delete Product From Cart...!") == true){
		location.replace("http://localhost:8085/OnlineShopping/DeleteProductFromCart");
	}
	}
function deleteAll() {
	if (confirm("Delete All Product From Cart...!") == true){
		location.replace("http://localhost:8085/OnlineShopping/DeleteAllProductFromCart");
	}
}
</script>
--%>
</head>
<body>
<%@include file="header.jsp"%>
	<%-- <h2>Here is List of Products Added In Cart</h2>
	<button onclick="refresh()">Refresh</button><br><br>--%>
	<div class="container">
	<main>
		<table class="cart">
			<thead>
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT CODE</th>
					<th>PRODUCT NAME</th>
					<th>DESCRIPTION</th>
					<th>PRODUCT PRICE</th>
					<th>QUANTITY</th>
					<th>TOTAL PRICE</th>
					<th>BUY PRODUCT</th>
					<th>DELETE ITEM</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.cartlist}" var="cartlist">
					<c:forEach var = "i" begin = "0" end = "${sessionScope.productlist.getProducts().size()-1 }">
						<c:if test = "${sessionScope.productlist.getProducts().get(i).getCode()==cartlist.items}">
							<tr>
				 <td>${sessionScope.productlist.getProducts().get(i).getId()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getCode()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getName()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getDescription()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getPrice()}</td>
				 <td>${cartlist.quantity}</td>
				 <td>${sessionScope.productlist.getProducts().get(i).getPrice()*cartlist.quantity}</td>
				<td><form action="./buyproduct" method="post">
								<input type="text" name="item" value="${sessionScope.productlist.getProducts().get(i).getCode()}" hidden="">
									<input type="text" name="quantity" value="${cartlist.quantity}" hidden="" >
									<input type="submit" value="Buy Product" class="btn" >
											</form></td>
				 <td><form action="./deleteproductfromcart" method="post">
								<input type="text" name="item" value="${sessionScope.productlist.getProducts().get(i).getCode()}" hidden="">
									<input type="text" name="quantity"  class="namepass">
									<input type="submit" value="Delete From Cart" class="btn" >
											</form></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table><br>
		

	</main>
</div>

</body>
</html>