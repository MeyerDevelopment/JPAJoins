<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
<form action = "editExistingListServlet" method="post">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
Inventory Date: <input type ="text" name = "month" placeholder="mm" size="4" value="${listToEdit.invDate.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${listToEdit.invDate.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.invDate.getYear()}">
Shop Name: <input type = "text" name = "shopName" value="${listToEdit.shop.shopName}"><br />
<input type = "hidden" name = "id" value="${listToEdit.id}">
Current Items:<br />
<select name="currentItems" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfItems}">
          <option value = "${listVal.id}">${listVal.item}</option>          
  </c:forEach>
</select>
<br />
Remaining Items:<br />
<select name="itemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItemsToAdd}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.item}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit List and Edit Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>

</html>