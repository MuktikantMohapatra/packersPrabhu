<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/getAQuotation" method="get">
<pre>
Name        :<input type="text" name="name"/>
Email       :<input type="text" name="email"/>
Phone No 	:<input type="number" name="number"/>
Service     :<input type="checkbox" name="shifting" value="shifting" > Shifting
             <input type="checkbox" name="loading" value="loading" > Loading
             <input type="checkbox" name="packing" value="packing" > packing
Shifting From: <input type="text" name="shiftingFrom"/>
Shifting To: <input type="text" name="shiftingTo"/>
Date       :<input type="text" name="date" />
<button type="submit">Submit</button>
</pre>
</form>


</body>
</html>