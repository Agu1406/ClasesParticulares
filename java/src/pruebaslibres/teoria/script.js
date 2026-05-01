// Lógica del test. Los bancos de preguntas vienen de data/programacionYYYY.js (window.bancoExamenes).

const bancoExamenes = window.bancoExamenes || {};
const STORAGE_KEY_ESTADO = "pruebaslibres_estado_test";

// Examen actualmente cargado (array de preguntas) y su identificador.
let preguntasActuales = [];
let idExamenActual = null;
let ordenPreguntasActual = [];

const PRACTICA_RECOMENDADA = [
  {
    keywords: ["jdbc", "connection", "statement", "resultset", "sql", "crud", "driver"],
    ejercicios: ["Ejercicio11_JDBCConceptos", "Ejercicio20_JDBC_JSON_ORM_JavaFX"],
  },
  {
    keywords: ["exception", "excepcion", "try", "catch", "finally", "throw", "outofbounds"],
    ejercicios: ["Ejercicio17_ExcepcionesYFinally", "Ejercicio06_ExcepcionesYFicheros"],
  },
  {
    keywords: ["hashmap", "map", "set", "list", "collection", "coleccion", "comparable", "comparator"],
    ejercicios: ["Ejercicio18_ColeccionesYMapas", "Ejercicio07_InterfacesYComparacion"],
  },
  {
    keywords: ["static", "constructor", "herencia", "polimorf", "sobrecarga", "sobrescrit"],
    ejercicios: ["Ejercicio16_POOStaticYConstructores", "Ejercicio04_StaticYPolimorfismo"],
  },
  {
    keywords: ["array", "recurs", "wrapper", "equals", "indice"],
    ejercicios: ["Ejercicio19_ArraysRecursionYWrappers", "Ejercicio09_ArraysYRecursion"],
  },
  {
    keywords: ["stream", "serializ", "objectinputstream", "objectoutputstream", "bufferedreader", "file"],
    ejercicios: ["Ejercicio14_SerializacionYStreams", "Ejercicio06_ExcepcionesYFicheros"],
  },
  {
    keywords: ["args", "parseint", "operador", "xor", "incremento", "^"],
    ejercicios: ["Ejercicio15_EntradaArgsYOperadores", "Ejercicio13_BitwiseYNumericos"],
  },
  {
    keywords: ["json", "gson", "hibernate", "orm", "hql", "@entity", "entity", "javafx", "stage", "scene"],
    ejercicios: ["Ejercicio20_JDBC_JSON_ORM_JavaFX"],
  },
];

const RUTAS_EJERCICIOS = {
  Ejercicio01_BuclesYSumas: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio01_BuclesYSumas_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio01_BuclesYSumas_RESUELTO.java",
  },
  Ejercicio04_StaticYPolimorfismo: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio04_StaticYPolimorfismo_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio04_StaticYPolimorfismo_RESUELTO.java",
  },
  Ejercicio06_ExcepcionesYFicheros: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio06_ExcepcionesYFicheros_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio06_ExcepcionesYFicheros_RESUELTO.java",
  },
  Ejercicio07_InterfacesYComparacion: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio07_InterfacesYComparacion_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio07_InterfacesYComparacion_RESUELTO.java",
  },
  Ejercicio09_ArraysYRecursion: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio09_ArraysYRecursion_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio09_ArraysYRecursion_RESUELTO.java",
  },
  Ejercicio11_JDBCConceptos: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio11_JDBCConceptos_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio11_JDBCConceptos_RESUELTO.java",
  },
  Ejercicio13_BitwiseYNumericos: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio13_BitwiseYNumericos_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio13_BitwiseYNumericos_RESUELTO.java",
  },
  Ejercicio12_SimulacroGlobal: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio12_SimulacroGlobal_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio12_SimulacroGlobal_RESUELTO.java",
  },
  Ejercicio14_SerializacionYStreams: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio14_SerializacionYStreams_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio14_SerializacionYStreams_RESUELTO.java",
  },
  Ejercicio15_EntradaArgsYOperadores: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio15_EntradaArgsYOperadores_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio15_EntradaArgsYOperadores_RESUELTO.java",
  },
  Ejercicio16_POOStaticYConstructores: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio16_POOStaticYConstructores_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio16_POOStaticYConstructores_RESUELTO.java",
  },
  Ejercicio17_ExcepcionesYFinally: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio17_ExcepcionesYFinally_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio17_ExcepcionesYFinally_RESUELTO.java",
  },
  Ejercicio18_ColeccionesYMapas: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio18_ColeccionesYMapas_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio18_ColeccionesYMapas_RESUELTO.java",
  },
  Ejercicio19_ArraysRecursionYWrappers: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio19_ArraysRecursionYWrappers_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio19_ArraysRecursionYWrappers_RESUELTO.java",
  },
  Ejercicio20_JDBC_JSON_ORM_JavaFX: {
    sinResolver: "../practica/coleccion/sin_resolver/Ejercicio20_JDBC_JSON_ORM_JavaFX_SIN_RESOLVER.java",
    resuelto: "../practica/coleccion/resueltos/Ejercicio20_JDBC_JSON_ORM_JavaFX_RESUELTO.java",
  },
};

