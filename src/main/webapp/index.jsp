<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gerenciador de Legendas</title>
	<link rel="stylesheet" type="text/css" href="/stylesheets/style.css" /> 
	<script type="text/javascript" src="/javascripts/jquery.min.js"></script>
	<script type="text/javascript" src="/javascripts/index.js"></script>
</head>
<body>
	<center>
		<h1>Gerenciador de Legendas</h1>
		
		<form action="upload.do" enctype="multipart/form-data" method="POST">
			Escolha a Legenda: <input type="file" name="legenda"  />
			Segundos: <input type="text" name="segundos" />
			<input type="Submit" value="Enviar Legenda" /><br>
		</form>
		
	</center>

</body>
</html>