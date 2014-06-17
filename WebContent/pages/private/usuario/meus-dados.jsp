<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>MEUS DADOS</h3>

<div class="clear"></div>


<c:if test="${ messages != null }">
	<div class="alert2" >
		<c:forEach items="${messages}" var="msg">
					${msg}
					<br />
		</c:forEach>
	</div>
</c:if>

<form action="/futebol/EditarMeusDados" method="post">

	<jsp:useBean id="user_logged" class="br.unisul.entity.Usuario" scope="session" />
	Nome:
	<br />
	<input name="nome" value="${user_logged.nome}" />
	<br />
	<br />
	Telefone:
	<br />
	<input name="telefone" value="${user_logged.telefone}" />
	<br />
	<br />
	Mail:
	<br />
	<input value="${user_logged.mail}" disabled="disabled" />
	<input name="mail" value="${user_logged.mail}" type="hidden" />
	<br />
	<br />
	Senha:
	<br />
	<input name="senha" type="password" value="${user_logged.senha}" />
	<br />
	<br />
	<button type="submit">Editar</button>
	<br />
	<br />
	<br />
</form>
