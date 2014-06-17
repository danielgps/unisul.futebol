<%@page import="br.unisul.entity.Campo"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.service.CampoService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h3>Listagem de Campos</h3>


<div class="clear"></div>

<c:if test="${ messages != null }">
	<div style="width: 100%; min-height: 10px;">

		<c:forEach items="${messages}" var="msg">
					${msg}
					<br />
		</c:forEach>
	</div>
</c:if>
<%
	CampoService service = new CampoService();

	List<Campo> campos = service.list();
%>

<div class="table">
	<table>
		<tbody>
			<tr class="colortop">
				<td width="20" align="left">ID</td>
				<td width="100" align="left">Campo</td>
				<td width="100" align="left">Tipo</td>
				<td width="400" align="left">Descricao</td>
			</tr>

			<c:forEach items="<%=campos%>" var="campo" varStatus="varStatus">
				<tr class="${varStatus.index % 1 == 0 ? 'odd' : 'even' }">
					<td>
						<c:out value="${ campo.id }"></c:out>
					</td>
					<td>
						<c:out value="${ campo.nome }"></c:out>
					</td>
					<td>
						<c:out value="${ campo.tipo }"></c:out>
					</td>
					<td>
						<c:out value="${ campo.descricao }"></c:out>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>

<input class="bt_sec f-right" value="CADASTRAR CAMPO" onclick="location='http://localhost:8080/futebol/pages/private/campo/save-campo.jsp'">

