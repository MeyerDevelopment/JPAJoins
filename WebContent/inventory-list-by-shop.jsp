<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Lists</title>
</head>
<body>
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
 <td><input type="radio" name="id" value="${currentlist.id}"></td>
 <td><h2>${currentlist.listName}</h2></td></tr>
 <tr><td colspan="3">Inventory Date: ${currentlist.invDate}</td></tr>
 <tr><td colspan="3">Shop:
${currentlist.shop.shopName}</td></tr>
 <c:forEach var = "listVal" items = "${currentlist.listOfItems}">
 <tr><td></td><td colspan="3">
 ${listVal.store}, ${listVal.item}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addItemsForListServlet">Create a new list</a>
<a href="index.html">Insert a new item</a>
</body>
</html>