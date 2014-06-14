<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>


	<c:if test="${ errorMessages != null }">
		<c:forEach items="${errorMessages}" var="mensagem">
					${mensagem}
					<br/>
		</c:forEach>
	</c:if>

	<form action="/futebol/CadastrarAction" method="post" style="height: 400px; width: 500px; border: 1px dotted black;">

		Nome:
		<br />
		<input name="nome" />
		<br />
		<br />
		Mail:
		<br />
		<input name="mail" />
		<br />
		<br />
		Login:
		<br />
		<input name="login" />
		<br />
		<br />
		Senha:
		<br />
		<input name="senha" />
		<br />
		<br />
		<button type="submit">Cadastrar</button>
		<br />
		<br />
		<br />
	</form>

</body>
</html>