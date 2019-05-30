<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html";charset="charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <h2>Product Form</h2>
      <form:form action="addProduct.do" commandName="product">
            Name <form:input path="name"/> </br>
            Category <form:input path="category"/> </br>
            Price <form:input path="price"/> </br>
            <button type="submit">Add Product</button>
       </form:form>
    </body>
</html>