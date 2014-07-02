<%@page import="br.unisul.entity.Usuario"%>
<%@page import="br.unisul.entity.Perfil"%>
<%@page import="br.unisul.service.UsuarioService"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>EDITAR USUARIO</h3>

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
	String idUsuario = request.getParameter("idUsuario");
	Usuario usuario = null;
	UsuarioService service = new UsuarioService();

	if (idUsuario != null && !idUsuario.equalsIgnoreCase("")) {
		try{
			usuario = service.find(Long.valueOf(idUsuario));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>


		<%
		

		List<Perfil> perfis = service.listPerfis();
		
		if(usuario != null ){
			
	%>

	<form action="/futebol/EditarUsuarioAction" method="post">


		<input name="id" type="hidden" value="<%=usuario.getId() %>">
		Nome:
		<br />
		<input name="nome" value="<%=usuario.getNome() %>" placeholder="Nome" />
		<br />
		<br />

		Telefone:
		<br />
		<input name="telefone" value="<%=usuario.getTelefone() %>" placeholder="(##) ####-####" />
		<br />
		<br />
		Mail:
		<br />
		<input name="mail" value="<%=usuario.getMail() %>" placeholder="E-mail / Login" disabled="disabled" />
		<br />
		<br />
		Senha:
		<br />
		<input name="senha" value="<%=usuario.getSenha() %>" type="password" placeholder="Senha" />
		<br />
		<br />
		<br />
		Perfil:
		<br />
		<select name="perfil" disabled="disabled">
			<%
			
				for(Perfil perfil : perfis){
					
					if( perfil.getId().equals(usuario.getPerfil().getId()) ){
						
						out.print("<option value=\""+ perfil.getId() +"\" selected=\"selected\" >"+ perfil.getNome()+"</option>");
					}else{
						out.print("<option value=\""+ perfil.getId() +"\" >"+ perfil.getNome()+"</option>");
					}
					
					
				}
			%>
		</select>
		<br />
		<br />
		<button type="submit">Editar</button>
		<br />
		<br />
		<br />
	</form>
	<% } %>
