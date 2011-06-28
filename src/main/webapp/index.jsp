<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<<<<<<< HEAD
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SubTitles-Manager</title>
</head>
<body>
	<center>
		<h1>SubTitles Manager</h1>
=======
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gerenciador de Legendas</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/stylesheets/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/javascripts/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/javascripts/jquery-spin.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/javascripts/index.js"></script>
</head>
<body>
	<center>
		<h1>Gerenciador de Legendas</h1>
		
>>>>>>> 6b217b5fb6c7213c5b838b9497825cc7f32c2615
		<form action="upload.do" enctype="multipart/form-data" method="POST">
			<div id="upload">
				Escolha a Legenda: <input type="file" name="legenda"  />
			</div>
			<div id="time">
				Segundos: <input type="text" name="segundos" id="segundos" value="0"/>
			</div>
			<div id="submit">
				<input type="Submit" value="Enviar Legenda" /><br>
			</div>
		</form>
		
	</center>
</body>
</html>