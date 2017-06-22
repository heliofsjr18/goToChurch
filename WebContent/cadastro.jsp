<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
		import="javax.servlet.http.HttpSession, java.util.List, basica.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<title>Cadastro</title>
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
</head>
<body style="background-color: #f2f2f2;">

<%
			boolean adm = false;
			HttpSession sessaoCadastro = request.getSession(true);
			if(sessaoCadastro.getAttribute("usuario") != null){
				
				Usuario uLogado = (Usuario) sessaoCadastro.getAttribute("usuario");	
				if(uLogado.getTipoUsuario().getId() == 1){
					adm = true;
				}else{
					adm = false;
				}
			}
			
		%>


	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="#" class="header item"> <img class="logo"
				src="images/church-map-icon-marker.png" /> GoTo!Church
			</a> <a href="index.jsp" class="item">Home</a>
		</div>
	</div>

<div class="ui container" style="position: relative; top: 100px;">
<%try{ %>
	<form action="/goto_church/Usuario" class="ui form">
		<h2 class="ui dividing header">Digite as informações de cadastro</h2>
		<div class="field">
			<label>Nome</label>
			<div class="two fields">
				<div class="field">
					<input type="text" name="nome"
						placeholder="Nome">
				</div>
				<div class="field">
					<input type="text" name="sobrenome"
						placeholder="Sobrenome">
				</div>
			</div>
		</div>
		<div class="field">
			
			<div class="two fields">
				<div class="field">
					<label>Data de Nascimento</label>
					<input type="text" name="dataNascimento"
						placeholder="Data de Nascimento">
				</div>
				<div class="field">
					<label>CPF</label>
					<input type="text" name="cpf"
						placeholder="CPF">
				</div>
			</div>
		</div>
		<div class="two fields">
			<div class="field">
				<div class="field">
				   <label>Email</label>
				   <input type="email" name="email" placeholder="Email">
				 </div>
			</div>
			<div class="field">
			    <label>Senha</label>
			    <input type="password" name="senha" placeholder="Senha">
			  </div>
		</div>
		<div class="two fields">
			<div class="field">
				<div class="field">
				   <label>Telefone</label>
				   <input type="text" name="telefone" placeholder="Telefone">
				 </div>
			</div>
			<div class="two fields">
				<div class="field">
					<label>Sexo</label>
					<select class="ui fluid search dropdown" name="sexo">
						<option value="M">Masculino</option>
						<option value="F">Feminio</option>
						<option value="O">Outro</option>
					</select>    
				</div>
				<%if(adm){ %>
				<div class="field">
					<label>Tipo de Usuário</label>
					<select class="ui fluid search dropdown" name="tipo">
						<option value="1">Administrador</option>
						<option value="2">Usuario Comum</option>
						<option value="3">Obreiro</option>
					</select>    
				</div>
				<%}else{ %>
				<div class="field">
					<label>Tipo de Usuário</label>
					<select class="ui fluid search dropdown" name="tipo">
						<option value="2">Usuario Comum</option>
					</select>    
				</div>
				<%} %>
			</div>
		</div>
		<div class="ui segment">
		<h4 class="ui dividing header">Endereço</h4>
		<div class="fields">
			<div class="seven wide field">
				<label>Logradouro</label> <input type="text" name="logradouro"
					 placeholder="Logradouro">
			</div>
			<div class="three wide field">
				<label>Número</label> <input type="number" name="numero" maxlength="8"
					placeholder="Nº">
			</div>
			<div class="six wide field">
				<div class="two fields">
					<div class="field">
						<label>Bairro</label>
						<div class="field">
						   <input type="text" name="bairro" placeholder="Bairro">
						 </div>		
					</div>
					<div class="field">
						<label>Cidade</label>
						<input type="text" name="cidade" 
							placeholder="Cidade">
					</div>
				</div>
			</div>
		</div>
		
			<div class="field">
				<div class="field">
				   <label>Complemento</label>
				   <input type="text" name="complemento" placeholder="Complemento">
				 </div>
			</div>
		</div>
		<!--  <div class="ui button blue" tabindex="0">Salvar</div>-->
		<input type="submit" value="Salvar" class="ui button blue">
	</form>
	<%}catch (Exception ex){
		out.println("<script>alert('e = '+"+ex.getMessage()+");</script>");	
	} %>
	<br/>

</div>
</body>
</html>
