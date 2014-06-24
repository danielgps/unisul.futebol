<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.unisul.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.service.UsuarioService"%>
<%@page import="br.unisul.util.EntityManagerUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Listagem de Usuario</h3>

<div class="clear"></div>

<c:if test="${ messages != null }">
	<div class="alert2">
		<c:forEach items="${messages}" var="msg">
					${msg}
					<br />
		</c:forEach>
	</div>
</c:if>

<%
	UsuarioService service = new UsuarioService();

	List<Usuario> usuarios = service.list();
%>

<div class="table">
	<table>
		<tbody>
			<tr class="colortop">
				<td width="20" align="left">ID</td>
				<td width="125" align="left">Nome</td>
				<td width="150" align="left">E-mail</td>
				<td width="50" align="left">Telefone</td>
				<td width="125" align="left">Data Cadastro</td>
				<td width="50" align="left">Perfil</td>
			</tr>

			<c:forEach items="<%=usuarios%>" var="usuario" varStatus="varStatus">
				<tr class="${varStatus.index % 1 == 0 ? 'odd' : 'even' }">
					<td>
						<c:out value="${ usuario.id }"></c:out>
					</td>
					<td>
						<c:out value="${ usuario.nome }"></c:out>
					</td>
					<td>
						<c:out value="${ usuario.mail }"></c:out>
					</td>
					<td>
						<c:out value="${ usuario.telefone }"></c:out>
					</td>
					<td>
						<%
							Usuario usuario = (Usuario) pageContext.getAttribute("usuario");
								SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");

								out.print(sp.format(usuario.getDataCadastro().getTime()));
						%>
					</td>
					<td>
						<c:out value="${ usuario.perfil.nome }"></c:out>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>

<input class="bt_sec f-right" value="CADASTRAR USUÁRIO" onclick="location='http://localhost:8080/futebol/pages/private/usuario/save-usuario.jsp'">