function normalizarTexto(texto) {
  return (texto || "")
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase();
}

function ejercicioBloqueRutaReal(idExamen, numeroPregunta) {
  if (idExamen === "rutaReal2023") {
    const bloque = Math.ceil(numeroPregunta / 4);
    return `EjercicioPDF2023_Bloque${String(bloque).padStart(2, "0")}`;
  }
  if (idExamen === "rutaReal2024") {
    const bloque = Math.ceil(numeroPregunta / 4);
    return `EjercicioPDF2024_Bloque${String(bloque).padStart(2, "0")}`;
  }
  if (idExamen === "rutaReal2025") {
    const bloque = Math.ceil(numeroPregunta / 5);
    return `EjercicioPDF2025_Bloque${String(bloque).padStart(2, "0")}`;
  }
  return null;
}

function ejerciciosRecomendadosParaPregunta(pregunta, idExamen) {
  const bloqueExacto = ejercicioBloqueRutaReal(idExamen, pregunta.numero);
  if (bloqueExacto) {
    return [bloqueExacto];
  }

  const texto = normalizarTexto(`${pregunta.enunciado || ""} ${pregunta.explicacion || ""}`);
  for (const regla of PRACTICA_RECOMENDADA) {
    if (regla.keywords.some((keyword) => texto.includes(keyword))) {
      return regla.ejercicios;
    }
  }
  return ["Ejercicio12_SimulacroGlobal"];
}

function crearBotonEnlace(texto, href) {
  const enlace = document.createElement("a");
  enlace.href = href;
  enlace.target = "_blank";
  enlace.rel = "noopener noreferrer";
  enlace.textContent = texto;
  enlace.className =
    "inline-flex items-center rounded-lg border border-slate-300 bg-white px-2 py-1 text-xs text-slate-700 hover:bg-slate-50";
  return enlace;
}

function rutasParaEjercicio(ejercicio) {
  if (RUTAS_EJERCICIOS[ejercicio]) {
    return RUTAS_EJERCICIOS[ejercicio];
  }
  const match = /^EjercicioPDF(2023|2024|2025)_Bloque(\d{2})$/.exec(ejercicio);
  if (!match) {
    return null;
  }
  const year = match[1];
  const block = match[2];
  return {
    sinResolver: `../practica/ruta_real_232425/${year}/sin_resolver/EjercicioPDF${year}_Bloque${block}_SIN_RESOLVER.java`,
    resuelto: `../practica/ruta_real_232425/${year}/resueltos/EjercicioPDF${year}_Bloque${block}_RESUELTO.java`,
  };
}

function renderizarRecomendacionPractica(parrafoFeedback, ejercicios) {
  const bloquePrevio = parrafoFeedback.querySelector(".bloque-practica");
  if (bloquePrevio) {
    bloquePrevio.remove();
  }

  const bloque = document.createElement("div");
  bloque.className = "bloque-practica mt-2 space-y-2 text-xs";

  const titulo = document.createElement("p");
  titulo.className = "font-semibold";
  titulo.textContent = "Practica recomendada:";
  bloque.appendChild(titulo);

  ejercicios.forEach((ejercicio, index) => {
    const rutas = rutasParaEjercicio(ejercicio);
    const fila = document.createElement("div");
    fila.className = "flex flex-wrap items-center gap-2";

    const tipo = document.createElement("span");
    tipo.className =
      index === 0
        ? "rounded bg-sky-100 px-1.5 py-0.5 text-[11px] font-semibold text-sky-700"
        : "rounded bg-amber-100 px-1.5 py-0.5 text-[11px] font-semibold text-amber-700";
    tipo.textContent = index === 0 ? "Principal" : "Refuerzo";
    fila.appendChild(tipo);

    const nombre = document.createElement("span");
    nombre.className = "text-slate-700";
    nombre.textContent = ejercicio;
    fila.appendChild(nombre);

    if (rutas) {
      fila.appendChild(crearBotonEnlace("Abrir sin resolver", rutas.sinResolver));
      fila.appendChild(crearBotonEnlace("Abrir resuelto", rutas.resuelto));
    }

    bloque.appendChild(fila);
  });

  parrafoFeedback.appendChild(bloque);
}

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
  const ejercicios = ejerciciosRecomendadosParaPregunta(pregunta, idExamenActual);

  if (sinClave) {
    parrafoFeedback.textContent =
      "Sin corrección automática (pregunta con clave null). " + textoBase;
    parrafoFeedback.classList.remove("text-emerald-700", "text-rose-700");
    parrafoFeedback.classList.add("text-amber-700");
    renderizarRecomendacionPractica(parrafoFeedback, ejercicios);
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
  renderizarRecomendacionPractica(parrafoFeedback, ejercicios);
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

