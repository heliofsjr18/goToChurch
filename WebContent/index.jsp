<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="javax.servlet.http.HttpSession, java.util.List, basica.Usuario"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>GoTo!Church - Home</title>
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/reset.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/site.css">
<link rel="shortcut icon" type="image/png"
	href="images/church-map-icon-marker.png">
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
	href="Semantic/dist/components/dropdown.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/segment.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/button.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/list.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/icon.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/sidebar.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/components/transition.css">
<link rel="stylesheet" type="text/css"
	href="Semantic/dist/semantic.min.css">
<style type="text/css">
.hidden.menu {
	display: none;
}

.masthead.segment {
	min-height: 700px;
	padding: 1em 0em;
}

.masthead .logo.item img {
	margin-right: 1em;
}

.masthead .ui.menu .ui.button {
	margin-left: 0.5em;
}

.masthead h1.ui.header {
	margin-top: 3em;
	margin-bottom: 0em;
	font-size: 4em;
	font-weight: normal;
}

.masthead h2 {
	font-size: 1.7em;
	font-weight: normal;
}

.ui.vertical.stripe {
	padding: 8em 0em;
}

.ui.vertical.stripe h3 {
	font-size: 2em;
}

.ui.vertical.stripe .button+h3, .ui.vertical.stripe p+h3 {
	margin-top: 3em;
}

.ui.vertical.stripe .floated.image {
	clear: both;
}

.ui.vertical.stripe p {
	font-size: 1.33em;
}

.ui.vertical.stripe .horizontal.divider {
	margin: 3em 0em;
}

.quote.stripe.segment {
	padding: 0em;
}

.quote.stripe.segment .grid .column {
	padding-top: 5em;
	padding-bottom: 5em;
}

.footer.segment {
	padding: 5em 0em;
}

.secondary.pointing.menu .toc.item {
	display: none;
}

@media only screen and (max-width: 700px) {
	.ui.fixed.menu {
		display: none !important;
	}
	.secondary.pointing.menu .item, .secondary.pointing.menu .menu {
		display: none;
	}
	.secondary.pointing.menu .toc.item {
		display: block;
	}
	.masthead.segment {
		min-height: 350px;
	}
	.masthead h1.ui.header {
		font-size: 2em;
		margin-top: 1.5em;
	}
	.masthead h2 {
		margin-top: 0.5em;
		font-size: 1.5em;
	}
}
</style>

<script src="Semantic/examples/assets/library/jquery.min.js"></script>
<script src="Semantic/dist/components/visibility.js"></script>
<script src="Semantic/dist/components/sidebar.js"></script>
<script src="Semantic/dist/components/transition.js"></script>
<script src="Semantic/dist/semantic.min.js"></script>
<script>
	$(document).ready(function() {

		// fix menu when passed
		$('.masthead').visibility({
			once : false,
			onBottomPassed : function() {
				$('.fixed.menu').transition('fade in');
			},
			onBottomPassedReverse : function() {
				$('.fixed.menu').transition('fade out');
			}
		});

		// create sidebar and attach to menu open
		$('.ui.sidebar').sidebar('attach events', '.toc.item');

		//scrool suave

	});
	function comoFunciona() {
		$('html, body').animate({
			scrollTop : $("#comofunciona").offset().top
		}, 1000);
	}

	function home() {
		$('html, body').animate({
			scrollTop : 0
		}, 1000);
	}

	function entrar() {
		$('.ui.modal.logar').modal('show');
	}
