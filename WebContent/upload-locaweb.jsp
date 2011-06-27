<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page language="java"
		import="org.apache.commons.fileupload.*,java.util.*,java.io.*"%>
	<%
		String caminhoTemp = "/Users/fabricioraphael/subtitle/tmp";
		String pasta = "/Users/fabricioraphael/subtitle/tmp";

		if (FileUpload.isMultipartContent(request)) {
			DiskFileUpload upload = new DiskFileUpload();
			upload.setRepositoryPath(caminhoTemp);

			try {
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {

					String nome = item.getName().toString();
					String nomeArquivo = nome.substring(nome
							.lastIndexOf("\\") + 1);
					out.write("name: " + nome + "       nameArq: "
							+ nomeArquivo);

					/* out.write("nome do arquivo: " + nomeArquivo + "<br>");
					out.write("Arquivo(s)<b> " +item.getName() +"</b> transferido(s)<br>"); */

					File arquivo = new File(pasta + nomeArquivo);
					item.write(arquivo);
				}
			} catch (FileUploadException e) {
				out.write("Não foi possível efetivar o upload do arquivo - segue a causa do erro"
						+ "<br>" + e.getMessage());
				e.printStackTrace();
			}
		}
	%>
</body>
</html>