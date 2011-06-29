<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Gerenciador de Legendas</title>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO8859-1" >
	<meta name="description" content="Aplicação que tem como objetivo ajustar o tempo das legendas no formato .srt" />
	<meta name="keywords" content="Corrigir tempo legenda, legenda, tempo, srt, time, subtitles, movies, filmes, seriados" />

	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-spin.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>
</head>
<body>
	<div class="box">
		<a href="http://github.com/hodrigohamalho/remove-link-guard">
			<img id="forkme" src="<%=request.getContextPath()%>/images/forkme_left_grey.png" alt="Fork me on GitHub" />
		</a>
		
		<div id="msg_error" style="display: none"></div>
		<div id="msg_notice" style="display: none"></div>
		
		<div id="inputs">		
			<h1>Gerenciador de Legendas</h1>
			
			<form action="upload.do" enctype="multipart/form-data" method="POST">
				<div id="upload">
					Escolha a Legenda: <input type="file" name="legenda" />
				</div>
				<div id="time">
					Tempo a ser acrescido ou subtraido da legenda: <input type="text" name="segundos" id="segundos" value="0" size="2"/> <em>Segundos</em>
				</div>
				<div id="submit">
					<input type="Submit" value="Enviar Legenda" /><br>
				</div>
			</form>
		</div>
	</div>
		
</body>
</html>