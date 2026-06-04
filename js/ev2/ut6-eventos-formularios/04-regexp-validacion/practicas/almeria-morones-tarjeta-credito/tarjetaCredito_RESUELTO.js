document.addEventListener("DOMContentLoaded", construirFormulario);

/***********************
 * VARIABLES GLOBALES
 ************************/
let errores = document.getElementById("errores");
let salida = document.getElementById("salida");
let textoError = "";
let textoSalida = "";
let formulario;

//Creamos una función que nos permitirá construir la estructura del formulario
function construirFormulario() {
  /***********************
   * CREACIÓN FORMULARIO
   ************************/
  formulario = document.createElement("form");
  formulario.id = "formulario-tarjeta";
  formulario.classList.add("formulario");
  document.body.appendChild(formulario);

  /**************************
   * CONTENEDOR NOMBRE-APELLIDO
   ***************************/
  let contenedorNombre = document.createElement("div");
  contenedorNombre.id = "contenedor-nombre";
  contenedorNombre.classList.add("contenedor-nombre");
  formulario.appendChild(contenedorNombre);

  let etiquetaNombre = document.createElement("label");
  etiquetaNombre.textContent = "Nombre y primer apellido:";

  let inputNombre = document.createElement("input");
  inputNombre.type = "text";
  inputNombre.required = true;
  inputNombre.placeholder = "Ejemplo: Rafael Morones";
  inputNombre.name = "nombre";
  inputNombre.id = "nombre";

  contenedorNombre.appendChild(etiquetaNombre);
  contenedorNombre.appendChild(inputNombre);

  let br1 = document.createElement("br");
  formulario.appendChild(br1);

  /**************************
   * CONTENEDOR TARJETA
   ***************************/
  let contenedorTarjeta = document.createElement("div");
  contenedorTarjeta.id = "contenedor-tarjeta";
  contenedorTarjeta.classList.add("contenedor-tarjeta");
  formulario.appendChild(contenedorTarjeta);

  let etiquetaTarjeta = document.createElement("label");
  etiquetaTarjeta.textContent = "Tarjeta del cliente:";

  let inputTarjeta = document.createElement("input");
  inputTarjeta.type = "text";
  inputTarjeta.required = true;
  inputTarjeta.id = "tarjeta";
  inputTarjeta.name = "tarjeta";
  inputTarjeta.placeholder = "1234 1234 1234 1234";
  inputTarjeta.maxLength = 19;

  contenedorTarjeta.appendChild(etiquetaTarjeta);
  contenedorTarjeta.appendChild(inputTarjeta);

  let br2 = document.createElement("br");
  formulario.appendChild(br2);

  /*****************
   * CONTENEDOR CVC
   *****************/
  let contenedorCVC = document.createElement("div");
  contenedorCVC.id = "contenedor-cvc";
  contenedorCVC.classList.add("contenedor-cvc");
  formulario.appendChild(contenedorCVC);

  let etiquetaCVC = document.createElement("label");
  etiquetaCVC.textContent = "CÓDIGO CVC (3 DÍGITOS)";
  contenedorCVC.appendChild(etiquetaCVC);

  let inputCVC = document.createElement("input");
  inputCVC.type = "text";
  inputCVC.readOnly = true;
  inputCVC.name = "cvc";
  inputCVC.id = "cvc";
  inputCVC.placeholder = "Se calculará al procesar";
  contenedorCVC.appendChild(inputCVC);

  let br3 = document.createElement("br");
  formulario.appendChild(br3);

  /*****************
   * BOTÓN SUBMIT
   *****************/
  let botonSubmit = document.createElement("button");
  botonSubmit.type = "submit";
  botonSubmit.textContent = "Enviar";
  formulario.appendChild(botonSubmit);

  formulario.onsubmit = validarFormulario;
}

/*************************************
 * FUNCIONES PARA VALIDAR EL FORMULARIO
 **************************************/

function validarCampo(idCampo, expresionRegular) {
  let resultado = false;
  let campo = formulario[idCampo].value;

  if (campo === "") {
    textoError += "El campo " + idCampo + " no puede estar vacío.<br>";
  } else if (!expresionRegular.test(campo)) {
    textoError += "El formato de " + idCampo + " no es correcto.<br>";
  } else {
    resultado = true;
  }

  return resultado;
}

function calcularCVC(tarjeta) {
  let suma = 0;
  let cvc = "";

  let bloques = tarjeta.split(" ");
  for (let posicion = 0; posicion < bloques.length; posicion++) {
    let valorBloque = parseInt(bloques[posicion], 10);
    if (!isNaN(valorBloque)) {
      suma += valorBloque;
    }
  }

  if (suma < 100) {
    textoError += "El número de tarjeta no es correcto para generar un CVC.<br>";
  } else {
    let sumaString = String(suma);
    cvc = sumaString.slice(-3);
  }

  return cvc;
}

function validarFormulario(evento) {
  evento.preventDefault();
  errores.innerHTML = "";
  salida.textContent = "";
  textoError = "";

  // Expresión regular de nombre adaptada para admitir acentos comunes
  let expresionRegularNombreApellido = /^[a-zA-ZñÑ]+\s[a-zA-ZñÑ]+$/;
  let expresionRegularTarjeta = /^\d{4} \d{4} \d{4} \d{4}$/;
  let expresionRegularCVC = /^\d{3}$/;

  let todoCorrecto = true;

  // Validamos ambos campos acumulando los mensajes en 'textoError'
  let nombreValido = validarCampo("nombre", expresionRegularNombreApellido);
  let tarjetaValida = validarCampo("tarjeta", expresionRegularTarjeta);

  if (!nombreValido || !tarjetaValida) {
    todoCorrecto = false;
  }

  if (todoCorrecto) {
    let tarjeta = document.getElementById("tarjeta").value;
    let cvc = calcularCVC(tarjeta);

    if (cvc === "") {
      todoCorrecto = false;
    } else {
      document.getElementById("cvc").value = cvc;

      // Validar el CVC autogenerado contra su expresión regular
      if (!validarCampo("cvc", expresionRegularCVC, "CVC")) {
        todoCorrecto = false;
      }
    }
  }

  if (!todoCorrecto) {
    errores.innerHTML = "<p>" + textoError + "</p>";
    document.getElementById("cvc").value = "";
  } else {
    textoSalida =
      "DATOS VALIDADOS \n" +
      "Nombre del cliente: " +
      document.getElementById("nombre").value +
      "\n" +
      "Número de tarjeta: " +
      document.getElementById("tarjeta").value +
      "\n" +
      "Número de CVC: " +
      document.getElementById("cvc").value;

    salida.textContent = textoSalida;
  }
}
