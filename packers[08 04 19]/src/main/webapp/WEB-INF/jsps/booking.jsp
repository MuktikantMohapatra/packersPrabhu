<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method = "post" action="booking" >
<pre>
<input type="hidden" value = "${id}"name= "custId">
Welcome ${name}
<img alt="ddd" src="E:\workspace\packers\Packers-master\Packers\src\main\webapp\img\author.png"/>


<div>
Name        :<input type="text" name="name"/><br/>
Email       :<input type="text" name="email"/><br/>
Phone No 	:<input type="number" name="number"/><br/>
Service     :<input type="checkbox" name="shifting" value="shifting" /> Shifting<br/>
             <input type="checkbox" name="loading" value="loading" /> Loading<br/>
             <input type="checkbox" name="packing" value="packing" /> packing<br/>
Shifting From: <input type="text" name="shiftingFrom"/><br/>
Shifting To: <input type="text" name="shiftingTo"/><br/>

Types of Goods:<input type="radio" name="goodsType" value="domestic" />Domestic
			<input type="radio" name="goodsType" value="official"/>Official
			<input type="radio" name="goodsType" value="factory"/>Factory
			
			<input type="checkbox" name="list" value="tv"/>tv
	
Date       :<input type="text" name="date" /><br/>
<button type="submit">Submit</button>
</div>
</pre>
</form><%-- 
<%!String ele = request.getParameter("goodsType");%>
			<% if(ele.equals("domestic"))
				out.print("domestic"); //logic goes here
			
			%>	 --%>
</body>
</html>