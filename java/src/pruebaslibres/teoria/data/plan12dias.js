// Plan 12 dias: tests tematicos generados desde examenes oficiales 2021-2025.
// Se ejecuta despues de cargar programacion2021..2025.

(function () {
  const bancoExamenes = (window.bancoExamenes = window.bancoExamenes || {});

  const idsBase = [
    "programacion2021",
    "programacion2022",
    "programacion2023",
    "programacion2024",
    "programacion2025",
  ];

  const fuentes = idsBase
    .map((id) => ({ id, preguntas: bancoExamenes[id] || [] }))
    .filter((fuente) => Array.isArray(fuente.preguntas) && fuente.preguntas.length > 0);

  const preguntasOriginales = (window.bancoOriginal && window.bancoOriginal.all) || [];
  if (Array.isArray(preguntasOriginales) && preguntasOriginales.length > 0) {
    fuentes.push({ id: "originalesRA", preguntas: preguntasOriginales });
  }

  function normalizarTexto(texto) {
    return (texto || "")
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .toLowerCase();
  }

  function clavePregunta(texto) {
    return normalizarTexto(texto).replace(/\s+/g, " ").trim();
  }

  function clonarPreguntaConOrigen(pregunta, origen, numeroNuevo) {
    return {
      numero: numeroNuevo,
      enunciado: pregunta.enunciado,
      opciones: Array.isArray(pregunta.opciones) ? [...pregunta.opciones] : [],
      correcta: pregunta.correcta,
      explicacion: `${pregunta.explicacion || ""} [Origen: ${origen}]`.trim(),
    };
  }

  function contieneAlguna(textoNormalizado, palabrasClave) {
    return palabrasClave.some((palabra) => textoNormalizado.includes(palabra));
  }

  function filtrarPool(config) {
    const resultados = [];
    fuentes.forEach((fuente) => {
      fuente.preguntas.forEach((pregunta) => {
        const texto = normalizarTexto(`${pregunta.enunciado || ""} ${pregunta.explicacion || ""}`);
        const incluye = contieneAlguna(texto, config.include);
        const excluye = config.exclude && contieneAlguna(texto, config.exclude);
        if (incluye && !excluye) {
          resultados.push({
            pregunta,
            origen: fuente.id,
            key: clavePregunta(pregunta.enunciado || ""),
          });
        }
      });
    });
    return resultados;
  }

  function deduplicar(pool) {
    const usadas = new Set();
    const dedup = [];
    pool.forEach((item) => {
      if (!usadas.has(item.key)) {
        usadas.add(item.key);
        dedup.push(item);
      }
    });
    return dedup;
  }

  function dificultadPregunta(pregunta) {
    const texto = normalizarTexto(`${pregunta.enunciado || ""} ${pregunta.explicacion || ""}`);
    let puntos = 0;

    // Penaliza/bonifica segun señales aproximadas de complejidad.
    if (texto.includes("cual es la salida")) puntos += 2;
    if (texto.includes("compilar") || texto.includes("tiempo de compilacion")) puntos += 2;
    if (texto.includes("exception") || texto.includes("excepcion")) puntos += 2;
    if (texto.includes("jdbc") || texto.includes("sql")) puntos += 2;
    if (texto.includes("herencia") || texto.includes("polimorf") || texto.includes("sobrecarga")) puntos += 2;
    if (texto.includes("serializ") || texto.includes("reflection")) puntos += 2;
    if (texto.includes("arrayindexoutofbound")) puntos += 1;
    if ((pregunta.enunciado || "").split("\n").length >= 12) puntos += 2;
    if (texto.includes("que clase se utiliza") || texto.includes("cual es la funcion principal")) puntos -= 1;

    if (puntos <= 1) return "facil";
    if (puntos <= 4) return "media";
    return "alta";
  }

  function ordenarPorDificultad(pool, nivel) {
    const peso = { facil: 0, media: 1, alta: 2 };
    return [...pool].sort((a, b) => {
      const da = dificultadPregunta(a.pregunta);
      const db = dificultadPregunta(b.pregunta);
      const diff = Math.abs(peso[da] - peso[nivel]) - Math.abs(peso[db] - peso[nivel]);
      if (diff !== 0) return diff;
      return (a.pregunta.numero || 0) - (b.pregunta.numero || 0);
    });
  }

  function construirTest(config, usadasGlobales) {
    const tamano = config.size || 20;
    const baseFiltrada = deduplicar(filtrarPool(config));
    const candidatosPrioritarios = baseFiltrada.filter((item) => !usadasGlobales.has(item.key));
    const candidatosConReuso = baseFiltrada.filter((item) => usadasGlobales.has(item.key));

    const seleccion = [];
    const usadasLocales = new Set();

    function intentarAgregar(lista) {
      for (const item of lista) {
        if (seleccion.length >= tamano) {
          break;
        }
        if (!usadasLocales.has(item.key)) {
          seleccion.push(item);
          usadasLocales.add(item.key);
        }
      }
    }

    intentarAgregar(candidatosPrioritarios);
    if (seleccion.length < tamano) {
      intentarAgregar(candidatosConReuso);
    }

    if (seleccion.length < tamano) {
      // Relleno controlado: solo desde bases oficiales y evitando duplicados locales/globales.
      const relleno = [];
      fuentes.forEach((fuente) => {
        fuente.preguntas.forEach((pregunta) => {
          const key = clavePregunta(pregunta.enunciado || "");
          if (!usadasLocales.has(key) && !usadasGlobales.has(key)) {
            relleno.push({ pregunta, origen: fuente.id, key });
          }
        });
      });
      intentarAgregar(deduplicar(relleno));
    }

    if (seleccion.length < tamano) {
      // Ultimo fallback: permitir preguntas ya usadas en otros dias para completar.
      const rellenoConReuso = [];
      fuentes.forEach((fuente) => {
        fuente.preguntas.forEach((pregunta) => {
          const key = clavePregunta(pregunta.enunciado || "");
          if (!usadasLocales.has(key)) {
            rellenoConReuso.push({ pregunta, origen: fuente.id, key });
          }
        });
      });
      intentarAgregar(deduplicar(rellenoConReuso));
    }

    const examen = seleccion
      .slice(0, tamano)
      .map((item, index) => clonarPreguntaConOrigen(item.pregunta, item.origen, index + 1));

    seleccion.slice(0, tamano).forEach((item) => usadasGlobales.add(item.key));
    bancoExamenes[config.id] = examen;
  }

  function construirTestNoRepetir(config, usadasGlobales, todasDedupe, historialKeys) {
    const tamano = config.size || 20;
    const nivel = config.difficulty || "media";
    const candidatosTematicos = ordenarPorDificultad(deduplicar(filtrarPool(config)), nivel);
    const seleccion = [];
    const usadasLocales = new Set();
    const recientes = new Set((historialKeys || []).flatMap((set) => [...set]));

    function agregar(lista, permitirRepetidasGlobales) {
      for (const item of lista) {
        if (seleccion.length >= tamano) break;
        if (usadasLocales.has(item.key)) continue;
        if (!permitirRepetidasGlobales && usadasGlobales.has(item.key)) continue;
        seleccion.push(item);
        usadasLocales.add(item.key);
      }
    }

    // Version B: evita repetición reciente (ultimos dias) siempre que sea posible.
    agregar(
      candidatosTematicos.filter((item) => !recientes.has(item.key)),
      false
    );

    // Si faltan, permite tematicas no recientes aunque vengan de dias mas antiguos.
    if (seleccion.length < tamano) {
      agregar(candidatosTematicos, false);
    }

    // Si no llega, completa con cualquier pregunta no usada de bancos oficiales.
    if (seleccion.length < tamano) {
      const rellenoNoUsadas = ordenarPorDificultad(
        todasDedupe.filter((item) => !usadasGlobales.has(item.key) && !recientes.has(item.key)),
        nivel
      );
      agregar(rellenoNoUsadas, false);
    }

    if (seleccion.length < tamano) {
      const rellenoNoUsadasSinFiltroReciente = ordenarPorDificultad(
        todasDedupe.filter((item) => !usadasGlobales.has(item.key)),
        nivel
      );
      agregar(rellenoNoUsadasSinFiltroReciente, false);
    }

    // Ultimo fallback: permitir repeticion minima para no dejar dias incompletos.
    if (seleccion.length < tamano) {
      const rellenoConReuso = ordenarByRecencia(ordenarPorDificultad(todasDedupe, nivel), recientes);
      agregar(rellenoConReuso, true);
    }

    const examen = seleccion
      .slice(0, tamano)
      .map((item, index) => clonarPreguntaConOrigen(item.pregunta, item.origen, index + 1));

    examen.forEach((pregunta, idx) => {
      const prefijo = `[Dificultad aprox: ${dificultadPregunta(pregunta)}] `;
      examen[idx].explicacion = `${prefijo}${pregunta.explicacion || ""}`.trim();
    });

    seleccion.slice(0, tamano).forEach((item) => usadasGlobales.add(item.key));
    historialKeys.push(new Set(seleccion.slice(0, tamano).map((item) => item.key)));
    if (historialKeys.length > 3) {
      historialKeys.shift();
    }
    bancoExamenes[config.id] = examen;
  }

  function ordenarByRecencia(lista, recientes) {
    return [...lista].sort((a, b) => {
      const ar = recientes.has(a.key) ? 1 : 0;
      const br = recientes.has(b.key) ? 1 : 0;
      return ar - br;
    });
  }

  const plan = [
    {
      id: "planDia01_diagnostico",
      size: 20,
      include: ["java", "salida", "compila", "excepcion", "jdbc", "coleccion"],
    },
    {
      id: "planDia02_fundamentos",
      size: 20,
      include: ["if", "else", "for", "while", "switch", "operador", "xor", "parseint", "args"],
    },
    {
      id: "planDia03_poo_static_valor",
      size: 20,
      include: ["static", "constructor", "herencia", "sobrecarga", "sobrescrit", "equals", "wrapper"],
    },
    {
      id: "planDia04_excepciones_ficheros",
      size: 20,
      include: ["exception", "excepcion", "try", "catch", "finally", "file", "reader", "io", "throw"],
    },
    {
      id: "planDia05_colecciones_interfaces",
      size: 20,
      include: ["list", "set", "map", "hashmap", "collection", "interface", "comparable", "comparator"],
    },
    {
      id: "planDia06_arrays_recursion_reflection",
      size: 20,
      include: ["array", "recursion", "recurs", "class.get", "reflection", "indice", "outofbounds"],
    },
    {
      id: "planDia07_jdbc",
      size: 20,
      include: ["jdbc", "connection", "statement", "resultset", "sql", "crud", "driver"],
    },
    {
      id: "planDia08_streams_serializacion_json",
      size: 20,
      include: ["stream", "serializ", "objectinputstream", "objectoutputstream", "bufferedreader", "json"],
    },
    {
      id: "planDia09_orm_hibernate",
      size: 20,
      include: ["hibernate", "orm", "hql", "@entity", "entity", "persistencia"],
    },
    {
      id: "planDia10_javafx_ui",
      size: 20,
      include: ["javafx", "stage", "scene", "interfaz", "ui", "evento", "control"],
    },
    {
      id: "planDia11_simulacro1",
      size: 20,
      include: ["java", "salida", "compila", "herencia", "excepcion", "jdbc", "file", "collection", "array"],
    },
    {
      id: "planDia12_simulacro2",
      size: 20,
      include: ["java", "metodo", "static", "polimorf", "streams", "jdbc", "exception", "hashmap", "string"],
    },
  ];

  const usadasGlobales = new Set();
  plan.forEach((config) => construirTest(config, usadasGlobales));

  const planB = [
    { id: "planB_dia01_diagnostico", size: 20, difficulty: "facil", include: ["java", "salida", "compila", "excepcion", "jdbc", "coleccion"] },
    { id: "planB_dia02_fundamentos", size: 20, difficulty: "facil", include: ["if", "else", "for", "while", "switch", "operador", "xor", "parseint", "args"] },
    { id: "planB_dia03_poo_static_valor", size: 20, difficulty: "media", include: ["static", "constructor", "herencia", "sobrecarga", "sobrescrit", "equals", "wrapper"] },
    { id: "planB_dia04_excepciones_ficheros", size: 20, difficulty: "media", include: ["exception", "excepcion", "try", "catch", "finally", "file", "reader", "io", "throw"] },
    { id: "planB_dia05_colecciones_interfaces", size: 20, difficulty: "media", include: ["list", "set", "map", "hashmap", "collection", "interface", "comparable", "comparator"] },
    { id: "planB_dia06_arrays_recursion_reflection", size: 20, difficulty: "media", include: ["array", "recursion", "recurs", "class.get", "reflection", "indice", "outofbounds"] },
    { id: "planB_dia07_jdbc", size: 20, difficulty: "alta", include: ["jdbc", "connection", "statement", "resultset", "sql", "crud", "driver"] },
    { id: "planB_dia08_streams_serializacion_json", size: 20, difficulty: "alta", include: ["stream", "serializ", "objectinputstream", "objectoutputstream", "bufferedreader", "json"] },
    { id: "planB_dia09_orm_hibernate", size: 20, difficulty: "alta", include: ["hibernate", "orm", "hql", "@entity", "entity", "persistencia"] },
    { id: "planB_dia10_javafx_ui", size: 20, difficulty: "alta", include: ["javafx", "stage", "scene", "interfaz", "ui", "evento", "control"] },
    { id: "planB_dia11_simulacro1", size: 20, difficulty: "alta", include: ["java", "salida", "compila", "herencia", "excepcion", "jdbc", "file", "collection", "array"] },
    { id: "planB_dia12_simulacro2", size: 20, difficulty: "alta", include: ["java", "metodo", "static", "polimorf", "streams", "jdbc", "exception", "hashmap", "string"] },
  ];

  const todasDedupe = deduplicar(
    fuentes.flatMap((fuente) =>
      fuente.preguntas.map((pregunta) => ({
        pregunta,
        origen: fuente.id,
        key: clavePregunta(pregunta.enunciado || ""),
      }))
    )
  );

  const usadasGlobalesB = new Set();
  const historialRecienteB = [];
  planB.forEach((config) =>
    construirTestNoRepetir(config, usadasGlobalesB, todasDedupe, historialRecienteB)
  );
})();
