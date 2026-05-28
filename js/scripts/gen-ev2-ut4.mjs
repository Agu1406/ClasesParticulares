/** Genera ut4-objetos-navegador. Uso: node js/scripts/gen-ev2-ut4.mjs */
import path from "node:path";
import { fileURLToPath } from "node:url";
import { writeSubtopic, writeRepaso, ten, ex } from "./gen-dwec-lib.mjs";

const ut4 = path.join(path.dirname(fileURLToPath(import.meta.url)), "..", "ev2", "ut4-objetos-navegador");

writeSubtopic(ut4, {
  id: "01-window",
  theory: [{
    file: "01-objeto-window.js",
    title: "Objeto window",
    description: "El objeto global del navegador.",
    body: `console.log("Ancho:", window.innerWidth, "Alto:", window.innerHeight);`,
  }],
  exercises: ten("ancho-ventana", "Ventana", [
    ["Imprime innerWidth e innerHeight.", "Propiedades de window.", `// TODO\n`, `console.log(window.innerWidth, window.innerHeight);`],
    ["Muestra location.href.", "window.location", `// TODO\n`, `console.log(location.href);`],
    ["Compara window con globalThis.", "===", `// TODO\n`, `console.log(window === globalThis);`],
    ["Imprime userAgent recortado a 50 caracteres.", "slice", `// TODO\n`, `console.log(navigator.userAgent.slice(0, 50));`],
    ["history.length en consola.", "history", `// TODO\n`, `console.log(history.length);`],
    ["screen.width y screen.height.", "screen", `// TODO\n`, `console.log(screen.width, screen.height);`],
    ["open: solo log explicativo (no abrir ventana).", "window.open", `// TODO\n`, `console.log("window.open crea una nueva ventana");`],
    ["devicePixelRatio.", "navigator", `// TODO\n`, `console.log(window.devicePixelRatio);`],
    ["Nombre de la ventana (name).", "window.name", `// TODO\n`, `console.log(window.name || "(sin nombre)");`],
    ["Tabla resumen window/screen.", "table", `// TODO\n`, `console.table({ ancho: innerWidth, alto: innerHeight });`],
  ]),
});

writeSubtopic(ut4, {
  id: "02-document",
  theory: [{
    file: "01-objeto-document.js",
    title: "Objeto document",
    description: "Representación del documento HTML cargado.",
    body: `console.log(document.title);\nconsole.log(document.URL);`,
  }],
  exercises: ten("document", "Document", [
    ["Imprime document.title.", "title", `// TODO\n`, `console.log(document.title);`],
    ["Cambia title a 'UT4 DWEC'.", "asignación", `// TODO\n`, `document.title = "UT4 DWEC";\nconsole.log(document.title);`],
    ["document.URL en consola.", "URL", `// TODO\n`, `console.log(document.URL);`],
    ["Cuenta elementos p.", "querySelectorAll", `// TODO\n`, `console.log(document.querySelectorAll("p").length);`],
    ["document.body existe (assert).", "assert", `// TODO\n`, `console.assert(document.body !== null);`],
    ["readyState.", "document", `// TODO\n`, `console.log(document.readyState);`],
    ["charset o characterSet.", "document", `// TODO\n`, `console.log(document.characterSet);`],
    ["lastModified.", "document", `// TODO\n`, `console.log(document.lastModified);`],
    ["referrer.", "document", `// TODO\n`, `console.log(document.referrer || "(vacío)");`],
    ["Objeto {title, url} con table.", "table", `// TODO\n`, `console.table({ title: document.title, url: document.URL });`],
  ]),
});

