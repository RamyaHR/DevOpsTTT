<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
 
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" media="all">
  
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>

<link rel="stylesheet" type="text/css" href="${css}/mainstyle.css">

<link rel="stylesheet" type="text/css" href="${css}/style.scss">
<script src="${js}/index.js"></script>

</head>

<body>
${login}
	
${error}	
<%@ include file="header.jsp" %>

<style>
.form {
  background: rgba(19, 35, 47, 0.9);
  padding: 40px;
  max-width: 900px;
  margin: 40px auto;
  border-radius: 4px;
  -webkit-box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
          box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
}
table, tr, th, td
{
font-size:20px;
color:white;
border:1px solid white
}

.tab-group li a {
  display: block;
  text-decoration: none;
  padding: 15px;
  background: rgba(160, 179, 176, 0.25);
  color: #a0b3b0;
  font-size: 20px;
  float: left;
  width:75%;
  text-align: center;
  cursor: pointer;
  -webkit-transition: .5s ease;
  transition: .5s ease;
}
</style>


 <div class="form">
      
      <ul class="tab-group">
   
        <li class="tab"><a href="#list">Invoice</a></li>
      </ul>
       <div id="list"> 
<h2 style="color:white">Order Details</h2>

<table>
          <tr>
          <th>UserName</th>
          <th>MailId</th>
          <th>Address</th>
          <th>CartId</th>
          <th>ProductId</th>
          <th>ProductName</th>
          <th>GrandTotal</th>
          
          </tr>
          <tr>
          <td>${orderDetails.getName()}</td>
		  <td>${orderDetails.getEmail()}</td>
		  <td>${orderDetails.getAddress()}</td>
		<td>${orderDetails.getCart().getCartId()}</td>

		<td>${cartitems.getProduct().getProdId()}</td>
		<td>${cartitems.getProduct().getProdName()}</td>
		<td>${orderDetails.getCart().getGrandtotal()}</td>
		</tr>
		
       </table>   
</div><br>
<br>
<c:url value="/thankyou" var="thank"/>
          <form action="${thank}" method="post">
          
		 <button class="button button-block">Submit</button>
		 </form>
</body>
</html>