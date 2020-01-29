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
<body>

  <div class="wrap-body">
	<header class="zerogrid">
		<div class="logo">
			<hr class="line-1">
			<a href="#">Foodzap</a>
			<span>Bon Apetite!!</span>
			<hr class="line-1">
		</div>
		<h3 align="right"><a href="Login.jsp" ><span style="color: white;">Logout</span> </a></h3>
		<div id='cssmenu' class="align-center">
		
			<ul>
				<li class="active"><a href='#'><span>Add Cuisine</span></a></li>
			  
			   <li class='last'><a href='Contactus.jsp'><span>Contacts</span></a></li>
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
										<form name="form1" id="ff" method="post" action="halfmenu">
										<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>HOTEL NAME</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="hotelname" id="hotelname" placeholder="<%=session.getAttribute("hotelname") %>" class="inputtype"  disabled="disabled"/>
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>CUISINE</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="cuisine" id="cuisine" placeholder="Enter CUISINE name" required="required" class="inputtype" />
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>Capacity</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
													<span>Single(2 chairs per table)</span>
														<input type="text" name="single" id="single" value="0" required="required"  class="inputtype"/>
														<span>Small(4 chairs per table)</span>
														<input type="text" name="small" id="small" value="0" required="required"  class="inputtype"/>
														<span>Large(8 chairs per table)</span>
														<input type="text" name="large" id="large" value="0" required="required"  class="inputtype"/>
														<span>Family(13 chairs per table)</span>
														<input type="text" name="family" id="family" value="0" required="required"  class="inputtype"/>
														
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>VEG/NONVEG</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<select name="type" class="inputtype" ><option value="VEG">VEG</option><option value="NON-VEG">NON-VEG</option> </select>
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>AC/NONAC</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<select name="temp" class="inputtype" ><option value="NON-AC">NON-AC</option><option value="AC">AC</option> </select>
													
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>ENTER BRANCH</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
													
													<input type="text" name="branch" id="branch" placeholder="Enter branch" required="required"  class="inputtype"/>
													
													</div>
												</div>
											</label>
											<label class="row">
												<div class="col-1-2">
													<div class="wrap-col">
													      <span>BUFFET OR ALACARTE</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<select name="buffet" class="inputtype" ><option value="alacarte">Alacarte</option><option value="buffet">Buffet</option> </select>
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