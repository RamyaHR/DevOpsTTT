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
<link rel="stylesheet" type="text/css" href="${css}/style.scss">
</head>

<body>
<%@ include file="header.jsp" %>
  <div class="form">

      <ul class="tab-group">

      <li class="tab active" style="margin-left:150px"><a href="#">Supplier</a></li>
      </ul>

        <div id="login">
        <c:url value="/addsupplier" var="sup"/>

          <form:form action="${sup}" method="post" name="myForm" commandName="supplier">

            <div class="field-wrap">
            <label>
              Supplier Id<span class="req">*</span>
            </label>
            <form:input type="text" path="supId"/>
          </div>

          <div class="field-wrap">
            <label>
              Supplier Name<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="supName"/>
          </div>

         

          <button class="button button-block">Submit</button>

          </form:form>

        </div>

      </div><!-- tab-content -->

</div> <!-- /form -->

<table border="1px solid black">
<tr>
<th>Supplier Id</th>
<th>Supplier Name</th>
<th>Edit/Delete</th>
<c1:forEach items="${suppliers}" var="sup">
<tr>
<td>${sup.getSupId()}</td>
<td>${sup.getSupName()}</td>
<td><a href="<c:url value="/editsupplier/${sup.getSupId()}"/>">Edit</a>/<a href="<c:url value="/deletesupplier/${sup.getSupId()}"/>">Delete</a></td>

</tr>
</c1:forEach>
</table>




  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



    <script  src="js/index.js"></script>




</body>

</html>
