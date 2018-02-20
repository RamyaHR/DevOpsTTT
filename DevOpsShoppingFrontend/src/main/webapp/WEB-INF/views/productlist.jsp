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
				
			<c1:forEach items="${products}" var="pro"> 
				 <div>
		 <c:url value="/addToCart/${pro.getProdId()}" var="cart"/>
			<form action="${cart}" method="post">
					 <a href=""><div class="product-grid love-grid">
					 
						<div class="more-product"><span> </span></div>						
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
							<div class="clearfix"> </div>
						</div></c1:forEach>
					</div>	
					 </form></div>
<!-- 					 <a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p2.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>					 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Fabric Sofa set</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>										 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p3.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div>	</a>					 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>King Dior Bed</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>												 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p4.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Newlook Sofa Set</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>													 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p5.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Maxico Sofa Set</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>												 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p6.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>CozyWilm Sofa Set</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>													 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p7.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Irony Seater</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>													 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p8.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Rory 5 Seater</h4> -->
<!-- 								<p>ID: S4BJ87</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>													 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<a href="single.html"><div class="product-grid love-grid"> -->
<!-- 						<div class="more-product"><span> </span></div>						 -->
<!-- 						<div class="product-img b-link-stripe b-animate-go  thickbox"> -->
<!-- 							<img src="images/p9.jpg" class="img-responsive" alt=""/> -->
<!-- 							<div class="b-wrapper"> -->
<!-- 							<h4 class="b-animate b-from-left  b-delay03">							 -->
<!-- 							<button class="btns"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Quick View</button> -->
<!-- 							</h4> -->
<!-- 							</div> -->
<!-- 						</div></a>						 -->
<!-- 						<div class="product-info simpleCart_shelfItem"> -->
<!-- 							<div class="product-info-cust"> -->
<!-- 								<h4>Sofa CumBed</h4> -->
<!-- 								<p>ID: SR4598</p> -->
<!-- 								<span class="item_price">$187.95</span> -->
<!-- 								<input type="text" class="item_quantity" value="1" /> -->
<!-- 								<input type="button" class="item_add items" value="ADD">	 -->
<!-- 							</div>													 -->
<!-- 							<div class="clearfix"> </div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 			</div> -->
<!-- 			<div class="rsidebar span_1_of_left"> -->
<!-- 				 <section  class="sky-form"> -->
<!-- 					 <div class="product_right"> -->
<!-- 						 <h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Categories</h4> -->
<!-- 						 <div class="tab1"> -->
<!-- 							 <ul class="place">								 -->
<!-- 								 <li class="sort">Furniture</li> -->
<!-- 								 <li class="by"><img src="images/do.png" alt=""></li> -->
<!-- 									<div class="clearfix"> </div> -->
<!-- 							  </ul> -->
<!-- 							 <div class="single-bottom">						 -->
<!-- 									<a href="#"><p>Sofas</p></a> -->
<!-- 									<a href="#"><p>Fabric Sofas</p></a> -->
<!-- 									<a href="#"><p>Love Seats</p></a> -->
<!-- 									<a href="#"><p>Dinning Sets</p></a> -->
<!-- 						     </div> -->
<!-- 					      </div>						   -->
<!-- 						  <div class="tab2"> -->
<!-- 							 <ul class="place">								 -->
<!-- 								 <li class="sort">Decor</li> -->
<!-- 								 <li class="by"><img src="images/do.png" alt=""></li> -->
<!-- 									<div class="clearfix"> </div> -->
<!-- 							  </ul> -->
<!-- 							 <div class="single-bottom">						 -->
<!-- 									<a href="#"><p>Shelves</p></a> -->
<!-- 									<a href="#"><p>Wall Racks</p></a> -->
<!-- 									<a href="#"><p>Curios</p></a> -->
<!-- 									<a href="#"><p>Ash Trays</p></a> -->
<!-- 						     </div> -->
<!-- 					      </div> -->
<!-- 						  <div class="tab3"> -->
<!-- 							 <ul class="place">								 -->
<!-- 								 <li class="sort">Lighting</li> -->
<!-- 								 <li class="by"><img src="images/do.png" alt=""></li> -->
<!-- 									<div class="clearfix"> </div> -->
<!-- 							  </ul> -->
<!-- 							 <div class="single-bottom">						 -->
<!-- 									<a href="#"><p>Table Lamps</p></a> -->
<!-- 									<a href="#"><p>Tube Lights</p></a> -->
<!-- 									<a href="#"><p>Study Lamps</p></a> -->
<!-- 									<a href="#"><p>Usb Lamps</p></a> -->
<!-- 						     </div> -->
<!-- 					      </div> -->
<!-- 						  <div class="tab4"> -->
<!-- 							 <ul class="place">								 -->
<!-- 								 <li class="sort">Bed & Bath</li> -->
<!-- 								 <li class="by"><img src="images/do.png" alt=""></li> -->
<!-- 									<div class="clearfix"> </div> -->
<!-- 							  </ul> -->
<!-- 							 <div class="single-bottom">						 -->
<!-- 									<a href="#"><p>Towels</p></a> -->
<!-- 									<a href="#"><p>Bath Roles</p></a> -->
<!-- 									<a href="#"><p>Mirrors</p></a> -->
<!-- 									<a href="#"><p>Soap Stands</p></a> -->
<!-- 						     </div> -->
<!-- 					      </div> -->
<!-- 						  <div class="tab5"> -->
<!-- 							 <ul class="place">								 -->
<!-- 								 <li class="sort">Fabric</li> -->
<!-- 								 <li class="by"><img src="images/do.png" alt=""></li> -->
<!-- 									<div class="clearfix"> </div> -->
<!-- 							  </ul> -->
<!-- 							 <div class="single-bottom">						 -->
<!-- 									<a href="#"><p>Sofas</p></a> -->
<!-- 									<a href="#"><p>Fabric Sofas</p></a> -->
<!-- 									<a href="#"><p>Beds</p></a> -->
<!-- 									<a href="#"><p>Relax Chairs</p></a> -->
<!-- 						     </div> -->
<!-- 					      </div> -->
						  
