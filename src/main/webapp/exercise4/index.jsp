<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Exercise 4</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/exc4.css"
	type="text/css" />
</head>
<body>

	<h1>CD list</h1>
	<table>
		<tr>
			<th>Description</th>
			<th class="right">Price</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${sessionScope.products}" var="product">
			<tr>
				<td>${product.description}</td>
				<td class="right">$${product.price}</td>
				<td>
					<form action="cart" method="post">
						<input type="hidden" name="action" value="cart"> <input
							type="hidden" name="productCode" value="${product.code}"> <input
							type="submit" value="Add To Cart">
					</form>
				</td>
			</tr>
		</c:forEach>
		<!-- 
		<tr>
			<td>Paddlefoot - The first CD</td>
			<td class="right">$12.95</td>
			<td><form action="cart" method="post">
					<input type="hidden" name="action" value="cart">
					<input type="hidden" name="productCode" value="pf01"> <input
						type="submit" value="Add To Cart">
				</form></td>
		</tr>

		<tr>
			<td>Paddlefoot - The second CD</td>
			<td class="right">$14.95</td>
			<td><form action="cart" method="post">
					<input type="hidden" name="action" value="cart">
					<input type="hidden" name="productCode" value="pf02"> <input
						type="submit" value="Add To Cart">
				</form></td>
		</tr>

		<tr>
			<td>Joe Rut - Genuine Wood Grained Finish</td>
			<td class="right">$9.95</td>
			<td><form action="cart" method="post">
					<input type="hidden" name="action" value="cart">
					<input type="hidden" name="productCode" value="jr01"> <input
						type="submit" value="Add To Cart">
				</form></td>
		</tr>
 -->
	</table>
	<form action="cart" method="post">
		<button style="margin-top:16px" class="btn-image" name="action" value="homepage">
		</button>
	</form>
</body>
</html>