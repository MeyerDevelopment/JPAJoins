<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Quantity: <input type ="text" name = "quantity" value="${itemToEdit.quantity}">
Item: <input type = "text" name = "item" value= "${itemToEdit.item}">
Price: <input type = "text" name = "price" value= "${itemToEdit.price}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>