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
			<a href="#">Exotica</a>
			<span>Bon Apetite!!</span>
			<hr class="line-1">
			
		</div>
		<h3 align="right"><a href="Login.jsp" ><span style="color: white;">Logout</span> </a></h3>
		<div id='cssmenu' class="align-center">
					<ul>
			<li class="last"><a href='Halfmenu.jsp'><span>Add Cuisine</span></a></li>
			   <li class="last"><a href='menu.jsp'><span>Add Item</span></a></li>
			   <li class='last'><a href='Updateitem.jsp'><span>Update Item</span></a></li>
			   <li class='active'><a href='#'><span>Delete Item</span></a></li>
			   <li class='last'><a href=''><span>Item List</span></a></li>
			   <li class='last'><a href='Contactus.jsp'><span>Contacts</span></a></li>
			   <li></li>
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
										<form name="form1" id="ff" method="post" action="menu"  enctype = "multipart/form-data">
											
											    <label class="row">
											    <div class="col-1-2">
													<div class="wrap-col">
													      <span>ITEM</span>
													</div>
											    </div>
												<div class="col-1-2">
													<div class="wrap-col">
														<input type="text" name="item" id="item" placeholder="Enter item name" required="required" class="inputtype" />
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