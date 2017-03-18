
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Danh Gia My Pham</title>
<style type="text/css">
	body {
		background-color: #EEEEEE;
	}
</style>

<script  src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
/* ajax for post json */
$('#btnPostJson').click(function() {
	var json = {
		"name" : 'NhutNguyen',
		"age" : '27',
		"city" : "HCM"
	};
	$.ajax({
		url : "postjson",
		type : "POST",
		data : JSON.stringify(json),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(rs) {
			console.log(rs);
		}
	});
});
</script>
</head>
<body>
	<br>
	<div style="text-align: center">
		<h2>Hey guy. This is index page</h2>
		<a href="welcome">Click here to see welcome page</a>
	</div>
</body>
</html>

