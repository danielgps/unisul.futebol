<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.unisul.entity.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.entity.Usuario"%>
<%@page import="br.unisul.service.ReservaService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>MINHAS RESERVAS</h3>

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
    ReservaService service = new ReservaService();
	Usuario usuario = (Usuario) session.getAttribute("user_logged");

	List<Reserva> reservas = new ArrayList<Reserva>(service.list(usuario.getId()));
%>

<div class="clear"></div>

<div class="table">
	<table>
		<tbody>
			<tr class="colortop">
				<td width="125" align="left">Reserva</td>
				<td width="150" align="left">Campo</td>
				<td width="125" align="left">Usuario</td>
				<td width="125" align="left">Data Cadastro</td>
			</tr>

			<c:forEach items="<%=reservas%>" var="reserva" varStatus="varStatus">
				<tr class="${varStatus.index % 1 == 0 ? 'odd' : 'even' }">

					<td>
						<%
						    Reserva reserva = (Reserva) pageContext.getAttribute("reserva");;
												SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
												
												out.print(sp.format(reserva.getDataReserva().getTime())+ " - "+ reserva.getHoraReserva().getDescricao());
						%>
					</td>
					<td>
						<c:out value="${ reserva.campo.nome }(${reserva.campo.tipo })"></c:out>
					</td>
					<td>
						<c:out value="${ reserva.usuario.nome }"></c:out>
					</td>
					<td>
						<%
						    out.print(sp.format(reserva.getDataCadastro().getTime()));
						%>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</div>
<input class="bt_sec f-right" value="CADASTRAR RESERVA"
	onclick="location='http://localhost:8080/futebol/pages/private/reserva/save-reserva.jsp'">