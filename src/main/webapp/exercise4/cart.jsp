<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart Exc4</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exc4.css" type="text/css" />
</head>
<body>

	<h1>Your cart</h1>

	<table>
		<tr>
			<th>Quantity</th>
			<th>Description</th>
			<th>Price</th>
			<th>Amount</th>
		</tr>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<c:forEach var="item" items="${sessionScope.cart.items}">
			<tr>
				<td>
					<form action="" method="post">
						<input type = "hidden" name ="action" value="update">
						<input type="hidden" name="productCode"
							value="<c:out value ='${item.product.code}'/>"
						> 
						<input type=text name="quantity"
							   value="<c:out value='${item.quantity}'/>" id="quantity"
						>
						<input type="submit" value="Update">
					</form>
				</td>
				<td><c:out value='${item.product.description}' /></td>
				<td>${item.product.priceCurrencyFormat}</td>
				<td>${item.totalCurrencyFormat}</td>
				<td>
					<form action="" method="post">
						<input type = "hidden" name ="action" value="remove">
						<input type="hidden" name="productCode"
							value="<c:out value='${item.product.code}'/>"
						> 
						<input type="submit" value="Remove Item">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p class="totalMoney">Total money of bill: <b>${requestScope.totalMoney}</b></p>
	<p>
		<b>To change the quantity</b>, 
		enter the new quantity and click on the Update button
	</p>
	<form action="" method="post">
		<input type="hidden" name="action" value="shop">
		<input type="submit" value="Continue Shopping">
	</form>
	
	<form style="margin-top:16px" action="" method="post">
		<input type="hidden" name="action" value="checkout">
		<input type="submit" value="Checkout">
	</form>
</body>
</html>