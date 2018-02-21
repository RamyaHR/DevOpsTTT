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
      
      <ul class="tab-group">
    
        <li class="tab active"><a href="#product">Product</a></li>
        
      </ul>
<div id="product">   
          <h1>Add Product</h1>
          
          <c:url value="/saveprod" var="prod"/>
          <form action="${prod}" method="post" enctype="multipart/form-data" >
          
            <div class="field-wrap">
            <label>
              Product Id<span class="req">*</span>
            </label>
            <input type="text" name="prodId"/>
          </div>
                 
          <div class="field-wrap">
            <label>
              Product Name<span class="req">*</span>
            </label>
            <input type="text" required="required" autocomplete="off" name="prodName"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Product Description<span class="req">*</span>
            </label>
            <input type="text" required="required" autocomplete="off" name="prodDescription"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Product Price<span class="req">*</span>
            </label>
            <input type="text" required="required" autocomplete="off" name="prodPrice"/>
          </div>
          
         <div class="field-wrap">
            <label>
              Product Quantity<span class="req">*</span>
            </label>
            <input type="text" required="required" autocomplete="off" name="prodQuantity" />
          </div>
          
           
          <div class="field-wrap">
            <label>
             Select Category<span class="req"></span>
            </label>
            <select class="form-control" name="catId" required="required">
            <option value="">----Category----</option>
            <c1:forEach items="${categories}" var="cat">
            <option value="${cat.catId}">${cat.catName}</option></c1:forEach>
            </select>
             </div>
             
             <div class="field-wrap">
            <label>
             Select Supplier<span class="req"></span>
            </label>
            <select class="form-control" name="supId" required="required">
            <option value="">----Supplier----</option>
            <c1:forEach items="${suppliers}" var="sup">
            <option value="${sup.supId}">${sup.supName}</option></c1:forEach>
            </select>
             </div>
          
          <div class="field-wrap">
            <label>
             <span class="req"></span>
            </label>
            <input type="file" required="required" autocomplete="off" name="pimage" />
          </div>
         
          
          <button class="button button-block">Submit</button>
          
          </form>




<div id="list">   <h1>List Of Products</h1>
<%--       	<c1:forEach items="${lcat}" var="cat"> --%>
          
          <form class="example" action="<c:url value="/dispcategory/${cat.getCatId()}"/>" style="margin-left:500px;max-width:200px">
  <input type="text" placeholder="Search.." name="search2"><button type="submit"><i class="fa fa-search"></i></button>
 </form>
<%--  	</c1:forEach><br> --%>
          <table>
          <tr>
          <th>ProdImageName</th>
          <th>ProdName</th>
          <th>ProdDescription</th>
          <th>ProdPrice</th>
          <th>ProdQuantity</th>
          <th>CategoryName</th>
          <th>SupplierName</th>
          <th>Actions</th>
          </tr>
          
          <c1:forEach items="${products}" var="prod">
          <tr>
          <td>${prod.getImagename()}</td>
          <td>${prod.getProdName()}</td>
          <td>${prod.getProdDescription()}</td>
          <td>${prod.getProdPrice()}</td>
          <td>${prod.getProdQuantity()}</td>
          <td>${prod.getCategory().getCatName()}</td>
          <td>${prod.getSupplier().getSupName()}</td>
          <td><a href="<c:url value="/updateproduct"/>">Edit</a>/<a href="<c:url value="/deleteProduct/${prod.getProdId()}"/>">Delete</a></td>
          </tr>
          </c1:forEach>
          
          </table>

        </div></div>
      </div><!-- tab-content -->
      
</div>
       
  
</body>
</html>