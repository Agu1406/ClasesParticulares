// Lógica del test. Los bancos de preguntas vienen de data/programacionYYYY.js (window.bancoExamenes).

const bancoExamenes = window.bancoExamenes || {};
const STORAGE_KEY_ESTADO = "pruebaslibres_estado_test";

// Examen actualmente cargado (array de preguntas) y su identificador.
let preguntasActuales = [];
let idExamenActual = null;
let ordenPreguntasActual = [];

function barajarArray(lista) {
  const copia = [...lista];
  for (let i = copia.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [copia[i], copia[j]] = [copia[j], copia[i]];
  }
  return copia;
}

function guardarEstado() {
  if (!idExamenActual) {
    return;
  }
  const respuestas = {};
  preguntasActuales.forEach((pregunta) => {
    const seleccion = document.querySelector(
      `input[name="pregunta-${pregunta.numero}"]:checked`
    );
    if (seleccion) {
      respuestas[pregunta.numero] = parseInt(seleccion.value, 10);
    }
  });
  const estado = {
    idExamen: idExamenActual,
    orden: ordenPreguntasActual,
    respuestas,
  };
  localStorage.setItem(STORAGE_KEY_ESTADO, JSON.stringify(estado));
}

function restaurarEstado() {
  const crudo = localStorage.getItem(STORAGE_KEY_ESTADO);
  if (!crudo) {
    return false;
  }
  try {
    const estado = JSON.parse(crudo);
    if (!estado || !estado.idExamen || !bancoExamenes[estado.idExamen]) {
      return false;
    }
    const selectorExamen = document.getElementById("selector-examen");
    selectorExamen.value = estado.idExamen;
    cargarPreguntas(estado.idExamen, estado.orden);

    const respuestas = estado.respuestas || {};
    Object.entries(respuestas).forEach(([numeroPregunta, indice]) => {
      const radio = document.querySelector(
        `input[name="pregunta-${numeroPregunta}"][value="${indice}"]`
      );
      if (radio) {
        radio.checked = true;
        manejarRespuestaInmediata(parseInt(numeroPregunta, 10), indice);
      }
    });
    return true;
  } catch (_error) {
    return false;
  }
}

function crearPregunta(pregunta) {
  const contenedor = document.createElement("article");
  contenedor.className =
    "rounded-2xl border border-slate-200 bg-white p-5 shadow-sm";

  const titulo = document.createElement("h2");
  titulo.className = "text-base font-semibold text-slate-900 md:text-lg";
  titulo.textContent = `Pregunta ${pregunta.numero}`;

  const texto = document.createElement("pre");
  texto.className =
    "mt-3 overflow-x-auto whitespace-pre-wrap rounded-xl bg-slate-50 p-3 text-sm leading-6 text-slate-700";
  texto.textContent = pregunta.enunciado;

  contenedor.appendChild(titulo);
  contenedor.appendChild(texto);

  pregunta.opciones.forEach((opcion, indice) => {
    const etiqueta = document.createElement("label");
    etiqueta.className =
      "mt-3 flex cursor-pointer items-start gap-3 rounded-xl border border-slate-200 bg-slate-50 p-3 transition hover:border-sky-300 hover:bg-sky-50";

    const radio = document.createElement("input");
    radio.type = "radio";
    radio.name = `pregunta-${pregunta.numero}`;
    radio.value = indice;
    radio.className = "mt-1 h-4 w-4 border-slate-300 text-sky-600 focus:ring-sky-400";

    const textoOpcion = document.createElement("span");
    textoOpcion.className = "text-sm leading-6 text-slate-800";
    textoOpcion.textContent = opcion;

    radio.addEventListener("change", () => {
      manejarRespuestaInmediata(pregunta.numero, indice);
      guardarEstado();
    });

    etiqueta.appendChild(radio);
    etiqueta.appendChild(textoOpcion);
    contenedor.appendChild(etiqueta);
  });

  const parrafoFeedback = document.createElement("p");
  parrafoFeedback.id = `feedback-${pregunta.numero}`;
  parrafoFeedback.className = "mt-3 text-sm leading-6";
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
    parrafoFeedback.classList.remove("text-emerald-700", "text-rose-700");
    parrafoFeedback.classList.add("text-amber-700");
    return;
  }

  const respuestaEsCorrecta = indiceElegido === pregunta.correcta;

  if (respuestaEsCorrecta) {
    parrafoFeedback.textContent = "Correcto. " + textoBase;
    parrafoFeedback.classList.remove("text-rose-700", "text-amber-700");
    parrafoFeedback.classList.add("text-emerald-700");
  } else {
    parrafoFeedback.textContent = "Incorrecto. " + textoBase;
    parrafoFeedback.classList.remove("text-emerald-700", "text-amber-700");
    parrafoFeedback.classList.add("text-rose-700");
  }
}

function cargarPreguntas(idExamen, ordenForzado = null) {
  idExamenActual = idExamen;
  const base = bancoExamenes[idExamen] || [];

  if (Array.isArray(ordenForzado) && ordenForzado.length > 0) {
    const porNumero = new Map(base.map((pregunta) => [pregunta.numero, pregunta]));
    const ordenadas = ordenForzado
      .map((numero) => porNumero.get(numero))
      .filter(Boolean);
    const restantes = base.filter(
      (pregunta) => !ordenForzado.includes(pregunta.numero)
    );
    preguntasActuales = [...ordenadas, ...restantes];
  } else {
    preguntasActuales = barajarArray(base);
  }

  ordenPreguntasActual = preguntasActuales.map((pregunta) => pregunta.numero);
  const zonaPreguntas = document.getElementById("zona-preguntas");
  zonaPreguntas.innerHTML = "";
  const zonaResultados = document.getElementById("zona-resultados");
  zonaResultados.classList.add("hidden");

  preguntasActuales.forEach((pregunta) => {
    const nodoPregunta = crearPregunta(pregunta);
    zonaPreguntas.appendChild(nodoPregunta);
  });
  guardarEstado();
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
  zonaResultados.classList.remove("hidden");

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

  const restaurado = restaurarEstado();
  if (!restaurado) {
    cargarPreguntas(selectorExamen.value);
  }
});

