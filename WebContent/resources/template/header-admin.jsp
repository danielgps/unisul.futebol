<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta -->
<meta charset="UTF-8">

<!-- title -->
<title>| Golaço Esportes - Aluguel de quadras de futebol em Florianópolis</title>

<!-- links -->
<style type="text/css">
@import url("/futebol/resources/css/styles.css");

@import url("/futebol/resources/css/styles-admin.css");
@import url("/futebol/resources/css/jquery-ui-1.8.15.custom.css");
</style>
<link href="http://fonts.googleapis.com/css?family=Cabin:600italic" rel="stylesheet" type="text/css">
</head>

<body class="home-admin" style="">

	<!-- header -->
	<a name="header"></a>
	<header class="header-admin">

	<div id="header_content">
		<style>
#logo {
	background: url("http://www.golaco.com.br/img/home/logo.png") no-repeat;
	background-size: 100px;
}

#logo:hover {
	background-position: 0 0;
}
</style>
		<a id="logo" href="http://localhost:8080/futebol">Golaço Esportes &amp; Lazer</a>
		<nav id="topNav">
		<ul class="menu" id="nav">
			<li>
				<a href="javascript:void(0);"><div>Quadras</div>Locação</a>
				<ul id="menu-quadras" class="menu">
					<li id="menu-item-75" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-75">
						<a href="#">Society</a>
					</li>
					<li id="menu-item-74" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-74">
						<a href="#">Futsal</a>
					</li>
					<li id="menu-item-1014" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1014">
						<a href="#">Locação online</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="javascript:void(0);"><div>RESERVE</div>Online</a>
			</li>
			<li>
				<a href="javascript:void(0);"><div>Conheça</div>Nossos espaços</a>
				<ul id="menu-eventos" class="menu">
					<li id="menu-item-2087" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2087">
						<a href="http://www.jbesportes.com.br/site/locacao/espacos-para-churrascos-e-eventos/">Espaços para churrascos e eventos</a>
					</li>
					<li id="menu-item-2088" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2088">
						<a href="http://www.jbesportes.com.br/site/locacao/orcamento-para-eventos/">Orçamento para eventos</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="javascript:void(0);"><div>Campeonatos</div>Times</a>
			</li>
			<li>
				<a href="javascript:void(0);"><div>Escola</div>Golaço F. C.</a>
			</li>
			<li class="menu-last">
				<a href="javascript:void(0);"><div>Contato</div>Fale conosco</a>
			</li>
		</ul>
		</nav>
	</div>
	</header>

	<!-- wrapper -->
	<div id="wrapper" class="dashboard">

		<div class="clear"></div>
		Bem Vindo, ${sessionScope.user_logged.nome}
		<div class="clear"></div>

		<div class="aside-perfil">
			<ul>
				<li>
					<a href="/futebol/pages/private/home.jsp"><img src="/futebol/resources/images/ic_perfil.gif" alt="Reservas" width="15" height="20">Minhas Reservas</a>
				</li>
				<li>
					<a href="/futebol/pages/private/usuario/meus-dados.jsp"><img src="/futebol/resources/images/ic_editar.gif" alt="Alterar perfil" width="17" height="18">Meus Dados</a>
				</li>
				
				<c:if test="${sessionScope.user_logged.perfil.isAdmin()}">
					<li>
						<a href="/futebol/pages/private/usuario/list-usuario.jsp"><img src="/futebol/resources/images/ic_perfil.gif" alt="Listar Usuarios" width="17" height="18">Listar Usuarios [ADMIN]</a>
					</li>
					<li>
						<a href="/futebol/pages/private/campo/list-campo.jsp"><img src="/futebol/resources/images/ic_editar.gif" alt="Listar Usuarios" width="17" height="18">Listar Campos [ADMIN]</a>
					</li>
				
					<li>
						<a href="/futebol/pages/private/perfil/list-perfil.jsp"><img src="/futebol/resources/images/ic_editar.gif" alt="Listar Perfis" width="17" height="18">Listar Perfis [ADMIN]</a>
					</li>
				
				</c:if>
				<li>
					<a href="/futebol/Deslogar"><img src="/futebol/resources/images/bt_excluir.gif" alt="Sair do Sistema" width="18" height="18">Sair do sistema</a>
				</li>
			</ul>

		</div>
		
		
<div class="aside-content">