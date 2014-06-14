<%@page import="br.unisul.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.service.UsuarioService"%>
<%@page import="br.unisul.util.EntityManagerUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2>Listagem de Usuario</h2>

	<%
		
		UsuarioService service = new UsuarioService();
		
		List<Usuario> usuarios = service.list();

		for(Usuario usuario : usuarios){
			
			out.println(usuario.getNome() + "(<b>" + usuario.getLogin() + "</b>)<br>");
		}
	%>

</body>
</html>