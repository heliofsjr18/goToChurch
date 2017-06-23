<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Editar Congregação</title>
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
<%@ page
		import="javax.servlet.http.HttpSession, basica.Congregacao, basica.Usuario"%>
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
HttpSession se = request.getSession(true);
String obj = request.getParameter("objt");
Congregacao co = (Congregacao) se.getAttribute(obj);
se.setAttribute("obj", co);

if(se.getAttribute("usuario") != null){
	
	Usuario uLogado = (Usuario) se.getAttribute("usuario");	
	if(uLogado.getTipoUsuario().getId() == 1){
		adm = true;
	}else{
		adm = false;
	}
}
if(adm){
try{ %>
	<form action="/goto_church/EditaCongregacao" class="ui form">
		<h2 class="ui dividing header">Editar Congregação</h2>
		<div class="field">
			<label>Nome</label>
			
				<div class="field">
					<input type="text" name="nome" value="<% out.print(co.getNome());%>"
						placeholder="Nome" >
				</div>
		</div>
		<div class="field">
			<label>Coordenador</label>
			<div class="fields">
				<div class="twelve wide field">
					<input type="text" name="coordenador" value="<% out.print(co.getCoordenador());%>"
						placeholder="Coordenador">
				</div>
			</div>
		</div>
		<div class="two fields">
			<div class="field">
				<div class="field">
				   <label>Quantidade de Acentos</label>
				   <input value="<% out.print(Integer.parseInt(""+co.getQtdAssentos()));%>" type="text" name="qtdAcento"  placeholder="Quantidade de Acentos">
				 </div>
			</div>
			<div class="field">
			    <label for="climatizada">Congregação Climatizada</label>
				<div class="inline field">
				    <div class="ui toggle checkbox">
				    <%if(co.getClimatizada() == true){ %>
				      	<input id="climatizada" type="checkbox" name="climatizada" tabindex="0" class="hidden" checked>
				    <%}else{ %>
				    	<input id="climatizada" type="checkbox" name="climatizada" tabindex="0" class="hidden">
				    <%} %>
				      <label for="climatizada"></label>
				    </div>
			  	</div>
			</div>
		</div>
		<div class="ui segment">
		<h4 class="ui dividing header">Endereço</h4>
		<div class="fields">
			<div class="seven wide field">
				<label>Logradouro</label> <input type="text" name="logradouro" value="<% out.print(co.getEndereco().getLogradouro());%>"
					 placeholder="Logradouro">
			</div>
			<div class="three wide field">
				<label>Número</label> <input type="text" name="numero" maxlength="8" value="<% out.print(co.getEndereco().getNumero());%>"
					placeholder="Nº">
			</div>
			<div class="six wide field">
				<div class="two fields">
					<div class="field">
						<label>Bairro</label>
						<div class="field">
						   <input type="text" name="bairro" value="<% out.print(co.getEndereco().getBairro());%>" placeholder="Bairro">
						 </div>		
					</div>
					<div class="field">
						<label>Cidade</label>
						<input type="text" name="cidade" value="<% out.print(co.getEndereco().getCidade());%>"
							placeholder="Cidade">
					</div>
				</div>
			</div>
		</div>
		
			<div class="field">
				<div class="field">
				   <label>Complemento</label>
				   <input type="text" name="complemento"  value="<% out.println(co.getEndereco().getComplemento());%>" placeholder="Complemento">
				 </div>
			</div>
		</div>
		<input type="submit" class="ui button blue"  value="Salvar">
	</form>
	<%}catch(Exception ex){ out.println("<script>alert('"+ex.getMessage()+"');</script>");} 
}else{
	out.println("<h1><strong>Desculpe :( <br/> <br/> Acesso Indisponível! </strong></h1>");
}
	%>
	<br/>

</div>
</body>
</html>
