<%@page import="br.unisul.entity.Perfil"%>
<%@page import="br.unisul.service.UsuarioService"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>MEUS DADOS</h3>

<div class="clear"></div>


<c:if test="${ messages != null }">
	<div class="alert2">
		<c:forEach items="${messages}" var="msg">
					${msg}
					<br />
		</c:forEach>
	</div>
</c:if>

<form action="/futebol/CadastrarUsuarioAdminAction" method="post">

	<%
	    UsuarioService service = new UsuarioService();

				List<Perfil> perfis = service.listPerfis();
	%>


	Nome:
	<br />
	<input name="nome" placeholder="Nome" />
	<br />
	<br />

	Telefone:
	<br />
	<input name="telefone" placeholder="(##) ####-####" />
	<br />
	<br />
	Mail:
	<br />
	<input name="mail" placeholder="E-mail / Login" />
	<br />
	<br />
	Senha:
	<br />
	<input name="senha" type="password" placeholder="Senha" />
	<br />
	<br />
	<br />
	Perfil:
	<br />
	<select name="perfil">
		<c:forEach items="<%=perfis%>" var="perfil" varStatus="varStatus">
			<option value="${perfil.id }">${perfil.nome}</option>
		</c:forEach>
	</select>
	<br />
	<br />
	<button type="submit">Cadastrar</button>
	<br />
	<br />
	<br />
</form>
