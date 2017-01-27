<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
function getAllUsers() {
	$.ajax({
		url: '<c:url value="/users" />',
		dataType: 'json',
		success: function(data) {
			for (var i=0; i<data.length; i++) {
				$('body > ol').append('<li>'+data[i].username+'</li>')
			}
		}
		
	});	
}
function sendEmail() {
	alert("We are in email send method");
	$.ajax({
		url: '<c:url value="/sendMail" />',
		method: 'POST',
		data: {'email' : $('body > div > input').val(), 'message' : $('body > div > textarea').val()},
		success: function(data) {
			alert(data);
		}
	});
}

</script>
</head>
<body>

<button onclick="getAllUsers()">Show all users</button>
<ol></ol>
<div style="width: 245px; border: 2px navy ridge; margin: auto">
	<input type="text" placeholder="Enter email address" />
	<textarea rows="14" cols="33" placeholder="Enter Message here"></textarea>
	<button onclick="sendEmail()" style="width: 100%">Send</button>
</div>
</body>
</html>