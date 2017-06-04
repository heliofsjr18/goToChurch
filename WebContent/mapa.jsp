<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>GoTo!Church - Mapa</title>

  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/menu.css">

  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/dropdown.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/components/icon.css">
  <link rel="stylesheet" type="text/css" href="Semantic/dist/semantic.min.css">

  <link rel="shortcut icon" type="image/png" href="images/church-map-icon-marker.png">
  
  <script src="Semantic/examples/assets/library/jquery.min.js"></script>
  <script src="Semantic/dist/components/visibility.js"></script>
  <script src="Semantic/dist/components/sidebar.js"></script>
  <script src="Semantic/dist/components/transition.js"></script>
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
  #mapa{
    height: 100vh;
    width: calc(100vw - 145px);
    position: absolute !important;
    overflow: hidden;
    top: 53px;
    left: 131px;
  }
  </style>

</head>
<body style="background: #1b1c1d;">

  <div class="ui fixed inverted menu">
    <div class="ui container">
      <a href="#" class="header item">
        <img class="logo" src="images/church-map-icon-marker.png">
        GoTo!Church
      </a>
      <a href="index.jsp" class="item">Home</a>
      <div class="ui simple dropdown item">
        Opções <i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="#">Cadastrar-se</a>
          <a class="item" href="#">Entrar</a>
          <div class="divider"></div>
          <div class="header">ADMIN</div>
          <div class="item">
            <i class="dropdown icon"></i>
            Novo
            <div class="menu">
              <a class="item" href="cadastro.jsp">Usuario Adm</a>
              <a class="item" href="novaCongregacao.jsp">Congregação</a>
              <a class="item" href="novoSetor.jsp">Setor</a>
              <a class="item" href="novaArea.jsp">Área</a>
              <a class="item" href="novoObreiro.jsp">Obreiro</a>
            </div>
          </div>
          <a class="item" href="#">Opções Gerais</a>
        </div>
      </div>
    </div>
  </div>

<script>
function entrar(){
    $('.ui.modal.logar').modal('show');
  }
</script>

<div class="ui left demo vertical inverted sidebar labeled icon menu visible">
  <a class="item" href="cadastro.jsp">
    <i class="add user icon"></i>
    Cadastrar-se
  </a>
  <a class="item" onclick="entrar()">
    <i class="sign out icon"></i>
    Entrar
  </a>
  <a class="item">
    <i class="send outline icon"></i>
    Enviar Sugestão
  </a>
</div>





  <!--<div class="ui main text container">
    <h1 class="ui header">Semantic UI Fixed Template</h1>
    <p>This is a basic fixed menu template using fixed size containers.</p>
    <p>A text container is used for the main container, which is useful for single column layouts</p>
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/media-paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="Semantic/examples/assets/images/wireframe/paragraph.png">
  </div>-->
    <div class="ui main container">    
        <div class="ui search" style="z-index:1; left: 30px; top: 10px;">
            <div class="ui icon input">
              <input id="txtEndereco" class="prompt" type="text" name="txtEndereco" placeholder="Pesquisar local...">
              <i class="search icon"></i>
            </div>
            <div class="results"></div>
        </div>
 
        <div id="mapa">
        </div>
        <input type="hidden" id="txtLatitude" name="txtLatitude" />
        <input type="hidden" id="txtLongitude" name="txtLongitude" />
  </div>


<script src="js/mapa.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCH-hCASkACK5o5MLSuYUKkat8jPKsMiOg&callback=initialize"></script> 







  <!--<div class="ui inverted vertical footer segments" style="background: #1b1c1d !important; bottom: -480px; height: 20vh;">
    <div class="ui center aligned container">
      <div class="ui stackable inverted divided grid">
        <div class="three wide column">
          <h4 class="ui inverted header">Group 1</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="three wide column">
          <h4 class="ui inverted header">Group 2</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="three wide column">
          <h4 class="ui inverted header">Group 3</h4>
          <div class="ui inverted link list">
            <a href="#" class="item">Link One</a>
            <a href="#" class="item">Link Two</a>
            <a href="#" class="item">Link Three</a>
            <a href="#" class="item">Link Four</a>
          </div>
        </div>
        <div class="seven wide column">
          <h4 class="ui inverted header">GoTo!Church</h4>
          <p>&copy; Copyright - 2017</p>
        </div>
      </div>
      <div class="ui inverted section divider"></div>
      <img src="images/church-map-icon-marker.png" class="ui centered mini image">
      <div class="ui horizontal inverted small divided link list">
        <a class="item" href="#">Sobre</a>
        <a class="item" href="#">Contato</a>
        <a class="item" href="#">APP</a>
        <a class="item" href="#">Desenvolvedores</a>
      </div>
    </div>
  </div>-->
  <p style="bottom: calc(-100vh - -89vh); width: 200px; position: absolute; left: calc(50vw); color:#FFFFFF;">&copy; Copyright - 2017</p>
  
  
  <!-- modal login -->
<div class="ui modal logar">
  <i class="close icon"></i>
  <div class="header">
    GoTo!Church
  </div>

  <div class="image content">
    <div class="ui medium image">
      <img src="images/church-map-icon-marker.png">
    </div>
    <div class="description">
      <div class="ui header">Digite Suas Informações de Login</div>
      <form class="ui form">
      <div class="field">
        <label>Email</label>
        <input type="text" name="email" placeholder="Email">
      </div>
      <div class="field">
        <label>Senha</label>
        <input type="password" name="senha" placeholder="Senha">
      </div>
    </form>
    </div>
  </div>
  
  <div class="actions">
    <div class="ui black deny button">
      Cancelar
    </div>
    <div class="ui positive right labeled icon button">
      Entrar
      <i class="checkmark icon"></i>
    </div>
  </div>
</div>
</body>

</html>
