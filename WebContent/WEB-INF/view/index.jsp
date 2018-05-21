<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Do You Want Some Jedi Force?</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>May The Force Be With You</h1>
		</div>
		<div>
			<table class="table table-striped">
				<tr>
					<td><h4>Cart: <b> ${product}</b> product in your cart.&emsp;&emsp;</h4></td> 
					<td></td>
					<td></td>
					<td></td>
					<td><h4><a href="${pageContext.request.contextPath }/showCart">Show Cart</a></h4></td>
				</tr>
				<tr>
					<th>Image</th>
					<th>Product</th>
					<th>Price</th>
					<th>Available Quantity</th>
					<th>Add to Cart</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${products}">
					<tr>
						<td><img src="${tempProduct.image}" class="img-rounded"/></td>
						<td>${tempProduct.productname}</td>
						<td>${tempProduct.price}$</td>
						<td>${tempProduct.quantity}</td>
						<td><a class="btn btn-success" href="${pageContext.request.contextPath }/addToCart?productID=${tempProduct.id}">Add to Cart</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>