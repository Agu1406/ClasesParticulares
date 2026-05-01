const fs = require("fs");
const path = require("path");
const vm = require("vm");

const root = path.resolve(__dirname, "..");
const dataDir = path.join(root, "data");

const archivos = [
  "programacion2021.js",
  "programacion2022.js",
  "programacion2023.js",
  "programacion2024.js",
  "programacion2025.js",
  "preguntasOriginales.js",
  "plan12dias.js",
  "rutaReal232425.js",
];

const context = {
  window: {},
  console,
};
context.window.window = context.window;
vm.createContext(context);

for (const archivo of archivos) {
  const fullPath = path.join(dataDir, archivo);
  const code = fs.readFileSync(fullPath, "utf8");
  vm.runInContext(code, context, { filename: fullPath });
}

const banco = context.window.bancoExamenes || {};

function normalizar(texto) {
  return String(texto || "")
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase()
    .replace(/\s+/g, " ")
    .trim();
}

function keyPregunta(p) {
  return normalizar(p.enunciado);
}

function metricasExamen(id) {
  const examen = banco[id] || [];
  const keys = examen.map(keyPregunta);
  const unicas = new Set(keys).size;
  const repetidas = examen.length - unicas;
  const repeticionPct = examen.length ? (repetidas / examen.length) * 100 : 0;
  const originales = examen.filter((p) =>
    String(p.explicacion || "").includes("[Origen: Original")
  ).length;
  return {
    id,
    total: examen.length,
    repetidas,
    repeticionPct: repeticionPct.toFixed(1),
    originales,
  };
}

function imprimirGrupo(titulo, ids) {
  console.log(`\n=== ${titulo} ===`);
  ids.forEach((id) => {
    const m = metricasExamen(id);
    console.log(
      `${m.id}: total=${m.total}, repetidas=${m.repetidas} (${m.repeticionPct}%), originales=${m.originales}`
    );
  });
}

const raIds = Array.from({ length: 9 }, (_, i) => `rutaRealRA${i + 1}`);
const planBIds = Array.from(
  { length: 12 },
  (_, i) =>
    [
      "planB_dia01_diagnostico",
      "planB_dia02_fundamentos",
      "planB_dia03_poo_static_valor",
      "planB_dia04_excepciones_ficheros",
      "planB_dia05_colecciones_interfaces",
      "planB_dia06_arrays_recursion_reflection",
      "planB_dia07_jdbc",
      "planB_dia08_streams_serializacion_json",
      "planB_dia09_orm_hibernate",
      "planB_dia10_javafx_ui",
      "planB_dia11_simulacro1",
      "planB_dia12_simulacro2",
    ][i]
);

imprimirGrupo("RA", raIds);
imprimirGrupo("Plan B", planBIds);

const coberturaRA = raIds.reduce((acc, id) => {
  const examen = banco[id] || [];
  const originales = examen.filter((p) =>
    String(p.explicacion || "").includes("[Origen: Original")
  ).length;
  acc[id] = { originales, total: examen.length };
  return acc;
}, {});

console.log("\n=== Cobertura originales en RA ===");
Object.entries(coberturaRA).forEach(([id, c]) => {
  console.log(`${id}: ${c.originales}/${c.total} originales`);
});
