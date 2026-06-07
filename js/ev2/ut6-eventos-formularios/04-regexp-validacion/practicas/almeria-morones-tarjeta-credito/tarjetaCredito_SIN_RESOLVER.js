document.addEventListener("DOMContentLoaded", construirFormulario);

let errores = document.getElementById("errores");
let salida = document.getElementById("salida");
let textoError = "";
let textoSalida = "";
let formulario;

function construirFormulario() {
  formulario = document.createElement("form");
  formulario.id = "formulario-tarjeta";
  document.body.appendChild(formulario);

  // TODO: crear campos nombre, tarjeta, CVC y botón (ver enunciado .docx)
  formulario.onsubmit = validarFormulario;
}

function validarCampo(idCampo, expresionRegular) {
  // TODO: vacío + RegExp.test()
  return false;
}

function calcularCVC(tarjeta) {
  // TODO: sumar bloques de 4 dígitos y tomar 3 últimos dígitos de la suma
  return "";
}

function validarFormulario(evento) {
  evento.preventDefault();
  errores.innerHTML = "";
  salida.textContent = "";
  textoError = "";

  // TODO: lookahead (?=) / (?!) — prohibido (?:)
  // let expresionRegularNombreApellido =
  //   /^(?=.{3,}\s)(?=.*[A-Za-záéíóúÁÉÍÓÚñÑ])[A-Za-záéíóúÁÉÍÓÚñÑ]+\s[A-Za-záéíóúÁÉÍÓÚñÑ]+$/;
  // let expresionRegularTarjeta =
  //   /^(?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4} )\d{4} (?=\d{4}$)\d{4}$/;
  // let expresionRegularCVC = /^(?=\d{3}$)\d{3}$/;
  let expresionRegularNombreApellido = /.*/;
  let expresionRegularTarjeta = /.*/;
  let expresionRegularCVC = /.*/;

  // TODO: validar, calcular CVC y mostrar salida o errores
}
