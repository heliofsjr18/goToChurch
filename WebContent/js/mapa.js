/*function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(-8.151265, -34.919923),
        zoom:17,
    };
    var map=new google.maps.Map(document.getElementById("mapa"),mapProp);
  }*/



  //OBS Json deve ser montado com dados do DB
  var markersData = [
  {
      lat: -8.151265, 
      lng: -34.919923,
      nome: "Faculdade Unibratec",
      morada1:"Rua Diogo Cão, 125",
      morada2: "Praia da Barra",
      codPostal: "3830-772 Gafanha da Nazaré" // não colocar virgula no último item de cada marcador
   },
   {
      lat: -8.152520,
      lng: -34.920258,
      nome: "Concessionária Chevrolet Autonunes",
      morada1:"Estr. da Batalha, 1000 - Guararapes",
      morada2: "Jaboatão dos Guararapes - PE",
      codPostal: "54325-035" // não colocar virgula no último item de cada marcador
   }, 
   {
      lat: -8.154067,
      lng: -34.920172,
      nome: "Estação Monte dos Guararapes",
      morada1:"Av. Zequinha Barreto - Prazeres",
      morada2: "Jaboatão dos Guararapes - PE",
      codPostal: "54310-610" // não colocar virgula no último item de cada marcador
   }
  ];


  //Função que monta todas as posições dos marcadores do mapa
  function displayMarkers(){

     // esta variável vai definir a área de mapa a abranger e o nível do zoom
     // de acordo com as posições dos marcadores
     var bounds = new google.maps.LatLngBounds();

     // Loop que vai percorrer a informação contida em markersData 
     // para que a função createMarker possa criar os marcadores 
     for (var i = 0; i < markersData.length; i++){

        var latlng = new google.maps.LatLng(markersData[i].lat, markersData[i].lng);
        var nome = markersData[i].nome;
        var morada1 = markersData[i].morada1;
        var morada2 = markersData[i].morada2;
        var codPostal = markersData[i].codPostal;

        createMarker(latlng, nome, morada1, morada2, codPostal);//Chama a função de criar os marcadores

        // Os valores de latitude e longitude do marcador são adicionados à
        // variável bounds
        bounds.extend(latlng); 
     }

     // Depois de criados todos os marcadores,
     // a API, através da sua função fitBounds, vai redefinir o nível do zoom
     // e consequentemente a área do mapa abrangida de acordo com
     // as posições dos marcadores
     map.fitBounds(bounds);
  }

  function createMarker(latlng, nome, morada1, morada2, codPostal){
   var marker = new google.maps.Marker({
      map: map,
      position: latlng,
      title: nome,
      icon: "images/church-marker.png"
   });

   // Evento que dá instrução à API para estar alerta ao click no marcador.
   // Define o conteúdo e abre a Info Window.
   google.maps.event.addListener(marker, 'click', function() {
      
      // Variável que define a estrutura do HTML a inserir na Info Window.
      var iwContent = '<div id="iw_container">' +
                        '<div class="iw_title">' + 
                            '<span style="color:blue; text-transform: uppercase;"><i class="fire icon big"></i><b>'+nome+'</b></span>' + 
                        '</div><br />' +
                        '<div class="iw_content">' + 
                            '<i class="marker icon large"></i>'+morada1 + '' +
                            morada2 + '<br />' +
                            '<i class="tag icon large"></i>'+codPostal + '<br /><br /><br />' +
                            '<div class="ui positive right labeled icon button">' +
                              'Detalhes' + 
                              '<i class="plus icon"></i>' +
                            '</div>' +
                        '</div>'+
                      '</div>';

      /*var iwContent = '<div id="iw_container" class="ui modal logar">' +
        '<i class="close icon"></i>' +
        '<div class="header">' +
          nome +
        '</div>' +
        '<div class="image content iw_content">' +
          '<div class="ui medium image">' +
            '<img src="images/church-map-icon-marker.png">' +
          '</div>' +
          '<div class="description">' +
            '<div class="ui header">Informação</div>' +
            '<p>'+morada1+'</p>' +
            '<p>'+morada2+'</p>' +
            '<p>'+codPostal+'</p>' +
          '</div>' +
        '</div>' +
        '<div class="actions">' +
          '<div class="ui black deny button">' +
            'Cancelar' +
          '</div>' +
          '<div class="ui positive right labeled icon button">' +
            'OK' + 
            '<i class="checkmark icon"></i>' +
          '</div>' +
        '</div>' +
      '</div>';*/
      
      // O conteúdo da variável iwContent é inserido na Info Window.
      infoWindow.setContent(iwContent);

      // A Info Window é aberta com um click no marcador.
      infoWindow.open(map, marker);
   });
  }

  function initialize() {
   var mapOptions = {
      //center: new google.maps.LatLng(-8.151265, -34.919923),
      zoom: 17,
      mapTypeId: 'roadmap',
   };

   map = new google.maps.Map(document.getElementById('mapa'), mapOptions);

   // Cria a nova Info Window com referência à variável infoWindow.
   // O conteúdo da Info Window é criado na função createMarker.
   infoWindow = new google.maps.InfoWindow();

   // Evento que fecha a infoWindow com click no mapa.
   google.maps.event.addListener(map, 'click', function() {
      infoWindow.close();
   });

   // Chamada para a função que vai percorrer a informação
   // contida na variável markersData e criar os marcadores a mostrar no mapa
   displayMarkers();
  }

  /*function iniciarMapa(){
    google.maps.event.addDomListener(window, 'load', initialize);
  }*/


















  var geocoder;


  /*function myMap() {
    var mapCanvas = document.getElementById("mapa");
    var myCenter = new google.maps.LatLng(-8.151265, -34.919923); 
    var mapOptions = {center: myCenter, zoom: 17};
    var map = new google.maps.Map(mapCanvas,mapOptions);
    var marker = new google.maps.Marker({
      position: myCenter,
      icon: "images/church-marker.png"
    });
    marker.setMap(map);
  }

  $(document).ready(function () {
    
      geocoder = new google.maps.Geocoder();

      function carregarNoMapa(endereco) {
          geocoder.geocode({ 'address': endereco + ', Brasil', 'region': 'BR' }, function (results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                  if (results[0]) {
                      var latitude = results[0].geometry.location.lat();
                      var longitude = results[0].geometry.location.lng();
   
                      $('#txtEndereco').val(results[0].formatted_address);
                      $('#txtLatitude').val(latitude);
                      $('#txtLongitude').val(longitude);
   
                      var location = new google.maps.LatLng(latitude, longitude);
                      marker.setPosition(location);
                      map.setCenter(location);
                      map.setZoom(16);

                      var mapCanvas = document.getElementById("mapa");
                      var myCenter = new google.maps.LatLng(latitude, longitude); 
                      var mapOptions = {center: myCenter, zoom: 17};
                      var map = new google.maps.Map(mapCanvas,mapOptions);
                      var marker = new google.maps.Marker({
                        position: myCenter,
                        icon: "images/church-marker.png"
                      });
                      marker.setMap(map);
                  }
              }
          });

           iniciarMapa();
      }


      $("#txtEndereco").keyup(function(e){
        //console.log(e);
        if(e.which == 13){
          var pesquisa = $(this).val();
          console.log(pesquisa);
          if(pesquisa !== ""){
            //carregarNoMapa(pesquisa);
            console.log(pesquisa);
            iniciarMapa();
          }
        }
      });
  });*/
   //iniciarMapa();