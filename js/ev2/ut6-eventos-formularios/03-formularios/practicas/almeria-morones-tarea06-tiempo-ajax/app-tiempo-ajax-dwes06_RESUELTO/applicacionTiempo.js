// ************************
// CARGAR DOCUMENTO
// ************************
// Lo primero es esperar que todo el DOM este cargado antes de empezar
$(document).ready(function () {
  // ************************
  // VARIABLES GLOBALES
  // ************************
  //Usamos una variable para guardar todas las ciudades
  //que encontremos cuando hagamos la búsqueda
  let ciudadesEncontradas = [];
  //guardamos en una variable la key de Tomorrow.io
  const KEY = "IOYTIUsF9rB4cQq1rRA8WUhI8zMDc0WH";

  // ************
  // FUNCIONES
  // *********

  // Creamos una función para buscar las ciudades (USAMOS ASYNC)
  /**
   * El usuario escribe en el campo buscando una ciudad+
   *    Validamos el campo
   *        El campo está vacio
   *            Mostramos un error
   *        El campo no tiene la longitud necesaria
   *            Mostramos un error
   *    Si el campo es valido
   *        Mostramos el loader
   *        Construimos la url
   *        Realizmaos la petición al servidor y esperamos la respuesta
   */

  async function busquedaCiudades() {
    //Guaramods el valor introducido por el usuario
    let localidad = $("#localidad").val().trim();
    // validamos el valor del usuario; si existe error lo mostramos
    // en su div correspondiente

    //Limpiamos los errores
    $("#error-busqueda").addClass("ocultar");
    $("#error-busqueda").text("");

    //Validamos que no esté vacio
    if (localidad === "") {
      $("#error-busqueda").text("El campo de búsqueda no puede estar vacío");
      $("#error-busqueda").removeClass("ocultar");
      $("#error-busqueda").css("color", "red");

      //Validamos que tenga una longitudad mínima
    } else if (localidad.length < 3) {
      $("#error-busqueda").text("Escribe al menos 3 caracteres para buscar");
      $("#error-busqueda").removeClass("ocultar");
      $("#error-busqueda").css("color", "red");
    } else {
      // Mostramos loader que tenemos guardado en el proyecto removiendo su clase oculta
      $("#loader-ciudades").removeClass("ocultar");
      //Ocultamos la lista de ciudades y los errores
      $("#lista-ciudades").addClass("ocultar");
      $("#error-ciudades").addClass("ocultar");

      // Construirmos la url de la api de geolocalización GEODB
      //Usamos la uri de granada que se ha puesto en el enunciado como ejemplo
      //ampliamos el numero de resultados a 10
      let url = `https://geodb-free-service.wirefreethought.com/v1/geo/places?limit=10&offset=0&types=CITY&namePrefix=${encodeURIComponent(localidad)}&languageCode=es`;

      // Usamos la API FETCH para hacer peticiciones al servidor (con async/await)
      try {
        // Hacemos la petición y esperamos la respuesta
        let respuesta = await fetch(url);

        // Comprobamos si la respuesta es exitosa (status 200-299)
        if (!respuesta.ok) {
          //si la respuesta es mala (ejemplo 404) lanzamos un error
          throw new Error("Se ha producido un error en la API de la ciudad" + respuesta.status);
        }

        //Si ha ido bien convertimos la respuesta a JSON
        //el listado de ciudades que nos ha devuelto la api en forma de array
        let resJson = await respuesta.json();

        //Guardamos los datos en la variable global
        ciudadesEncontradas = resJson.data;

        //Ocultamos el spinner porque ya ha terminado el tiempo de espera
        $("#loader-ciudades").addClass("ocultar");

        //Si no se ha localizado ninguna ciudad
        if (ciudadesEncontradas.length === 0) {
          //añadimos un error.
          $("#error-ciudades").text("No se encontraron poblaciones").removeClass("ocultar");
        } else {
          mostrarListaCiudades(ciudadesEncontradas);
        }

        //si hay algun error que no se haya pdido controlar.
      } catch (error) {
        console.error("Error:", error);
        $("#loader-ciudades").addClass("ocultar");
        $("#error-ciudades").text("Error inesperado en el API GEO");
        $("#error-ciudades").removeClass("ocultar");
        $("#error-ciudades").css("color", "red");
      }
    }
  }

  //Creamos una función para mostrar las ciudades
  /*
   *Limpiamos la lista de ciudades anterior (se limpia siempre aunque sea la primera vez)
   *Recorremos el array de objetos json que hemos recibido
   *    una opcion hubiera sido validar aqui que la lista recibida no estuviera vacia
   *Extraemos los datos que nos interesa
   *Creamos la lista y lo añadimos a la lista
   *Añadimos un evento a cada elemento de la lista
   *
   */

  function mostrarListaCiudades(ciudadesEncontradas) {
    // Limpiamos la lista previa de ciudaes
    $("#lista-ciudades").empty();
    //Hacemos que aparezca el listado de las ciudades que permanecía oculto
    $("#lista-ciudades").removeClass("ocultar");

    // usamos un foreach para recorrer las ciudades
    for (let i = 0; i < ciudadesEncontradas.length; i++) {
      let ciudad = ciudadesEncontradas[i];

      // Guardamos los datos que nos interesa
      let nombreCiudad = ciudad.name;
      let pais = ciudad.country;
      let codigoPais = ciudad.countryCode;
      let region = ciudad.region;
      let poblacion = ciudad.population;
      let latitud = ciudad.latitude;
      let longitud = ciudad.longitude;

      // Creamos la lista de las ciudades
      let texto = `${nombreCiudad}, ${pais}`;
      //lo convertimos a un objeto jquery
      let $li = $(`<li>${texto}</li>`);

      //añadimos cada elemento li a lista ul
      $("#lista-ciudades").append($li);

      //añadimos un evento de click a cada elemento de la lista
      $li.on("click", function () {
        seleccionarCiudad(latitud, longitud, nombreCiudad, pais, codigoPais, region, poblacion);
      });
    }
  }

  //Creamos una funcion para seleccionar cada ciudad
  /*
   *Le pasamos a la función todos los parámetros que hemos guardado antes
   *En el contenedor derecho mostramos
   *     el nombre del país
   *     el nombre de la ciudad
   *     el nombre de la región
   *     la población de la ciudad
   * Borramos el mensaje inicial
   * Mostramos la clase que oculta la info de la ciudad
   */

  function seleccionarCiudad(latitud, longitud, nombreCiudad, pais, codigoPais, region, poblacion) {
    // Mostramos los datos de la ciudad
    $("#nombre-ciudad").text(nombreCiudad);
    $("#pais-ciudad").text(pais);
    $("#region-ciudad").text(region);
    $("#poblacion-ciudad").text(poblacion.toLocaleString("es-ES"));

    //Removemos las clases que oculta elementos del html
    $("#mensaje-seleccion").addClass("ocultar");
    $("#info-completa").removeClass("ocultar");

    // Llamamos a las funciones del tiempo
    cargarTiempoActual(latitud, longitud, nombreCiudad, codigoPais);
    cargarPrevision(latitud, longitud, nombreCiudad, codigoPais);
  }

  //Creamos una funcion para cargar el tiempo actual

  function cargarTiempoActual(latitud, longitud, nombreCiudad, codigoPais) {
    // Limpiamos los errores anteriores
    $("#error-tiempo").addClass("ocultar");
    $("#error-tiempo").text("");

    // Carga el loader del tiempo
    $("#loader-tiempo").removeClass("ocultar");

    // Construir la URL de la API (usamos el ejemplo de granada)
    //la uri la hacemos en unidades métricas
    let nombreCodigo = `${nombreCiudad} ${codigoPais}`;
    let url = `https://api.tomorrow.io/v4/weather/realtime?location=${encodeURIComponent(nombreCodigo)}&units=metric&apikey=${KEY}`;

    // Usamos el método ajax de la libreia jQuery

    $.ajax({
      url: url, //la dirección a donde vamos hacer la consulta
      method: "GET", //el metodo que vamos a usar (get porque la información va en la url)
      success: function (respuesta) {
        //si la respuesta es exitosa
        //ocultamos el loader
        $("#loader-tiempo").addClass("ocultar");

        /**
         * recibimos los siguientes datos
         * 'data'{
         *  'values'{
         *      'temperature'
         *      'weatherCode'
         *      'rainIntensity'
         *      '.......'
         * }
         * }
         */

        //accedemos a los datos
        let datos = respuesta.data;
        //accedemos a los valores
        let valores = datos.values;
        //accedemos a cada valor que necesitamos
        let temperatura = Math.round(valores.temperature); // la temperatura
        let humedad = Math.round(valores.humidity); //la humedad
        let codigoTiempo = valores.weatherCode; //el codigo del tiempo
        let lluviaIntensidad = valores.rainIntensity; //la intensidad de la lluvia

        // Mostrar temperatura (redondeada)
        $("#temp-actual").text(temperatura);

        // Mostrar icono según weatherCode
        $("#icono-actual").html(cargarIconos(codigoTiempo));

        // Mostrar humedad
        $("#humedad-actual").text(humedad);

        // Mostrar si llueve o no
        if (lluviaIntensidad > 0) {
          $("#lluvia-actual").text(`Sí (${lluviaIntensidad} mm/h)`);
        } else {
          $("#lluvia-actual").text("No");
        }
      },
      //Mostramos un error genérico en caso de que algo falle
      error: function () {
        $("#loader-tiempo").addClass("ocultar");
        $("#error-tiempo").text("Error al cargar el tiempo actual");
        $("#error-tiempo").removeClass("ocultar");
      },
    });
  }

  //Creamos una funcion para cargar los iconos
  //renombramos los archivos guardados en la carpeta clima
  //Crear la ruta base
  //crear la ruta para cada icono específico
  //devolver un icono por defecto si falla.

  function cargarIconos(codigoTiempo) {
    let rutaBase = "../iconos/clima/";
    let rutaIcono = `${rutaBase}${codigoTiempo}.png`;
    let rutaPorDefecto = `${rutaBase}iconopordefecto.png`;

    let imagen = `<img src="${rutaIcono}" 
                        alt="Icono del tiempo" 
                        onerror="this.src='${rutaPorDefecto}'">`;

    return imagen;
  }

  //Funcion para cargar la primera y ultima prevision

  function cargarPrevision(latitud, longitud, nombreCiudad, codigoPais) {
    // Limpiamos los posibles errores anteriores
    $("#error-tiempo").addClass("ocultar");
    $("#error-tiempo").text("");

    // Mostramos el loader del tiempo
    $("#loader-tiempo").removeClass("ocultar");

    // Construir la URL de la API de previsión
    let localizacion = `${latitud},${longitud}`;
    //tal y como viene en la tarea, el endpoint debe ser forescat
    let url = `https://api.tomorrow.io/v4/weather/forecast?location=${localizacion}&units=metric&apikey=${KEY}`;

    //En este caso usamos axios al cual le pasamos la url como parámetro
    axios
      .get(url)
      //realizamos la petición (es nuestro objeto principal)
      .then(function (respuesta) {
        // ocultamos el loader.
        $("#loader-tiempo").addClass("ocultar");

        // accedemos al timelines (aqui esta minutely, hourly y daily)
        let previsiones = respuesta.data.timelines;

        // nos guardamos minutely (es un array)
        let previsionesPorMinuto = previsiones.minutely;

        //comprobamos que existe y que al menos tiene 2 previsiones
        if (previsionesPorMinuto && previsionesPorMinuto.length >= 2) {
          // Buscamos la primera previsión
          let primera = previsionesPorMinuto[0];
          //De aqui extraemos la fecha, el codigo, la intensidad de la lluvia y el tipo de lluvia
          let fechaPrimera = primera.time;
          let codigoTiempoPrimera = primera.values.weatherCode;
          let lluviaPrimera = primera.values.rainIntensity;
          let tipoLLuviaPrimera = primera.values.precipitationType;

          // Buscamos la última previsión
          let ultima = previsionesPorMinuto[previsionesPorMinuto.length - 1];
          //De aqui extraemos la fecha, el codigo y la intensidad de la lluvia
          let fechaUltima = ultima.time;
          let codigoTiempoUltima = ultima.values.weatherCode;
          let lluviaUltima = ultima.values.rainIntensity;
          let tipoLLuviaUltima = ultima.values.precipitationType;

          // Mostramos las fechas
          $("#fecha-primera").text(new Date(fechaPrimera).toLocaleString("es-ES"));
          $("#fecha-ultima").text(new Date(fechaUltima).toLocaleString("es-ES"));

          // Cargamos los iconos
          $("#icono-primera").html(cargarIconos(codigoTiempoPrimera));
          $("#icono-ultima").html(cargarIconos(codigoTiempoUltima));

          // Mostramos si llueve o no
          if (lluviaPrimera > 0) {
            $("#lluvia-primera").text(`Sí (${lluviaPrimera} mm/h)`);
          } else {
            $("#lluvia-primera").text("No");
          }

          if (lluviaUltima > 0) {
            $("#lluvia-ultima").text(`Sí (${lluviaUltima} mm/h)`);
          } else {
            $("#lluvia-ultima").text("No");
          }
        } else {
          $("#fecha-primera").text("No disponible");
          $("#fecha-ultima").text("No disponible");
          $("#icono-primera").html("❓");
          $("#icono-ultima").html("❓");
          $("#lluvia-primera").text("No disponible");
          $("#lluvia-ultima").text("No disponible");
        }
      })
      .catch(function (error) {
        console.error("Error en Axios:", error);
        $("#loader-tiempo").addClass("ocultar");
        $("#error-tiempo").text("Error al cargar la previsión del tiempo");
        $("#error-tiempo").removeClass("ocultar");

        // Limpiar datos de previsión
        $("#fecha-primera").text("Error");
        $("#fecha-ultima").text("Error");
        $("#icono-primera").html("❓");
        $("#icono-ultima").html("❓");
        $("#lluvia-primera").text("Error");
        $("#lluvia-ultima").text("Error");
      });
  }

  //Aquí asignamos los eventos
  $("#btn-buscar").on("click", function (evt) {
    evt.preventDefault();
    busquedaCiudades();
  });

  //Asignamos un estado inicial de ocultamiento
  $("#loader-ciudades").addClass("ocultar");
  $("#error-ciudades").addClass("ocultar");
  $("#lista-ciudades").removeClass("ocultar");
});
