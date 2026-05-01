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

  function crearSubtest(base, desde, hasta, etiqueta) {
    const trozo = (base || []).slice(desde, hasta);
    return trozo.map((p, idx) => ({
      numero: idx + 1,
      enunciado: p.enunciado,
      opciones: Array.isArray(p.opciones) ? [...p.opciones] : [],
      correcta: p.correcta,
      explicacion: `${p.explicacion || ""} [Ruta real: ${etiqueta}]`.trim(),
    }));
  }

  function crearBloquesPorRango(base, year, tamBloque) {
    const total = (base || []).length;
    let bloque = 1;
    for (let desde = 0; desde < total; desde += tamBloque) {
      const hasta = Math.min(desde + tamBloque, total);
      const id = `rutaReal${year}Bloque${String(bloque).padStart(2, "0")}`;
      const etiqueta = `${year} Q${desde + 1}-Q${hasta}`;
      bancoExamenes[id] = crearSubtest(base, desde, hasta, etiqueta);
      bloque++;
    }
  }

  const p23 = bancoExamenes.programacion2023 || [];
  const p24 = bancoExamenes.programacion2024 || [];
  const p25 = bancoExamenes.programacion2025 || [];

  // Bancos "directos" para la ruta real.
  bancoExamenes.rutaReal2023 = clonarPreguntas(p23, "PDF 2023");
  bancoExamenes.rutaReal2024 = clonarPreguntas(p24, "PDF 2024");
  bancoExamenes.rutaReal2025 = clonarPreguntas(p25, "PDF 2025");

  // Simulacros mixtos 23-24-25.
  bancoExamenes.rutaRealSimulacroA = mezclarDeterminista(p23, p24, p25, 40, "Simulacro A");
  bancoExamenes.rutaRealSimulacroB = mezclarDeterminista(p25, p23, p24, 40, "Simulacro B");
  bancoExamenes.rutaRealSimulacroC = mezclarDeterminista(p24, p25, p23, 40, "Simulacro C");

  // Entrenamiento por bloques "tipo RA" (aproximación de dificultad/progresión).
  // Distribución sobre banco de 40 preguntas: 3/3/6/6/4/7/6/3/2
  bancoExamenes.rutaRealRA1 = crearSubtest(p25, 0, 3, "RA1 aprox");
  bancoExamenes.rutaRealRA2 = crearSubtest(p25, 3, 6, "RA2 aprox");
  bancoExamenes.rutaRealRA3 = crearSubtest(p25, 6, 12, "RA3 aprox");
  bancoExamenes.rutaRealRA4 = crearSubtest(p25, 12, 18, "RA4 aprox");
  bancoExamenes.rutaRealRA5 = crearSubtest(p25, 18, 22, "RA5 aprox");
  bancoExamenes.rutaRealRA6 = crearSubtest(p25, 22, 29, "RA6 aprox");
  bancoExamenes.rutaRealRA7 = crearSubtest(p25, 29, 35, "RA7 aprox");
  bancoExamenes.rutaRealRA8 = crearSubtest(p25, 35, 38, "RA8 aprox");
  bancoExamenes.rutaRealRA9 = crearSubtest(p25, 38, 40, "RA9 aprox");

  // Bloques directos por rango de preguntas para estudio guiado.
  crearBloquesPorRango(p23, "2023", 4); // 10 bloques de 4
  crearBloquesPorRango(p24, "2024", 4); // 10 bloques de 4
  crearBloquesPorRango(p25, "2025", 5); // 10 bloques de 5
})();
