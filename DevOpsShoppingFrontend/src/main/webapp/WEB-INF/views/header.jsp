 <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page session="true"%>
<html>
<head>
<title>Interior Deisgns</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    
    <c:url value="/resources/css" var="css"/>
    <link rel="stylesheet" type="text/css" href="${css}/style.css">
 </head>
 <body bgcolor="white">
<header>
    	<nav class="navbar navbar-default hidden-xs" role="navigation">
            <div class="container">
               <div class="col-md-7">
                  <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                      <a class="navbar-brand" href="#"></a>
                    </div>
                
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                      <ul class="nav navbar-nav">
                        <li class="active"><a href="<c:url value="/"/>">Home<span class="sr-only">(current)</span></a></li>
                        <li class="hover"><a href="<c:url value="/"/>">About Us</a></li>
                        <li class="dropdown">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Products<span class="caret"></span></a>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Link 1</a></li>
                            <li><a href="#">Link 2</a></li>
                            <li><a href="#">Link 3</a></li>
                            <li><a href="#">Link 4</a></li>
                          </ul>
                          <li><a href="<c:url value="/"/>">Contact Us</a></li>
                          <li><a href="<c:url value='/admin'/>">Admin</a></li>
                    <!--<form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search">
                        </div>
	               </form>	-->					  
                      </ul>
										  
                    </div><!-- /.navbar-collapse -->
                  </div><!-- /.container-fluid -->
               </div> <!-- end col 7 -->
               <div class="col-md-5">
               	    <span class="social"><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></span>
                    <span class="social"><a href="https://www.twitter.com/"><i aria-hidden="true" class="fa fa-twitter"></i></a></span>
                    <span class="social"><a href="https://www.linkedin.com/"><i aria-hidden="true" class="fa fa-linkedin"></i></a></span>
                    <span class="social"><a href="https://www.google.com/"><i aria-hidden="true" class="fa fa-google"></i></a></span>
                    
					<ul class="nav navbar-nav" style="float:right">
<%-- 					 <li><a href="<c:url value="/login"/>">Login/Signup</a></li> --%>
					<c1:if test="${pageContext.request.userPrincipal.name==null}">
                
					<li><a data-toggle="modal" data-target="#loginModal">
						<span class="glyphicon glyphicon-log-in"></span> Login/Signup
                          </a></li></c1:if>
						  </ul>
						  
						  
						  <div id="loginModal" class="modal fade" role="dialog"> 
    
    <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          <c:url value="/saveuser" var="user"/>
          <form:form action="${user}" method="post" commandName="user">
          
<!--           <div class="top-row"> -->
            <div class="field-wrap">
              <label>
               Name<span class="req">*</span>
              </label>
              <form:input type="text" required="required" autocomplete="off" path="name"/>
            </div>
        
<!--             <div class="field-wrap"> -->
<!--               <label> -->
<!--                 Last Name<span class="req">*</span> -->
<!--               </label> -->
<!--               <input type="text"required autocomplete="off"/> -->
<!--             </div> -->
<!--           </div> -->

          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <form:input type="email" required="required" autocomplete="off" path="email"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <form:input type="password" required="required" autocomplete="off" path="password"/>
          </div>
          
           <div class="field-wrap">
            <label>
              Phone Number<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="phone"/>
          </div>
          
           <div class="field-wrap">
            <label>
              Address<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="address"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Country<span class="req">*</span>
            </label>
            <form:input type="text" required="required" autocomplete="off" path="country"/>
          </div>
          <div style="margin-left:150px">
          <button type="submit" class="button button-large">Submit</button>&nbsp;&nbsp;&nbsp;
          <button type="reset" class="button button-large">Cancel</button>
          </div>
          </form:form>

        </div>
        
         <div id="login">    
           <h1>Welcome Back!</h1> 
          
           <form action="<c:url value='/login'/>" method="post"> 
          
             <div class="field-wrap"> 
             <label> 
              Email Address<span class="req">*</span> 
             </label> 
             <input type="text" name="email" required autocomplete="off"/> 
           </div> 

          <div class="field-wrap"> 
             <label> 
               Password<span class="req">*</span> 
            </label> 
             <input type="password" name="password" required autocomplete="off"/> 
           </div> 
          
          <p class="forgot"><a href="#">Forgot Password?</a></p> 
          
          <button class="button button-block">Log In</button>         
          </form>

<!--         </div> -->
        </div>
      </div>
      
</div> 
                    
               </div> <!-- end col 5 -->
             </div> <!-- end container -->
          </nav> <!-- end nav -->
          
          
          
        <nav class="navbar navbar-default visible-xs" role="navigation" id="">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".navbar-ex2-collapse" style="padding: 8px 15px;"> <span class="sr-only">Toggle navigation</span>
                    <span aria-hidden="true" class="glyphicon glyphicon-sort"></span>
                </button>                
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<c:url value="/"/>">Home<span class="sr-only">(current)</span></a></li>
                    <li><a href="<c:url value="/"/>">About Us</a></li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Services<span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Link 1</a></li>
                        <li><a href="#">Link 2</a></li>
                        <li><a href="#">Link 3</a></li>
                        <li><a href="#">Link 4</a></li>
                      </ul>
                      <li><a href="<c:url value="/"/>">Contact Us</a></li>
                      <li><a href="<c:url value='/admin'/>">Admin</a></li>
                    
                    
                 </ul>
            </div>
            <div class="collapse navbar-collapse navbar-ex2-collapse">
                <div class="col-xs-12">
                    <ul>
                        <li><a href="https://www.facebook.com/"><i class="facebook"></i></a></li>
                        <li><span class="social"><a href="https://www.twitter.com/"><i class="twitter"></i></i></a></span></li>
                        <li><span class="social"><a href="https://www.linkedin.com/"><i class="linkedin"></i></a></span></li>
                        <li><span class="social"><a href="https://www.google.com/"><i class="google"></i></a></span></li>
                    </ul>
                </div>
                <div class="col-xs-12">
                    <form class="navbar-form qu-from" role="search">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search">
                        </div>
                    </form>
                </div>
                <ul>
                <c1:if test="${pageContext.request.userPrincipal.name!=null}">
                <li><a href="<c:url value="/login"/>">Login</a></li>
                <li><a href="<c:url value="/signup"/>">Signup</a></li>
                </c1:if></ul>
            </div>
            
