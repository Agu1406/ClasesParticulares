// Ruta real 23-24-25: bancos y simulacros centrados en los PDFs recientes.
// Nota: se apoya en los bancos existentes programacion2023/2024/2025 ya cargados.

(function () {
  const bancoExamenes = (window.bancoExamenes = window.bancoExamenes || {});

  function clonarPreguntas(base, etiqueta) {
    return (base || []).map((p, i) => ({
      numero: i + 1,
      enunciado: p.enunciado,
      opciones: Array.isArray(p.opciones) ? [...p.opciones] : [],
      correcta: p.correcta,
      explicacion: `${p.explicacion || ""} [Ruta real: ${etiqueta}]`.trim(),
    }));
  }

  function mezclarDeterminista(listaA, listaB, listaC, total, etiqueta) {
    const a = [...(listaA || [])];
    const b = [...(listaB || [])];
    const c = [...(listaC || [])];
    const out = [];
    let i = 0;
    while (out.length < total && (a.length || b.length || c.length)) {
      const mod = i % 3;
      const origen = mod === 0 ? a : mod === 1 ? b : c;
      if (origen.length > 0) {
        const p = origen.shift();
        out.push({
          numero: out.length + 1,
          enunciado: p.enunciado,
          opciones: Array.isArray(p.opciones) ? [...p.opciones] : [],
          correcta: p.correcta,
          explicacion: `${p.explicacion || ""} [Ruta real: ${etiqueta}]`.trim(),
        });
      }
      i++;
    }
    return out;
  }

  function formatearPreguntas(lista, etiqueta) {
    return lista.map((p, idx) => ({
      numero: idx + 1,
      enunciado: p.enunciado,
      opciones: Array.isArray(p.opciones) ? [...p.opciones] : [],
      correcta: p.correcta,
      explicacion: `${p.explicacion || ""} [Ruta real: ${etiqueta}]`.trim(),
    }));
  }

  function normalizarTexto(texto) {
    return (texto || "")
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .toLowerCase();
  }

  function clavePregunta(pregunta) {
    return normalizarTexto(pregunta.enunciado || "").replace(/\s+/g, " ").trim();
  }

  function contieneAlguna(textoNormalizado, palabrasClave) {
    return (palabrasClave || []).some((palabra) => textoNormalizado.includes(palabra));
  }

  function crearSubtest(base, desde, hasta, etiqueta, minimoPreguntas = 10) {
    const fuente = base || [];
    const inicial = fuente.slice(desde, hasta);
    if (fuente.length === 0) {
      return [];
    }

    const seleccion = [...inicial];
    const yaIncluidas = new Set(inicial.map((p) => p.numero));
    let cursor = hasta % fuente.length;

    // Relleno temático: completa hasta minimoPreguntas con preguntas cercanas del mismo banco.
    while (seleccion.length < minimoPreguntas && yaIncluidas.size < fuente.length) {
      const candidata = fuente[cursor];
      if (!yaIncluidas.has(candidata.numero)) {
        seleccion.push(candidata);
        yaIncluidas.add(candidata.numero);
      }
      cursor = (cursor + 1) % fuente.length;
    }

    return formatearPreguntas(seleccion, etiqueta);
  }

  function crearBloquesPorRango(base, year, tamBloque) {
    const total = (base || []).length;
    let bloque = 1;
    for (let desde = 0; desde < total; desde += tamBloque) {
      const hasta = Math.min(desde + tamBloque, total);
      const id = `rutaReal${year}Bloque${String(bloque).padStart(2, "0")}`;
      const etiqueta = `${year} Q${desde + 1}-Q${hasta}`;
      bancoExamenes[id] = crearSubtest(base, desde, hasta, etiqueta, 10);
      bloque++;
    }
  }

  const p23 = bancoExamenes.programacion2023 || [];
  const p24 = bancoExamenes.programacion2024 || [];
  const p25 = bancoExamenes.programacion2025 || [];
  const originalesRA = (window.bancoOriginal && window.bancoOriginal.ra) || {};

  // Bancos "directos" para la ruta real.
  bancoExamenes.rutaReal2023 = clonarPreguntas(p23, "PDF 2023");
  bancoExamenes.rutaReal2024 = clonarPreguntas(p24, "PDF 2024");
  bancoExamenes.rutaReal2025 = clonarPreguntas(p25, "PDF 2025");

  // Simulacros mixtos 23-24-25.
  bancoExamenes.rutaRealSimulacroA = mezclarDeterminista(p23, p24, p25, 40, "Simulacro A");
  bancoExamenes.rutaRealSimulacroB = mezclarDeterminista(p25, p23, p24, 40, "Simulacro B");
  bancoExamenes.rutaRealSimulacroC = mezclarDeterminista(p24, p25, p23, 40, "Simulacro C");

  // Entrenamiento por bloques RA aproximados por temática (no por rango secuencial).
  const fuentesRA = [p23, p24, p25];
  const usadasRA = new Set();

  function construirRA(id, etiqueta, include, exclude = [], size = 10, raKey = null) {
    const pool = [];
    const originales = (raKey && originalesRA[raKey]) || [];

    // Prioridad 1: preguntas originales del RA.
    originales.forEach((pregunta) => {
      pool.push({
        enunciado: pregunta.enunciado,
        opciones: Array.isArray(pregunta.opciones) ? [...pregunta.opciones] : [],
        correcta: pregunta.correcta,
        explicacion: `${pregunta.explicacion || ""} [Origen: Original ${raKey}]`.trim(),
      });
    });

    // Prioridad 2: preguntas de exámenes reales por temática.
    fuentesRA.forEach((fuente) => {
      fuente.forEach((pregunta) => {
        const texto = normalizarTexto(`${pregunta.enunciado || ""} ${pregunta.explicacion || ""}`);
        const incluye = contieneAlguna(texto, include);
        const excluye = contieneAlguna(texto, exclude);
        if (incluye && !excluye) {
          pool.push(pregunta);
        }
      });
    });

    const seleccion = [];
    const usadasLocales = new Set();

    // 1) Prioriza preguntas temáticas no usadas en otros RA.
    for (const pregunta of pool) {
      if (seleccion.length >= size) break;
      const key = clavePregunta(pregunta);
      if (usadasRA.has(key) || usadasLocales.has(key)) continue;
      usadasLocales.add(key);
      seleccion.push(pregunta);
    }

    // 2) Si faltan, completa con preguntas temáticas aunque se hayan usado en otros RA.
    for (const pregunta of pool) {
      if (seleccion.length >= size) break;
      const key = clavePregunta(pregunta);
      if (usadasLocales.has(key)) continue;
      usadasLocales.add(key);
      seleccion.push(pregunta);
    }

    // 3) Fallback mínimo: completa desde 2025 evitando duplicados internos.
    for (const pregunta of p25) {
      if (seleccion.length >= size) break;
      const key = clavePregunta(pregunta);
      if (usadasLocales.has(key)) continue;
      usadasLocales.add(key);
      seleccion.push(pregunta);
    }

    seleccion.forEach((pregunta) => usadasRA.add(clavePregunta(pregunta)));
    bancoExamenes[id] = formatearPreguntas(seleccion.slice(0, size), etiqueta);
  }

  construirRA("rutaRealRA1", "RA1 aprox", ["java", "tipo", "variable", "operador", "args", "parseint"], [], 10, "RA1");
  construirRA("rutaRealRA2", "RA2 aprox", ["if", "else", "switch", "for", "while", "do", "bucle"], [], 10, "RA2");
  construirRA("rutaRealRA3", "RA3 aprox", ["metodo", "funcion", "parametro", "retorno", "recurs"], [], 10, "RA3");
  construirRA("rutaRealRA4", "RA4 aprox", ["array", "arraylist", "list", "set", "map", "hashmap", "collection"], [], 10, "RA4");
  construirRA("rutaRealRA5", "RA5 aprox", ["static", "constructor", "herencia", "polimorf", "sobrecarga", "sobrescrit", "equals"], [], 10, "RA5");
  construirRA("rutaRealRA6", "RA6 aprox", ["exception", "excepcion", "try", "catch", "finally", "throw"], [], 10, "RA6");
  construirRA("rutaRealRA7", "RA7 aprox", ["file", "reader", "writer", "stream", "serializ", "buffered", "io"], [], 10, "RA7");
  construirRA("rutaRealRA8", "RA8 aprox", ["jdbc", "connection", "statement", "resultset", "sql", "crud", "driver"], [], 10, "RA8");
  construirRA("rutaRealRA9", "RA9 aprox", ["json", "gson", "hibernate", "orm", "hql", "@entity", "javafx", "stage", "scene"], [], 10, "RA9");

  // Bloques directos por rango de preguntas para estudio guiado.
  crearBloquesPorRango(p23, "2023", 4); // 10 bloques de 4
  crearBloquesPorRango(p24, "2024", 4); // 10 bloques de 4
  crearBloquesPorRango(p25, "2025", 5); // 10 bloques de 5
})();
