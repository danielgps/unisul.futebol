<%@page import="br.unisul.entity.Perfil"%>
<%@page import="br.unisul.service.UsuarioService"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.service.CampoService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h3>Listagem de Perfis</h3>


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

	List<Perfil> perfis = service.listPerfis();
%>

<div class="table">
	<table>
		<tbody>
			<tr class="colortop">
				<td width="20" align="left">ID</td>
				<td width="100" align="left">Nome</td>
			</tr>

			<c:forEach items="<%=perfis%>" var="perfil" varStatus="varStatus">
				<tr class="${varStatus.index % 1 == 0 ? 'odd' : 'even' }">
					<td>
						<c:out value="${ perfil.id }"></c:out>
					</td>
					<td>
						<c:out value="${ perfil.nome }"></c:out>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>

<input class="bt_sec f-right" value="CADASTRAR PERFIL" onclick="location='http://localhost:8080/futebol/pages/private/perfil/save-perfil.jsp'">

