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

<link href='http://fonts.googleapis.com/css?family=Montserrat|Raleway:400,200,300,500,600,700,800,900,100' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Aladin' rel='stylesheet' type='text/css'>

<link href="${css}/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${js}/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="${js}/menu_jquery.js"></script>
<script src="${js}/simpleCart.min.js"> </script>
<link href="${css}/form.css" rel="stylesheet" type="text/css" media="all" />

<script src="${js}/index.js"></script>


</head>

<body>
<%@ include file="header.jsp" %>

<div class="product-model">	 

	 <div class="container-fluid">
			<h2>OUR PRODUCTS</h2>
					 <a href=""><div class="product-grid love-grid">
					 <c1:forEach items="${products}" var="pro"> 
		 					<c:url value="/addToCart/${pro.getProdId()}" var="cart"/>
							<form action="${cart}" method="post">
						<div class="product-img b-link-stripe b-animate-go  thickbox">
						
							<img src="${pageContext.request.contextPath}/resources/${pro.getImagename()}" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><a href="<c:url value='/productdetails'/>"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</a></button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${pro.getProdName()}</h4>
								<p>${pro.getProdId()}</p>
								<span class="item_price">${pro.getProdPrice()}</span>								
								<input type="text" class="item_quantity" value="1" />
								<input type="submit" class="item_add items" value="ADD">
							</div>													
							</form></c1:forEach>
							</div><div class="clearfix"> </div>
						</div></div>
				
					 </div>
					 


		 </div>
	 </div>
</div>
				</body>
<%-- 				<%@ include file="footer.jsp" %> --%>
				</html>		  
<%-- <%@ include file="footer.jsp" %> --%>