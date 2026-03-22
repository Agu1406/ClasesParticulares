// Lógica del test. Los bancos de preguntas vienen de data/programacionYYYY.js (window.bancoExamenes).

const bancoExamenes = window.bancoExamenes || {};

// Examen actualmente cargado (array de preguntas) y su identificador.
let preguntasActuales = [];
let idExamenActual = null;

function crearPregunta(pregunta) {
  const contenedor = document.createElement("article");
  contenedor.className = "pregunta";

  const titulo = document.createElement("h2");
  titulo.textContent = `Pregunta ${pregunta.numero}`;

  const texto = document.createElement("pre");
  texto.textContent = pregunta.enunciado;

  contenedor.appendChild(titulo);
  contenedor.appendChild(texto);

  pregunta.opciones.forEach((opcion, indice) => {
    const etiqueta = document.createElement("label");
    etiqueta.className = "opcion";

    const radio = document.createElement("input");
    radio.type = "radio";
    radio.name = `pregunta-${pregunta.numero}`;
    radio.value = indice;

    radio.addEventListener("change", () => {
      manejarRespuestaInmediata(pregunta.numero, indice);
    });

    etiqueta.appendChild(radio);
    etiqueta.appendChild(document.createTextNode(opcion));
    contenedor.appendChild(etiqueta);
  });

  const parrafoFeedback = document.createElement("p");
  parrafoFeedback.id = `feedback-${pregunta.numero}`;
  parrafoFeedback.className = "feedback";
  contenedor.appendChild(parrafoFeedback);

  return contenedor;
}

function manejarRespuestaInmediata(numeroPregunta, indiceElegido) {
  const pregunta = preguntasActuales.find(
    (preguntaBuscada) => preguntaBuscada.numero === numeroPregunta
  );
  if (!pregunta) {
    return;
  }

  const parrafoFeedback = document.getElementById(`feedback-${numeroPregunta}`);
  if (!parrafoFeedback) {
    return;
  }

  const sinClave =
    pregunta.correcta === null || pregunta.correcta === undefined;
  const textoBase = pregunta.explicacion || "";

  if (sinClave) {
    parrafoFeedback.textContent =
      "Sin corrección automática (pregunta con clave null). " + textoBase;
    parrafoFeedback.classList.remove("feedback-incorrecto", "feedback-correcto");
    return;
  }

  const respuestaEsCorrecta = indiceElegido === pregunta.correcta;

  if (respuestaEsCorrecta) {
    parrafoFeedback.textContent = "Correcto. " + textoBase;
    parrafoFeedback.classList.remove("feedback-incorrecto");
    parrafoFeedback.classList.add("feedback-correcto");
  } else {
    parrafoFeedback.textContent = "Incorrecto. " + textoBase;
    parrafoFeedback.classList.remove("feedback-correcto");
    parrafoFeedback.classList.add("feedback-incorrecto");
  }
}

function cargarPreguntas(idExamen) {
  idExamenActual = idExamen;
  preguntasActuales = bancoExamenes[idExamen] || [];
  const zonaPreguntas = document.getElementById("zona-preguntas");
  zonaPreguntas.innerHTML = "";
  const zonaResultados = document.getElementById("zona-resultados");
  zonaResultados.classList.add("oculto");

  preguntasActuales.forEach((pregunta) => {
    const nodoPregunta = crearPregunta(pregunta);
    zonaPreguntas.appendChild(nodoPregunta);
  });
}

function corregirTest() {
  let aciertos = 0;
  let sinClave = 0;

  preguntasActuales.forEach((pregunta) => {
    if (pregunta.correcta === null || pregunta.correcta === undefined) {
      sinClave++;
      return;
    }
    const nombreGrupo = `pregunta-${pregunta.numero}`;
    const opcionesMarcadas = document.querySelectorAll(
      `input[name="${nombreGrupo}"]:checked`
    );
    if (opcionesMarcadas.length === 1) {
      const indiceElegido = parseInt(opcionesMarcadas[0].value, 10);
      if (indiceElegido === pregunta.correcta) {
        aciertos++;
      }
    }
  });

  const zonaResultados = document.getElementById("zona-resultados");
  const textoResultado = document.getElementById("texto-resultado");
  zonaResultados.classList.remove("oculto");

  const totalCalificadas = preguntasActuales.length - sinClave;
  let msg = `Has acertado ${aciertos} de ${totalCalificadas} preguntas con clave de corrección.`;
  if (sinClave > 0) {
    msg += ` (${sinClave} sin corrección automática).`;
  }
  textoResultado.textContent = msg;
}

document.addEventListener("DOMContentLoaded", () => {
  const selectorExamen = document.getElementById("selector-examen");
  const botonCargarExamen = document.getElementById("boton-cargar-examen");
  const botonCorrector = document.getElementById("boton-corrector");

  botonCargarExamen.addEventListener("click", () => {
    const idSeleccionado = selectorExamen.value;
    cargarPreguntas(idSeleccionado);
  });

  botonCorrector.addEventListener("click", corregirTest);
});

