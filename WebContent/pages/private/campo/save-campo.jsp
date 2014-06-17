
<h3>CADASTRO DE CAMPO DE FUTEBOL</h3>

<div class="clear"></div>

	<c:if test="${ messages != null }">
		<div class="alert2" >
			<c:forEach items="${messages}" var="msg">
						${msg}
						<br />
			</c:forEach>
		</div>
	</c:if>

	<form action="/futebol/CadastrarCampoAction" method="post">

		Nome:
		<br />
		<input name="nome" />
		<br />
		<br />
		Descricao:
		<br />
		<input name="descricao" />
		<br />
		<br />
		Tipo:
		<br />
		<select name="tipo">
			<option value="SOCIETY">Society</option>
			<option value="FUTSAL">Futsal</option>
		</select>
		<br />
		<br />
		<button type="submit">Cadastrar</button>
		<br />
		<br />
		<br />
	</form>