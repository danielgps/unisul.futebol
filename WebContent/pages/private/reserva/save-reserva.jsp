<%@page import="br.unisul.entity.enun.HorarioReserva"%>
<%@page import="br.unisul.entity.Campo"%>
<%@page import="java.util.List"%>
<%@page import="br.unisul.service.CampoService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

 <script>
  $(function() {
    $( "#datepicker" ).datepicker({ minDate: 0, dateFormat: "dd/mm/yy"  });
    
  });
  </script>
<h3>CADASTRO DE PARTIDA</h3>

<div class="clear"></div>

<c:if test="${ messages != null }">
	<div class="alert2">
		<c:forEach items="${messages}" var="msg">
						${msg}
						<br />
		</c:forEach>
	</div>
</c:if>

<form action="/futebol/CadastrarReservaAction" method="post">

	<%
	    CampoService service = new CampoService();

				List<Campo> campos = service.list();
	%>
	Campo:
	<br />
	<select name="campo">
		<c:forEach items="<%=campos%>" var="campo" varStatus="varStatus">
			<option value="${campo.id }">${campo.nome} [${campo.tipo}]</option>
		</c:forEach>
	</select>
	<br />
	<br />
	Dia:
	<br />
	<input name="data" type="text" id="datepicker" style="width: 100px;" />
	<br />
	<br />
	Horário:
	<br />
	<select name="hora">
		<c:forEach items="<%=HorarioReserva.values()%>" var="hora" varStatus="varStatus">
			<option value="${hora}">${hora.descricao}</option>
		</c:forEach>
	</select>
	<br />
	<br />
	<button type="submit">Cadastrar</button>
	<br />
	<br />
	<br />
</form>