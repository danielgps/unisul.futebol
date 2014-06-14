<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Usuario Result</title>
</head>
<body>
	<br />

	<jsp:useBean id="usuario" class="br.unisul.entity.Usuario" scope="request" />



	Boas Vindas,
	<%
		out.print(usuario.getNome());
	%>
	<br>
	E-mail:
	<%
		out.print(usuario.getMail());
	%>

</body>
</html>