<%@page import="restauranttiming.Data"%>
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
	
	<link rel="stylesheet" href="css/jqx.base.css" type="text/css" />
	<!-- <link rel="stylesheet" href="css/layout-jqgrid.css" type="text/css" /> -->
	<!-- <script src="js/jquery1111.min.js" type="text/javascript"></script> -->
	<script src="js/script.js"></script>
	<link rel="stylesheet" href="css/jquery-ui.min.css">
    <link rel="stylesheet" href="css/ui.jqgrid.min.css">
    <!-- <link rel="stylesheet" href="css/custom-grid.css"> -->
  <!--   <link rel="stylesheet" href="css/ui.jqgrid.css"> -->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="jquery.jqgrid.min.js"></script>
	<!-- <link rel="stylesheet" href="css/custom-grid.css" type="text/css"> -->
 <!-- 
 	    <link rel="stylesheet" href="css/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/jqxcore.js"></script>
    <script type="text/javascript" src="js/jqxdata.js"></script> 
    <script type="text/javascript" src="js/jqxbuttons.js"></script>
    <script type="text/javascript" src="js/jqxscrollbar.js"></script>
    <script type="text/javascript" src="js/jqxmenu.js"></script>
    <script type="text/javascript" src="js/jqxgrid.js"></script>
    <script type="text/javascript" src="js/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="js/jqxgrid.columnsresize.js"></script> 
    <script type="text/javascript" src="js/demos.js"></script> -->
 <script>
    //<![CDATA[
    $(function () {
        "use strict";
        $("#grid1").jqGrid({
            colModel: [
            	{ label: 'ITEM', name: 'name'},
                { label: 'Description', name: 'Description'},
                { label: 'Price', name: 'price' }
            ],
            data:eval('<%=Data.getdata(Integer.parseInt(session.getAttribute("cuisineid").toString())) %>'),
            iconSet: "fontAwesome",
            idPrefix: "g1_",
            loadonce: true,
            rowNum:10,
            rowList:[10,20,30],
            pager : true,
            altRows: true, 
            rownumbers: true,
            sortname: "ITEM",
            sortorder: "desc",
            caption: "ITEM LIST"
        });
       
    });
    
    //]]>
   
    </script>
	
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
				<li class="last"><a href='Halfmenu.jsp'><span>Add Cuisine</span></a></li>
			   <li class="last"><a href='menu.jsp'><span>Add Item</span></a></li>
			   <li class='last'><a href='Updateitem.jsp'><span>Update Item</span></a></li>
			   <li class='last'><a href='Deleteitem.jsp'><span>Delete Item</span></a></li>
			   <li class='active'><a href='#'><span>Item List</span></a></li>
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
									    	<table id="grid1"></table>
								       
									

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