writeSubtopic(ut4, {
  id: "03-dialogos",
  theory: [{
    file: "01-alert-confirm-prompt.js",
    title: "Diálogos",
    description: "alert, confirm y prompt (uso didáctico).",
    body: `// En práctica: alert("Hola");\nconsole.log("confirm devuelve true/false");\nconsole.log("prompt devuelve string o null");`,
  }],
  exercises: ten("dialogo", "Diálogo", [
    ["Simula alert con console.log.", "sin alert real", `// TODO\n`, `console.log("¡Hola desde diálogo simulado!");`],
    ["confirm simulado: const ok=true; log.", "boolean", `const ok = true;\n// TODO\n`, `const ok = true;\nconsole.log("Confirm:", ok);`],
    ["prompt simulado: nombre fijo.", "string", `const nombre = "Ana";\n// TODO\n`, `const nombre = "Ana";\nconsole.log("Hola", nombre);`],
    ["Función saludar(n) que loguea.", "function", `// TODO función\n`, `function saludar(n) { console.log("Hola", n); }\nsaludar("Luis");`],
    ["Validar prompt vacío (simulado).", "if", `const entrada = "";\n// TODO\n`, `const entrada = "";\nconsole.log(entrada ? "OK" : "Vacío");`],
    ["confirm para '¿Continuar?'.", "ternario", `const seguir = true;\n// TODO\n`, `const seguir = true;\nconsole.log(seguir ? "Continúa" : "Cancela");`],
    ["Tres niveles de mensaje: info/warn/error log.", "log niveles", `// TODO\n`, `console.log("info");\nconsole.warn("aviso");\nconsole.error("error");`],
    ["parseInt de prompt simulado '42'.", "Number", `// TODO\n`, `console.log(Number("42"));`],
    ["Menú numérico con switch.", "switch", `const op = 2;\n// TODO\n`, `const op = 2;\nswitch (op) { case 2: console.log("Opción 2"); break; }`],
    ["Resumen diálogos en un log.", "resumen", `// TODO\n`, `console.log("alert/confirm/prompt: interacción bloqueante");`],
  ]),
});

writeSubtopic(ut4, {
  id: "04-storage",
  theory: [{
    file: "01-localstorage.js",
    title: "localStorage",
    description: "Persistencia clave-valor en el navegador.",
    body: `localStorage.setItem("tema", "oscuro");\nconsole.log(localStorage.getItem("tema"));`,
  }],
  exercises: ten("storage", "Storage", [
    ["setItem 'idioma' 'es' y getItem.", "localStorage", `// TODO\n`, `localStorage.setItem("idioma", "es");\nconsole.log(localStorage.getItem("idioma"));`],
    ["removeItem 'temp'.", "localStorage", `// TODO\n`, `localStorage.removeItem("temp");\nconsole.log("temp eliminado");`],
    ["JSON.stringify objeto {nota:7}.", "JSON", `// TODO\n`, `localStorage.setItem("alumno", JSON.stringify({ nota: 7 }));\nconsole.log(localStorage.getItem("alumno"));`],
    ["Parsear JSON guardado.", "parse", `// TODO\n`, `const d = JSON.parse('{"nota":7}');\nconsole.log(d.nota);`],
    ["sessionStorage setItem log.", "sessionStorage", `// TODO\n`, `sessionStorage.setItem("sesion", "activa");\nconsole.log(sessionStorage.getItem("sesion"));`],
    ["Contar keys en localStorage.", "length", `// TODO\n`, `console.log(localStorage.length);`],
    ["key(0) si existe.", "key", `// TODO\n`, `if (localStorage.length) console.log(localStorage.key(0));`],
    ["clear no ejecutar: log advertencia.", "clear", `// TODO\n`, `console.log("clear borra todo; usar con cuidado");`],
    ["Preferencia tema claro/oscuro.", "preferencia", `// TODO\n`, `localStorage.setItem("tema", "claro");\nconsole.log(localStorage.getItem("tema"));`],
    ["Tabla con 2 claves ficticias.", "table", `// TODO\n`, `console.table({ idioma: "es", tema: "claro" });`],
  ]),
});

writeRepaso(ut4, "05-repaso", ten("repaso-ut4", "Repaso UT4", [
    ["window + document title.", "mix", `// TODO\n`, `console.log(window.innerWidth, document.title);`],
    ["localStorage idioma.", "storage", `// TODO\n`, `localStorage.setItem("idioma","es");\nconsole.log(localStorage.getItem("idioma"));`],
    ["location.pathname.", "location", `// TODO\n`, `console.log(location.pathname);`],
    ["Dialogo simulado bienvenida.", "log", `// TODO\n`, `console.log("Bienvenido a UT4");`],
    ["querySelectorAll('h1').length.", "DOM", `// TODO\n`, `console.log(document.querySelectorAll("h1").length);`],
    ["navigator.language.", "navigator", `// TODO\n`, `console.log(navigator.language);`],
    ["JSON roundtrip objeto.", "JSON", `// TODO\n`, `const o={a:1}; const s=JSON.stringify(o); console.log(JSON.parse(s));`],
    ["sessionStorage vs local en log.", "comparar", `// TODO\n`, `console.log("session: sesión; local: persistente");`],
    ["RA3 repaso checklist.", "array", `// TODO\n`, `["window","document","storage"].forEach((t,i)=>console.log(i+1,t));`],
    ["Cierre UT4.", "log", `// TODO\n`, `console.log("UT4 objetos navegador repasados");`],
  ]));

console.log("UT4 generada.");
