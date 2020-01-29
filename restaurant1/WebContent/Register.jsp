<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS
	================================================== -->
  	<link rel="stylesheet" href="css/zerogrid.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/lightbox.css">
	
	<!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	
	<link rel="stylesheet" href="css/menu.css">
	<script src="js/jquery1111.min.js" type="text/javascript"></script>
	<script src="js/script.js"></script>
	
</head>
<script type="text/javascript">
			function getval(sel)
			{
				var hotel=sel.value;
			   
			    if( hotel.toUpperCase() === ("CUSTOMER"))
			    {
			    	
			    	$("#ownercontent").hide();
			    	document.getElementById("hotelname").required = false;
			    }
			    else if( hotel.toUpperCase() === ("OWNER"))
			    {
			    	
			    	$("#ownercontent").show();
			    	document.getElementById("hotelname").required = true;
			    	/*  document.getElementById("ownercontent").innerHTML='<object type="text/html" data="owner.jsp" ></object>'; */
			    }
			    
			}
			
			function hideownercontent()
			{
				$("#ownercontent").hide();
				document.getElementById("hotelname").required = false;
			}
	</script>

<body onload="hideownercontent();">

  <div class="wrap-body">
	<header class="zerogrid">
		<div class="logo">
			<hr class="line-1">
			<a href="#">Foodzap</a>
			<span>Bon Apetite!!</span>
			<hr class="line-1">
		</div>
		<div id='cssmenu' class="align-center">
			<ul>
			   <li class="last"><a href='Login.jsp'><span>Login</span></a></li>
			   <li class='active'><a href='Register.jsp'><span>Register</span></a></li>
			   
			</ul>
<!-- <marquee direction="right"><h1> Welcome to the Login Page!!!</h1></marquee>
 -->
<section id="container">
			<div class="wrap-container clearfix">
				<div id="main-content">
					<div class="wrap-content zerogrid ">
						<article class="background-gray">
							<div class="art-header">
								
								<h3 style="color: red;"><%	String mess=(String)request.getParameter("message");
	if(mess != null)	
		out.print(mess);
%></h3>
							</div>
							<div class="art-content">
								<div class="row">
									<div id="contact_form">
										<form name="form1" id="ff" method="post" action="hello1">
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>NAME</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="name" id="name" placeholder="Enter User name" required="required" class="inputtype" />
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>ADDRESS</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="address" id="address" placeholder="Enter address" required="required" class="inputtype" />
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>PINCODE</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="pincode" id="pincode" placeholder="Enter pincode" required="required"  class="inputtype"/>
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>MOBILE NO</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="mobile" id="mobile" placeholder="Enter mobile" required="required" class="inputtype" />
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>PASSWORD</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="password" name="password" id="password" placeholder="Enter password" required="required" class="inputtype"/>
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>EMAIL</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="email" name="email" id="email" placeholder="Enter email" required="required" class="inputtype" />
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>CATAGORY</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<select name="catagory" id="catagory" class="inputtype" onchange="getval(this);"><option value="default">select catagory</option><option value="Customer">customer</option><option value="Owner">owner</option> </select>
													</div>
												</div>
											</label>
											<label class="row" id="ownercontent">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>Hotel name</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="hotelname" id="hotelname" placeholder="Enter hotel name" class="inputtype" />
													</div>
												</div>
											</label>
											
											<center><input class="sendButton" type="submit" name="Submit" value="Submit"></center>
										</form>
									</div>
								</div>
							</div>
						</article>
					</div>
				</div>
			</div>
		</section>
		</div>
		</header>
		</div>
		
</body>
</html>