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

<form action="Tickets">
	<h2>Book your Tickets Now!!!</h2>
	Enter UserName: <input type = "text" name = "myname"><br>
	Select Date : <input type="date" name = "date"><br>
	Select Total No.of Seats:<select name="no">
	<!-- <option value="">No.of Seats</option> -->
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select><br>
	Choose your Location:
	<select name="from">
	<option value="">Choose Start</option>
		<option value="Hyderabad">Hyderabad</option>
		<option value="Bangalore">Bangalore</option>
		<option value="Chennai">Chennai</option>
		<option value="Goa">Goa</option>
		<option value="Mumbai">Mumbai</option>
		<option value="Delhi">Delhi</option>
	</select><br>
	Select Destination:
	<select name="to">
	<option value="">Destination</option>
		<option value="Hyderabad">Hyderabad</option>
		<option value="Bangalore">Bangalore</option>
		<option value="Chennai">Chennai</option>
		<option value="Goa">Goa</option>
		<option value="Mumbai">Mumbai</option>
		<option value="Delhi">Delhi</option>
	</select><br>
	<!-- VoterId number:<input type="text" name="votername">
	<select name="parties">
	<option value="">select option</option>
  <option value="bjp">BJP</option>
  <option value="congress">CONGRESS</option>
  <option value="cpi">CPI</option>
  <option value="cpm">CPM</option>
   <option value="janatadall">JANATA DALL</option>
</select> -->
<input type="submit" value="Book Tickets"><br>

</form>
<form action="Logout">
	<input type="submit" value="Logout">
</form>
</body>
</html>