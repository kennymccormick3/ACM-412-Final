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
					<td><h4><a href="${pageContext.request.contextPath }">Continue Shopping</a></h4></td>
				</tr>
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Drop</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${cart}">
				
					<tr>
						<td>${tempProduct.productname}</td>
						<td>${tempProduct.price}$</td>
						<td>${tempProduct.quantity}</td>
						<td><a class="btn btn-danger" href="${pageContext.request.contextPath }/dropFromCart?productID=${tempProduct.id}"onclick="if(!(confirm('Are you sure you want to drop this product?'))) return false;">Drop From Cart</a></td>
					</tr>
					
				</c:forEach>
				
					<tr>
						<td>Summary: <b>${summary}$</b></td>
						<td><a class="btn btn-success" href="${pageContext.request.contextPath }/buyAll">Buy All</a></td>
					</tr>
					
			</table>
		</div>
	</div>
</body>
</html>