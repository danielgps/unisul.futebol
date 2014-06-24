
<h3>CADASTRO DE CAMPO DE FUTEBOL</h3>

<div class="clear"></div>

<c:if test="${ messages != null }">
	<div class="alert2">
		<c:forEach items="${messages}" var="msg">
						${msg}
						<br />
		</c:forEach>
	</div>
</c:if>

<form action="/futebol/CadastrarPerfilAction" method="post">

	Nome:
	<br />
	<input name="nome" />
	<br />
	<br />
	<button type="submit">Cadastrar</button>
	<br />
	<br />
	<br />
</form>