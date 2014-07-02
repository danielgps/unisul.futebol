
<h2> CADASTRO DE USUÁRIO
</h2>
	<c:if test="${ messages != null }">
		<div style="width: 100%; min-height: 10px; font-weight: bold; color: red; font-size: 14px;">

			<c:forEach items="${messages}" var="msg">
					${msg}
					<br />
			</c:forEach>
		</div>
	</c:if>

	<form action="/futebol/CadastrarAction" method="post" >

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
		<button type="submit">Cadastrar</button>
		<br />
		<br />
		<br />
	</form>