<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>

$(document).ready(function(){
	
	$('#roomType').change(function(){
		var value= $(this).find(':selected').val();
		var rates = 0.0;
		var roomLocation="1st floor";
		var noOfBeds =3;
		if(value=='deluxe'){
			rates=100;
			noOfBeds = 3;
			roomLocation="1st floor";
		}
		else if(value=='single')
			{
			rates=80;
			noOfBeds = 1;
			roomLocation="2nd floor";
			}
		else{
			noOfBeds = 2;
			roomLocation="10th floor";
			rates=90;
		}
			
		
		$('#rates').val(rates);
		$('#roomLocation').val(roomLocation);
		$('#noOfBeds').val(noOfBeds);
		
	});
	
	
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output =(day<10 ? '0' : '') + day + '/' +
	    (month<10 ? '0' : '') + month + '/' +
	    
	    d.getFullYear();
	
	
	$('#reservationDate').val(output);
	
})
</script>
<title>Hotel</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="reservation"
		action="saveReservation" method="post">
		<h1 align="center">Enter Hotel and Reservation details</h1>
		<table align="center">
			<tr>
				<td><form:label path="rooms.hotels.hotelId">Hotels</form:label></td>
				<td><form:select path="rooms.hotels.hotelId"
						name="rooms.hotels.hotelId" id="hotelId">
						<c:forEach var="hotels" items="${Hotellst}">
							<form:option value="${hotels.hotelId}">${hotels.hotelId}-${hotels.city}-${hotels.state}</form:option>
						</c:forEach>

					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="checkin">Checkin Date</form:label></td>
				<td><form:input path="checkin" name="checkin" type="text"
						placeholder="dd/mm/yyyy" id="checkin" /></td>
			</tr>

			<tr>
				<td><form:label path="checkout">Checkout Date</form:label></td>
				<td><form:input path="checkout" name="checkout" type="text"
						placeholder="dd/mm/yyyy" id="checkout" /></td>
			</tr>
			<tr>
				<td><form:label path="status">Status</form:label></td>
				<td><form:input path="status" name="status" type="text"
						placeholder="Status" value="open" readOnly="readOnly" id="status" />
				</td>
			</tr>
			<tr>
				<td><form:label path="noOfGuests">No Of Guest</form:label></td>
				<td><form:input path="noOfGuests" name="noOfGuests" type="number"
						placeholder="noOfGuests"  id="noOfGuests" />
				</td>
			</tr>
			<tr>
				<td><form:label path="reservationDate" >Reservation Date</form:label></td>
				<td><form:input path="reservationDate" readOnly="readOnly" name="reservationDate" placeholder="dd/mm/yyyy" type="text"
						  id="reservationDate" />
				</td>
			</tr>
	
			</table>
			<h1 align="center">Enter room details</h1>
			
			<table align="center">
			
			<tr>
				<td><form:label path="rooms.roomType">Room Type</form:label></td>
				<td><form:select path="rooms.roomType" name="rooms.roomType" id="roomType" >
				<form:option value="deluxe">Deluxe</form:option>
				<form:option value="single">Single</form:option>
				<form:option value="double">Double</form:option>
				</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="rooms.rates">Room Rate</form:label></td>
				<td><form:input path="rooms.rates" value="100" readOnly="readOnly" id="rates"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="rooms.roomLocation">Room location</form:label></td>
				<td><form:input path="rooms.roomLocation" value="1st floor" readOnly="readOnly" id="roomLocation"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="rooms.noOfBeds">Room Rate</form:label></td>
				<td><form:input path="rooms.noOfBeds" value="3" readOnly="noOfBeds" id="noOfBeds"/>
				</td>
			</tr>
			</table>
			<h1 align="center">Enter Customer details</h1>
			
			<table align="center">
			
			<tr>
				<td><form:label path="customer.firstname">First Name</form:label></td>
				<td><form:input path="customer.firstname"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="customer.lastname">Last Name</form:label></td>
				<td><form:input path="customer.lastname"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="customer.phone">Phone</form:label></td>
				<td><form:input maxlength="10" path="rooms.customer.phone"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="customer.city">City</form:label></td>
				<td><form:input path="customer.city"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="customer.state">State</form:label></td>
				<td><form:input path="customer.state"/>
				</td>
			</tr>
			<tr>
				<td><form:label path="customer.zipcode">Zipcode</form:label></td>
				<td><form:input path="customer.zipcode"/>
				</td>
			</tr>
			</table>
			<%-- <tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname"
						id="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" maxlength="10" type="number"
						placeholder="Enter phone number" name="phone" id="phone" /></td>
			</tr>
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:select path="role">
						<form:option value="visitor" selected="selected">Visitor</form:option>
						<form:option value="staff" disabled="true">Staff</form:option>
						<form:option value="admin" disabled="true">Admin</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr> --%>
			
			<input type="submit" value="Save Details">
		
	</form:form>

</body>
</html>