<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
		import="javax.servlet.http.HttpSession, java.util.List, basica.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Lista de Usuários</title>
<link rel="shortcut icon" type="image/png"
	href="images/church-map-icon-marker.png">

<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/reset.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/site.css">

<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/container.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/grid.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/header.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/image.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/menu.css">

<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/divider.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/list.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/segment.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/dropdown.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/icon.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/semantic.min.css">

<script src="Semantic/examples/assets/library/jquery.min.js"></script>
<script src="Semantic/dist/components/visibility.js"></script>
<script src="Semantic/dist/components/sidebar.js"></script>
<script src="Semantic/dist/components/transition.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="Semantic/dist/semantic.min.js"></script>

<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}

#mapa {
	height: 100vh;
	width: calc(100vw - 145px);
	position: absolute !important;
	overflow: hidden;
	top: 53px;
	left: 131px;
}
</style>
<script>
	$('.ui.checkbox').checkbox();
</script>
</head>
<body style="background-color: #f2f2f2;">
	
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="#" class="header item"> <img class="logo"
				src="images/church-map-icon-marker.png" /> GoTo!Church
			</a> <a href="index.jsp" class="item">Home</a>
		</div>
	</div>

	<div class="ui container" style="position: relative; top: 100px;">
		<%
			boolean adm = false;
			HttpSession sessaoLista = request.getSession(true);
			if(sessaoLista.getAttribute("usuario") != null){
				
				Usuario uLogado = (Usuario) sessaoLista.getAttribute("usuario");	
				if(uLogado.getTipoUsuario().getId() == 1){
					adm = true;
				}else{
					adm = false;
				}
			}
			
			if(adm){
		%>
		
		<table class="ui celled striped table">
			<thead>
				<tr>
					<th colspan="4"><i class="users icon"></i> Usuários </th>
					<th colspan="2"><a href="cadastro.jsp" class="ui button blue" style="width:100%;">Cadastrar Usuário</a></th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td><strong>NOME</strong></td>
				<td><strong>EMAIL</strong></td>
				<td><strong>CPF</strong></td>
				<td><strong>TELEFONE</strong></td>
				<td> </td>
			</tr>
		<%
			try {
				HttpSession s = request.getSession(true);
				List<Usuario> lu = (List<Usuario>) s.getAttribute("lista");
				for (int x = 0; x < lu.size(); x++) {
					//System.out.println("HTML - User "+x+" - "+lu.get(x).getNome());
					s.setAttribute("usuario"+x, lu.get(x));
		%>
		
				<tr>
					<td class="collapsing"><i class="user icon"></i><%out.println(lu.get(x).getNome()); %></td>
					<td><%out.println(lu.get(x).getEmail()); %></td>
					<td><%out.println(lu.get(x).getCpf()); %></td>
					<td><%out.println(lu.get(x).getTelefone()); %></td>
					<td class="right aligned collapsing"><a class="ui button green" href="editarUsuario.jsp?objt=<%out.println("usuario"+x);%>" ><i class="write icon"></i> Editar</a></td>
					<td class="right aligned collapsing"><a class="ui button red" href="RemoveUsuario?objeto=<%out.println("usuario"+x); %>" ><i class="remove user icon"></i> Remover</a></td>
				</tr>
			
		<%
			}
			} catch (Exception e) {
				out.println("<script>" + e.getMessage() + "</script>");
			}
		%>
		</tbody>
		</table>
		<br />
	<%}else{
		out.println("<h1><strong>Desculpe :( <br/> <br/> Acesso Indisponível! </strong></h1>");
	} %>
	
	
	</div>
</body>
</html>
