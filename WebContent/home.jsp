<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%> --%>
welcome  ${username}

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Book Lending Site</h1>
  
</div>

<nav class="navbar navbar-inverse">

	
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">DBS Library</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Computer Science</a></li>
          <li><a href="#">Electronics</a></li>
          <li><a href="#">Mechanical</a></li>
        </ul>
      </li>
   </ul>
    <form action="Searching" method="get"class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name = "book" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <form action="addbook.jsp" method="get"class="form-inline my-2 my-lg-0">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Add Book</button>
    </form>