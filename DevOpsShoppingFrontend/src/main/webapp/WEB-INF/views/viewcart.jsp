 <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" media="all">
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>

<link rel="stylesheet" type="text/css" href="${css}/mainstyle.css">
<%-- <link rel="stylesheet" type="text/css" href="${css}/style.css"> --%>
<link rel="stylesheet" type="text/css" href="${css}/style.scss">

</head>

<body>
<%@ include file="header.jsp" %>
<style>
.form {
  background: rgba(19, 35, 47, 0.9);
  padding: 40px;
  max-width: 1000px;
  margin: 40px auto;
  border-radius: 4px;
  -webkit-box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
          box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
}

.tab-group li a {
  display: block;
  text-decoration: none;
  padding: 15px;
  background: rgba(160, 179, 176, 0.25);
  color: #a0b3b0;
  font-size: 20px;
  float: left;
  width:25%;
  text-align: center;
  cursor: pointer;
  -webkit-transition: .5s ease;
  transition: .5s ease;
}

table, tr, th, td
{
font-size:20px;
color:white;
border:1px solid white
}

form.example input[type=text] {
    padding: 10px;
    font-size: 17px;
    border: 1px solid grey;
    float: left;
    width: 80%;
    background: #f1f1f1;
}

form.example button {
    float: left;
    width: 20%;
    padding: 10px;
    background: #a0b3b0;
    color: white;
    font-size: 17px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
}

</style>

<div class="form">
      
<!--       <ul class="tab-group"> -->
<%-- <%--       <c:url value="/admin/category" var="cat"/>  --%> --%>
<!--         <li class="tab"><a href="#cart">Cart</a></li> -->
        
<!--       </ul> -->
      
<!--       <div class="tab-content"> -->
        
<!--       <div id="list">   <h1>List of Products in Cart</h1> -->
<%--       	<c1:forEach items="${lcat}" var="cat"> --%>
          
          

<!--           <div class="row"> -->
<!-- 	<div class="span12"> -->
   
<!-- 	<div class="well well-small"> -->
		<h1>CartItems in your cart<small class="pull-right"> ${items} Items are in the cart </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>IMAGE</th>
                  <th>NAME</th>
				  <th>	PRICE </th>
                  <th>Remove/Buy now</th>
                 
				</tr>
              </thead>
              <tbody>
                 <c1:forEach items="${cartItems}" var="pro">
      <tr>
        <td><img src="${pageContext.request.contextPath}/resources/${pro.getProduct().getImagename()}",width=50px, height=20px></td>
        <td>${pro.getProduct().getProdName() }</td>
        <td>${pro.getProduct().getProdPrice()}</td>
<%--         <td>${pro.getProduct().getDes()}</td> --%>
        <td><a href="<c:url value='/Remove/${pro.getCartitemsId()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove</a>
        </td>
      </tr>
      </c1:forEach>
                </tbody>

  </table>
  <center><h2>Total price=${gtotal}</h2></center>
<center> <a href="<c:url value='/'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Back To Shopping</a>/<a href="<c:url value='/checkout'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy All </a>
  </center></div>
        </div></div>
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="${js}/index.js"></script>




</body>

</html>
      
      