</script>
</head>
<body>
	<%
		HttpSession sessao = request.getSession(true);
		sessao.setMaxInactiveInterval(60000);
		boolean adm = false;
		boolean temSessao = false;
		Usuario uLogado = null;
		if (sessao.getAttribute("usuario") != null) {
			uLogado = (Usuario) sessao.getAttribute("usuario");
			temSessao = true;
			if (uLogado.getTipoUsuario().getId() == 1) {
				adm = true;
			} else {
				adm = false;
			}
		}
	%>
	<!-- Following Menu -->
	<div class="ui large top fixed hidden menu">
		<div class="ui container">
			<a class="item" onclick="home()">Home</a> <a class="active item"
				onclick="comoFunciona()">Como Funciona</a> <a class="item">Sobre</a>
			<a class="item">Desenvolvedores</a>
			<div class="right menu" style="padding:0px;">
				<%
					if (temSessao) {
						if (adm) {
				%>
				<div class="item">
					<div class="ui simple dropdown item">
						<%
							out.println(uLogado.getNome());
						%>
						<i class="dropdown icon"></i>
						<div class="menu">
							<%
								if (adm) {
							%>
							<div class="divider"></div>
							<div class="header">ADMIN</div>
							<div class="item">
								<i class="dropdown icon"></i> Novo
								<div class="menu">
									<a class="item" href="cadastro.jsp">Usuario</a> <a class="item"
										href="novaCongregacao.jsp">Congregação</a> <a class="item"
										href="NovoSetor">Setor</a> <a class="item"
										href="NovaArea">Área</a>
								</div>
							</div>
							<div class="item">
								<i class="dropdown icon"></i> Listar
								<div class="menu">
									<a class="item" href="ListarUsuario">Usuario</a> <a class="item"
										href="ListarCongregacao">Congregação</a> <a class="item"
										href="ListarSetor">Setor</a> <a class="item" href="ListarArea">Área</a> <a
										class="item" href="ListarObreiro">Obreiro</a>
								</div>
							</div>
							<%
								}
							%>
							<a class="item" href="Logout">Sair</a>
						</div>
					</div>
				</div>
				<div class="item">
					<a class="ui primary button" href="cadastro.jsp">Cadastrar
						Usuario</a>
				</div>
				<%
					} else {
				%>
				<div class="item">
					<div class="ui simple dropdown item">
						<%
							out.println(uLogado.getNome());
						%>
						<i class="dropdown icon"></i>
						<div class="menu">
							<a class="item" href="Logout">Sair</a>
						</div>
					</div>
				</div>
				<%
					}
					} else {
				%>
				<div class="item">
					<a class="ui button" onclick="entrar()">Entrar</a>
				</div>
				<div class="item">
					<a class="ui primary button" href="cadastro.jsp">Cadastre-se</a>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>

	<!-- Sidebar Menu -->
	<div class="ui vertical inverted sidebar menu">
		<a class="active item" onclick="home()">Home</a> <a class="item"
			onclick="comoFunciona()">Como Funciona</a> <a class="item">Sobre</a>
		<a class="item">Desenvolvedores</a>
		<div class="item">
			<%
				if (temSessao) {
					if (adm) {
			%>
			<div class="item">
				<div class="ui simple dropdown item">
					<%
						out.println(uLogado.getNome());
					%>
					<i class="dropdown icon"></i>
					<div class="menu">
						<%
							if (adm) {
						%>
						<div class="divider"></div>
						<div class="header">ADMIN</div>
						<div class="item">
							<i class="dropdown icon"></i> Novo
							<div class="menu">
								<a class="item" href="cadastro.jsp">Usuario</a> <a class="item"
									href="novaCongregacao.jsp">Congregação</a> <a class="item"
									href="NovoSetor">Setor</a> <a class="item"
									href="NovaArea">Área</a>
							</div>
						</div>
						<div class="item">
							<i class="dropdown icon"></i> Listar
							<div class="menu">
								<a class="item" href="ListarUsuario">Usuario</a> <a class="item"
									href="ListarCongregacao">Congregação</a> <a class="item"
									href="ListarSetor">Setor</a> <a class="item" href="ListarArea">Área</a> <a
									class="item" href="ListarObreiro">Obreiro</a>
							</div>
						</div>
						<%
							}
						%>
						<a class="item" href="Logout">Sair</a>
					</div>
				</div>
			</div>
			<div class="item">
				<a class="ui primary button" href="cadastro.jsp">Cadastrar
					Usuario</a>
			</div>
			<%
				} else {
			%>
			<div class="item">
				<div class="ui simple dropdown item">
					<%
						out.println(uLogado.getNome());
					%>
					<i class="dropdown icon"></i>
					<div class="menu">
						<a class="item" href="Logout">Sair</a>
					</div>
				</div>
			</div>
			<%
				}
				} else {
			%>
			<div class="item">
				<a class="ui button" onclick="entrar()">Entrar</a>
			</div>
			<div class="item">
				<a class="ui primary button" href="cadastro.jsp">Cadastre-se</a>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<!--  AIzaSyCH-hCASkACK5o5MLSuYUKkat8jPKsMiOg  -->

	<!-- Page Contents -->
	<div class="pusher">
		<div class="ui inverted vertical masthead center aligned segment">

			<div class="ui container">
				<div class="ui large secondary inverted pointing menu">
					<a class="toc item"> <i class="sidebar icon"></i>
					</a> <a class="active item" onclick="home()">Home</a> <a class="item"
						onclick="comoFunciona()">Como Funciona</a> <a class="item">Sobre</a>
					<a class="item">Desenvolvedores</a>
					<div class="right item" style="padding:0px;">
						<%
							if (temSessao) {
								if (adm) {
						%>
						<div class="item" style="padding:0px;">
							<div class="ui simple dropdown item">
								<%
									out.println(uLogado.getNome());
								%>
								<i class="dropdown icon"></i>
								<div class="menu">
									<%
										if (adm) {
									%>
									<div class="divider"></div>
									<div class="header">ADMIN</div>
									<div class="item">
										<i class="dropdown icon"></i> Novo
										<div class="menu">
											<a class="item" href="cadastro.jsp">Usuario</a> <a
												class="item" href="novaCongregacao.jsp">Congregação</a> <a
												class="item" href="NovoSetor">Setor</a> <a class="item"
												href="NovaArea">Área</a>
										</div>
									</div>
									<div class="item">
										<i class="dropdown icon"></i> Listar
										<div class="menu">
											<a class="item" href="ListarUsuario">Usuario</a> <a
												class="item" href="ListarCongregacao">Congregação</a> <a
												class="item" href="ListarSetor">Setor</a> <a class="item" href="ListarArea">Área</a>
											<a class="item" href="ListarObreiro">Obreiro</a>
										</div>
									</div>
									<%
										}
									%>
									<a class="item" href="Logout">Sair</a>
								</div>
							</div>
						</div>
						<div class="item" style="padding:0px;">
							<a class="ui primary button" href="cadastro.jsp" style="top: -8px;">Cadastrar
								Usuario</a>
						</div>
						<%
							} else {
						%>
						<div class="item" style="padding:0px;">
							<div class="ui simple dropdown item">
								<%
									out.println(uLogado.getNome());
								%>
								<i class="dropdown icon"></i>
								<div class="menu">
									<a class="item" href="Logout">Sair</a>
								</div>
							</div>
						</div>
						<%
							}
							} else {
						%>
						<div class="item">
							<a class="ui button" onclick="entrar()">Entrar</a>
						</div>
						<div class="item">
							<a class="ui primary button" href="cadastro.jsp">Cadastre-se</a>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>

			<div class="ui text container">
				<h1 class="ui inverted header" style="color: #000000;">
					GoTo!Church</h1>
				<h2 style="color: #1b1c1d;">"Alegrei-me quando me disseram:
					Vamos à  casa do Senhor" (Salmo 122:1).</h2>
				<h3>
					<div class="ui search">
						<div class="ui icon input">
							<input id="cidade" class="prompt" type="text"
								placeholder="Pesquisar Cidade..."> <i class="search icon"></i>
						</div>
						<div class="results"></div>
					</div>
				</h3>
				<div class="ui huge primary button"
					onclick="window.location = 'ListarCongregacaoMapa?cidade='+$('#cidade').val();">
					Pesquisar <i class="right arrow icon"></i>
				</div>
			</div>

		</div>

		<div id="comofunciona" class="ui vertical stripe segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="eight wide column">
						<h1 class="blue ui header">Como Funciona</h1>
						<h2 class="">Simples de Usar</h2>
						<br />
						<p>
							<i class="search icon large"></i> &nbsp; &nbsp;Informe um
							Endereço
						</p>
						<p>
							<i class="marker icon big blue"></i> Encontre sua Igreja
						</p>
						<p>
							<i class="unhide icon big green"></i> Veja as informações
							disponíveis
						</p>
						<br />
						<h1 class="ui header red">Cadastre-se e acesse mais</h1>
						<p>
							<i class="empty heart icon big pink"></i>Vincule-se a uma
							congregação
						</p>
						<!-- <p>
							<i class="camera retro icon big"></i> Adicione Fotos
						</p> -->
					</div>
					<div class="six wide right floated column">
						<img src="images/ft-mapa.jpg"
							class="ui large bordered rounded image">
					</div>
				</div>
				<%if(temSessao == false){ %>
					<div class="row">
						<div class="center aligned column">
							<a class="ui huge button" href="cadastro.jsp">Cadastrar-se</a>
						</div>
					</div>
				<%} %>
			</div>
		</div>

		<div class="ui inverted vertical footer segment black"
			style="background: #1b1c1d !important;">
			<div class="ui container">
				<div
					class="ui stackable inverted divided equal height stackable grid">
					<div class="three wide column">
						<h4 class="ui inverted header">Informações</h4>
						<div class="ui inverted link list">
							<a href="#" class="item">Sobre</a> <a href="#" class="item">Contato</a>
							<a href="#" class="item">APP</a> <a href="#" class="item">Desenvolvedores</a>
						</div>
					</div>
					<div class="three wide column">
						<h4 class="ui inverted header">Igrejas</h4>
						<div class="ui inverted link list">
							<a href="#" class="item">Sobre</a> <a href="#" class="item">Direitos</a>
							<a href="#" class="item">Informações de Acesso</a>
						</div>
					</div>
					<div class="seven wide column">
						<h4 class="ui inverted header">GoTo!Church</h4>
						<p>&copy; Copyright - 2017</p>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- modal login -->

	<div class="ui modal logar">
		<i class="close icon"></i>
		<div class="header">GoTo!Church</div>

		<div class="image content">
			<div class="ui medium image">
				<img src="images/church-map-icon-marker.png">
			</div>
			<div class="description">
				<div class="ui header">Digite Suas Informações de Login</div>
				<form class="ui form">
					<div class="field">
						<label>Email</label> <input type="text" name="email"
							placeholder="Email" id="email">
					</div>
					<div class="field">
						<label>Senha</label> <input type="password" name="senha"
							placeholder="Senha" id="senha">
					</div>
				</form>
			</div>
		</div>

		<div class="actions">
			<div class="ui black deny button">Cancelar</div>
			<div class="ui positive right labeled icon button" onclick="logar()">
				Entrar <i class="checkmark icon"></i>
			</div>
			<script type="text/javascript">
				function logar() {
					window.location = 'Login?email=' + $("#email").val()
							+ '&senha=' + $("#senha").val();
				}
			</script>
		</div>
	</div>
</body>

</html>