<!-- 						  script -->
<!-- 						<script> -->
<!-- // 							$(document).ready(function(){ -->
<!-- // 								$(".tab1 .single-bottom").hide(); -->
<!-- // 								$(".tab2 .single-bottom").hide(); -->
<!-- // 								$(".tab3 .single-bottom").hide(); -->
<!-- // 								$(".tab4 .single-bottom").hide(); -->
<!-- // 								$(".tab5 .single-bottom").hide(); -->
								
<!-- // 								$(".tab1 ul").click(function(){ -->
<!-- // 									$(".tab1 .single-bottom").slideToggle(300); -->
<!-- // 									$(".tab2 .single-bottom").hide(); -->
<!-- // 									$(".tab3 .single-bottom").hide(); -->
<!-- // 									$(".tab4 .single-bottom").hide(); -->
<!-- // 									$(".tab5 .single-bottom").hide(); -->
<!-- // 								}) -->
<!-- // 								$(".tab2 ul").click(function(){ -->
<!-- // 									$(".tab2 .single-bottom").slideToggle(300); -->
<!-- // 									$(".tab1 .single-bottom").hide(); -->
<!-- // 									$(".tab3 .single-bottom").hide(); -->
<!-- // 									$(".tab4 .single-bottom").hide(); -->
<!-- // 									$(".tab5 .single-bottom").hide(); -->
<!-- // 								}) -->
<!-- // 								$(".tab3 ul").click(function(){ -->
<!-- // 									$(".tab3 .single-bottom").slideToggle(300); -->
<!-- // 									$(".tab4 .single-bottom").hide(); -->
<!-- // 									$(".tab5 .single-bottom").hide(); -->
<!-- // 									$(".tab2 .single-bottom").hide(); -->
<!-- // 									$(".tab1 .single-bottom").hide(); -->
<!-- // 								}) -->
<!-- // 								$(".tab4 ul").click(function(){ -->
<!-- // 									$(".tab4 .single-bottom").slideToggle(300); -->
<!-- // 									$(".tab5 .single-bottom").hide(); -->
<!-- // 									$(".tab3 .single-bottom").hide(); -->
<!-- // 									$(".tab2 .single-bottom").hide(); -->
<!-- // 									$(".tab1 .single-bottom").hide(); -->
<!-- // 								})	 -->
<!-- // 								$(".tab5 ul").click(function(){ -->
<!-- // 									$(".tab5 .single-bottom").slideToggle(300); -->
<!-- // 									$(".tab4 .single-bottom").hide(); -->
<!-- // 									$(".tab3 .single-bottom").hide(); -->
<!-- // 									$(".tab2 .single-bottom").hide(); -->
<!-- // 									$(".tab1 .single-bottom").hide(); -->
<!-- // 								})	 -->
<!-- // 							}); -->
<!-- 						</script> -->
<!-- 						script					  -->
<!-- 				 </section> -->
<!-- 				 <section  class="sky-form"> -->
<!-- 					 <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>DISCOUNTS</h4> -->
<!-- 					 <div class="row row1 scroll-pane"> -->
<!-- 						 <div class="col col-4"> -->
<!-- 								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Upto - 10% (20)</label> -->
<!-- 						 </div> -->
<!-- 						 <div class="col col-4"> -->
<!-- 								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>40% - 50% (5)</label> -->
<!-- 								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label> -->
<!-- 								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label> -->
<!-- 								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other(50)</label> -->
<!-- 						 </div> -->
<!-- 					 </div> -->
<!-- 				 </section> 				 				  -->
<!-- 				   <section  class="sky-form"> -->
<!-- 						<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Price</h4> -->
<!-- 							<ul class="dropdown-menu1"> -->
<!-- 								 <li><a href="">								                -->
<!-- 								<div id="slider-range"></div>							 -->
<!-- 								<input type="text" id="amount" style="border: 0; font-weight: NORMAL;   font-family: 'Arimo', sans-serif;" /> -->
<!-- 							 </a></li>			 -->
<!-- 						  </ul> -->
<!-- 				   </section> -->
<!-- 				   -->
<!-- 					 <script type="text/javascript" src="js/jquery-ui.min.js"></script> -->
<!-- 					 <link rel="stylesheet" type="text/css" href="css/jquery-ui.css"> -->
<!-- 					<script type='text/javascript'>//<![CDATA[  -->
<!-- // 					$(window).load(function(){ -->
<!-- // 					 $( "#slider-range" ).slider({ -->
<!-- // 								range: true, -->
<!-- // 								min: 0, -->
<!-- // 								max: 400000, -->
<!-- // 								values: [ 8500, 350000 ], -->
<!-- // 								slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] ); -->
<!-- // 								} -->
<!-- // 					 }); -->
<!-- // 					$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) ); -->

<!-- // 					});//]]>  -->
<!-- 					</script> -->
<!-- 					 -->
					 
				   			
<!-- 			 </div>				  -->
<!-- 	      </div> -->
<!-- 		</div> -->
<!-- </div>	 -->
<!---->

<!---->


		 </div>
	 </div>
</div>
				</body>
<%-- 				<%@ include file="footer.jsp" %> --%>
				</html>		  
<%-- <%@ include file="footer.jsp" %> --%>