<!--             <div id="loginModal" class="modal fade" role="dialog">   -->
    
<!--     <div class="form"> -->
      
<!--       <ul class="tab-group"> -->
<!--         <li class="tab active"><a href="#signup">Sign Up</a></li> -->
<!-- <!--         <li class="tab"><a href="#login">Log In</a></li> --> -->
<!--       </ul> -->
      
<!--       <div class="tab-content"> -->
<!--         <div id="signup">    -->
<!--           <h1>Sign Up for Free</h1> -->
<%--           <c:url value="/saveuser" var="user"/> --%>
<%--           <form:form action="${user}" method="post" commandName="user"> --%>
          
<!-- <!--           <div class="top-row"> --> -->
<!--             <div class="field-wrap"> -->
<!--               <label> -->
<!--                Name<span class="req">*</span> -->
<!--               </label> -->
<%--               <form:input type="text" required="required" autocomplete="off" path="name"/> --%>
<!--             </div> -->
        
<!-- <!--             <div class="field-wrap"> --> -->
<!-- <!--               <label> --> -->
<!-- <!--                 Last Name<span class="req">*</span> --> -->
<!-- <!--               </label> --> -->
<!-- <!--               <input type="text"required autocomplete="off"/> --> -->
<!-- <!--             </div> --> -->
<!-- <!--           </div> --> -->

<!--           <div class="field-wrap"> -->
<!--             <label> -->
<!--               Email Address<span class="req">*</span> -->
<!--             </label> -->
<%--             <form:input type="email" required="required" autocomplete="off" path="email"/> --%>
<!--           </div> -->
          
<!--           <div class="field-wrap"> -->
<!--             <label> -->
<!--               Set A Password<span class="req">*</span> -->
<!--             </label> -->
<%--             <form:input type="password" required="required" autocomplete="off" path="password"/> --%>
<!--           </div> -->
          
<!--            <div class="field-wrap"> -->
<!--             <label> -->
<!--               Phone Number<span class="req">*</span> -->
<!--             </label> -->
<%--             <form:input type="text" required="required" autocomplete="off" path="phone"/> --%>
<!--           </div> -->
          
<!--            <div class="field-wrap"> -->
<!--             <label> -->
<!--               Address<span class="req">*</span> -->
<!--             </label> -->
<%--             <form:input type="text" required="required" autocomplete="off" path="address"/> --%>
<!--           </div> -->
          
<!--           <div class="field-wrap"> -->
<!--             <label> -->
<!--               Country<span class="req">*</span> -->
<!--             </label> -->
<%--             <form:input type="text" required="required" autocomplete="off" path="country"/> --%>
<!--           </div> -->
<!--           <div style="margin-left:150px"> -->
<!--           <button type="submit" class="button button-large">Submit</button>&nbsp;&nbsp;&nbsp; -->
<!--           <button type="reset" class="button button-large">Cancel</button> -->
<!--           </div> -->
<%--           </form:form> --%>

<!--         </div> -->
        
<!-- <!--         <div id="login">    --> 
<!-- <!--           <h1>Welcome Back!</h1> --> 
          
<%-- <%--           <form action="<c:url value='/login'/>" method="get"> --%> 
          
<!-- <!--             <div class="field-wrap"> --> 
<!-- <!--             <label> --> -->
<!-- <!--               Email Address<span class="req">*</span> --> -->
<!-- <!--             </label> --> -->
<!-- <!--             <input type="text" name="email" required autocomplete="off"/> --> -->
<!-- <!--           </div> --> -->
          
<!-- <!--           <div class="field-wrap"> --> -->
<!-- <!--             <label> --> -->
<!-- <!--               Password<span class="req">*</span> --> -->
<!-- <!--             </label> --> -->
<!-- <!--             <input type="password" name="password" required autocomplete="off"/> --> -->
<!-- <!--           </div> --> -->
          
<!-- <!--           <p class="forgot"><a href="#">Forgot Password?</a></p> --> -->
          
<!-- <!--           <button class="button button-block">Log In</button> --> -->
          
<%-- <%--           <input type="hidden" name="${_csrf.parameterName}" --%> --%>
<%-- <%-- 			value="${_csrf.token}" /> --%> --%>
<%-- <%--           </form> --%> --%>

<!-- <!--         </div> --> -->
<!--         </div> -->
<!--       </div> -->
      
<!-- </div> /form -->
            
        </nav>
    </header> <!-- end header -->
    
    
	<c1:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="<c:url value="/logout"/>"> Logout</a>
		</h2>
	</c1:if>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="${js}/index.js"></script>

    
    
    
    
	</body>
	</html>