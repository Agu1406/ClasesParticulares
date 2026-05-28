/**
 * Genera material didáctico EV1 (teoría + ejercicios pendientes/resueltos).
 * Uso: node js/scripts/gen-ev1.mjs
 */
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const JS_ROOT = path.join(__dirname, "..");
const SINCE = "27/05/2026";

function jsdoc({ title, description, hint, level = "easy", extra = "" }) {
  const hintLine = hint ? ` * @hint ${hint}\n` : "";
  return `/**
 * ${title}
 * @description ${description}
 * @author Agustín. A. Marquez. Piña
 * @since ${SINCE}
 * @level ${level}
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">agustinmarquez.dev</a>
${hintLine}${extra ? ` * ${extra}\n` : ""} */\n\n`;
}

function writeFile(filePath, content) {
  fs.mkdirSync(path.dirname(filePath), { recursive: true });
  fs.writeFileSync(filePath, content, "utf8");
}

function htmlPage(title) {
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>
  <p>Abre las herramientas de desarrollo (F12) y revisa la consola.</p>
  <script src="script.js" type="module"></script>
</body>
</html>
`;
}

function writeTheory(subtopicDir, files) {
  for (const f of files) {
    const body = jsdoc({
      title: f.title,
      description: f.description,
      level: "theory",
    });
    writeFile(
      path.join(subtopicDir, "teoria", f.file),
      body + f.body.trim() + "\n"
    );
  }
}

function writeExercises(subtopicDir, exercises) {
  for (const ex of exercises) {
    const base = path.join(subtopicDir, "ejercicios");
    for (const mode of ["pendientes", "resueltos"]) {
      const dir = path.join(base, mode, ex.id);
      const solved = mode === "resueltos";
      const script =
        jsdoc({
          title: ex.title,
          description: ex.description,
          hint: solved ? undefined : ex.hint,
          level: "easy",
        }) + (solved ? ex.solved : ex.pending);
      writeFile(path.join(dir, "index.html"), htmlPage(ex.title));
      writeFile(path.join(dir, "script.js"), script);
    }
  }
}

function writeSubtopic(utPath, subtopic) {
  const dir = path.join(utPath, subtopic.id);
  writeTheory(dir, subtopic.theory);
  writeExercises(dir, subtopic.exercises);
}

function writeIntegracion(utPath, exercises) {
  const dir = path.join(utPath, "integracion-ut");
  writeExercises(dir, exercises);
}

// --- UT1 ---
const ut1 = path.join(JS_ROOT, "ev1", "ut1-cliente-web");

writeSubtopic(ut1, {
  id: "01-cliente-servidor",
  theory: [
    {
      file: "01-modelo-cliente-servidor.js",
      title: "Modelo cliente-servidor",
      description: "Roles del navegador y del servidor en una petición web.",
      body: `console.log("Cliente: navegador que pide recursos.");
console.log("Servidor: responde con HTML, CSS, JS, JSON, imágenes…");
console.log("Flujo: petición HTTP → procesamiento → respuesta HTTP");`,
    },
    {
      file: "02-protocolo-http-basico.js",
      title: "HTTP básico",
      description: "Métodos y códigos de estado más habituales en DWEC.",
      body: `const metodos = ["GET", "POST", "PUT", "DELETE"];
const codigos = { 200: "OK", 404: "No encontrado", 500: "Error servidor" };
console.log("Métodos:", metodos.join(", "));
console.log("Ejemplo 404:", codigos[404]);`,
    },
    {
      file: "03-navegador-como-cliente.js",
      title: "El navegador como cliente",
      description: "Qué hace el navegador al cargar una página con JavaScript.",
      body: `console.log("Motor JS + motor HTML/CSS + red + almacenamiento local");
console.log("URL actual (en página real):", globalThis.location?.href ?? "(ejecutar en navegador)");`,
    },
  ],
  exercises: mkUt1Sub1(),
});

writeSubtopic(ut1, {
  id: "02-scripts-en-html",
  theory: [
    {
      file: "01-script-interno-y-externo.js",
      title: "Script interno y externo",
      description: "Diferencia entre código embebido y fichero .js enlazado.",
      body: `// Externo: <script src="app.js" defer></script>
// Interno: <script>console.log('hola');</script>
console.log("Preferir externo: separación de responsabilidades y caché");`,
    },
    {
      file: "02-atributos-defer-async.js",
      title: "defer y async",
      description: "Cuándo usar cada atributo al cargar scripts.",
      body: `console.log("defer: descarga en paralelo, ejecuta al terminar HTML");
console.log("async: descarga en paralelo, ejecuta en cuanto llega (orden no garantizado)");`,
    },
  ],
  exercises: mkUt1Sub2(),
});

writeSubtopic(ut1, {
  id: "03-devtools",
  theory: [
    {
      file: "01-consola-devtools.js",
      title: "Panel Consola",
      description: "Mensajes y niveles de log en DevTools.",
      body: `console.log("Información");
console.warn("Aviso");
console.error("Error");
console.table([{ ut: 1, ra: "RA1" }, { ut: 2, ra: "RA2" }]);`,
    },
    {
      file: "02-elements-y-network.js",
      title: "Elements y Network",
      description: "Inspeccionar DOM y peticiones de red.",
      body: `console.log("Elements: estructura HTML/CSS en vivo");
console.log("Network: peticiones, estado HTTP, tiempos");`,
    },
  ],
  exercises: mkUt1Sub3(),
});

writeSubtopic(ut1, {
  id: "04-integracion-html-js",
  theory: [
    {
      file: "01-enlazar-js-al-dom.js",
      title: "Enlazar JS al DOM",
      description: "Cargar script cuando el DOM está listo.",
      body: `document.addEventListener("DOMContentLoaded", () => {
  console.log("DOM listo:", document.title);
});`,
    },
  ],
  exercises: mkUt1Sub4(),
});

writeIntegracion(ut1, mkUt1Integracion());

// --- UT2 ---
const ut2 = path.join(JS_ROOT, "ev1", "ut2-sintaxis-js");

writeSubtopic(ut2, {
  id: "01-variables-y-tipos",
  theory: [
    {
      file: "01-let-const.js",
      title: "let y const",
      description: "Declaración moderna de variables en ES6+.",
      body: `const PI = 3.14159;
let contador = 0;
contador += 1;
console.log(PI, contador);`,
    },
    {
      file: "02-tipos-primitivos.js",
      title: "Tipos primitivos",
      description: "string, number, boolean, null, undefined, bigint, symbol.",
      body: `console.log(typeof "hola", typeof 42, typeof true);
console.log(typeof null, typeof undefined);`,
    },
    {
      file: "03-conversiones.js",
      title: "Conversiones",
      description: "Number(), String(), Boolean() y coerción implícita.",
      body: `console.log(Number("12"), String(99), Boolean(0));
console.log("5" + 2, Number("5") + 2);`,
    },
  ],
  exercises: mkUt2Sub1(),
});

writeSubtopic(ut2, {
  id: "02-operadores",
  theory: [
    {
      file: "01-aritmeticos-y-asignacion.js",
      title: "Operadores aritméticos",
      description: "Suma, resto, incremento y asignación compuesta.",
      body: `let n = 10;
n += 5;
console.log(n % 3, n ** 2);`,
    },
    {
      file: "02-logicos-y-relacionales.js",
      title: "Operadores lógicos y relacionales",
      description: "Comparaciones y AND/OR/NOT.",
      body: `const a = 5, b = 10;
console.log(a < b && b !== a);
console.log(!(a === b));`,
    },
  ],
  exercises: mkUt2Sub2(),
});

writeSubtopic(ut2, {
  id: "03-condicionales",
  theory: [
    {
      file: "01-if-else.js",
      title: "if / else",
      description: "Ramificación según condiciones booleanas.",
      body: `const nota = 7;
if (nota >= 5) console.log("Aprobado");
else console.log("Suspenso");`,
    },
    {
      file: "02-switch.js",
      title: "switch",
      description: "Selección múltiple por valor.",
      body: `const dia = 3;
switch (dia) {
  case 1: console.log("Lunes"); break;
  case 3: console.log("Miércoles"); break;
  default: console.log("Otro día");
}`,
    },
  ],
  exercises: mkUt2Sub3(),
});

writeSubtopic(ut2, {
  id: "04-bucles",
  theory: [
    {
      file: "01-for-y-while.js",
      title: "for y while",
      description: "Repetición con contador y con condición.",
      body: `for (let i = 1; i <= 3; i++) console.log("for", i);
let j = 0;
while (j < 2) { console.log("while", j); j++; }`,
    },
    {
      file: "02-do-while.js",
      title: "do…while",
      description: "Ejecuta al menos una vez.",
      body: `let k = 0;
do { console.log("do", k); k++; } while (k < 2);`,
    },
  ],
  exercises: mkUt2Sub4(),
});

writeSubtopic(ut2, {
  id: "05-estilo-y-comentarios",
  theory: [
    {
      file: "01-comentarios-y-nombres.js",
      title: "Comentarios y nombres",
      description: "Buenas prácticas de legibilidad en DWEC.",
      body: `// Comentario de línea
/* Bloque de documentación interna */
const precioConIva = (base) => base * 1.21;
console.log(precioConIva(100));`,
    },
  ],
  exercises: mkUt2Sub5(),
});

writeIntegracion(ut2, mkUt2Integracion());

// --- UT3 ---
const ut3 = path.join(JS_ROOT, "ev1", "ut3-objetos-intro");

writeSubtopic(ut3, {
  id: "01-consola",
  theory: [
    {
      file: "01-metodos-console.js",
      title: "Métodos de console",
      description: "log, error, warn, table, group.",
      body: `console.group("RA3");
console.log("Mensaje");
console.error("Error simulado");
console.groupEnd();`,
    },
  ],
  exercises: mkUt3Sub1(),
});

writeSubtopic(ut3, {
  id: "02-window-y-document-intro",
  theory: [
    {
      file: "01-objeto-window.js",
      title: "window",
      description: "Objeto global del navegador.",
      body: `console.log("Ancho ventana:", window.innerWidth);
console.log("User agent:", navigator.userAgent.slice(0, 40) + "…");`,
    },
    {
      file: "02-objeto-document.js",
      title: "document",
      description: "Representación del DOM cargado.",
      body: `console.log(document.title);
console.log(document.URL);`,
    },
  ],
  exercises: mkUt3Sub2(),
});

writeSubtopic(ut3, {
  id: "03-errores-y-depuracion",
  theory: [
    {
      file: "01-tipos-de-errores.js",
      title: "Errores en JavaScript",
      description: "Sintaxis vs runtime y lectura del stack.",
      body: `try {
  const x = JSON.parse("{invalido}");
} catch (err) {
  console.error("Runtime:", err.message);
}`,
    },
  ],
  exercises: mkUt3Sub3(),
});

writeIntegracion(ut3, mkUt3Integracion());

console.log("EV1 generado correctamente.");

// --- Exercise factories (compact but real) ---

function ex(id, title, description, hint, pending, solved) {
  return { id, title, description, hint, pending, solved };
}

function mkUt1Sub1() {
  return [
    ex("01-identificar-roles", "Identificar roles", "Imprime en consola qué parte actúa como cliente y cuál como servidor al visitar una web.", "Piensa en quién pide y quién responde.", `function mostrarRoles() {\n  // TODO\n}\nmostrarRoles();`, `function mostrarRoles() {\n  console.log("Cliente: navegador");\n  console.log("Servidor: hosting que devuelve la página");\n}\nmostrarRoles();`),
    ex("02-listar-metodos-http", "Métodos HTTP", "Crea un array con GET, POST, PUT, DELETE y muéstralo con console.log.", "Usa join para una línea legible.", `const metodos = [];\n// TODO completar y mostrar`, `const metodos = ["GET","POST","PUT","DELETE"];\nconsole.log(metodos.join(" | "));`),
    ex("03-codigo-estado", "Código de estado", "Dado el número 404, imprime un mensaje humano usando un objeto como diccionario.", "Clave numérica en objeto.", `function mensajeEstado(codigo) {\n  // TODO\n}\nmensajeEstado(404);`, `function mensajeEstado(codigo) {\n  const mapa = { 200: "OK", 404: "No encontrado", 500: "Error" };\n  console.log(mapa[codigo] ?? "Desconocido");\n}\nmensajeEstado(404);`),
    ex("04-flujo-peticion", "Flujo de petición", "Imprime tres pasos numerados: petición, procesamiento, respuesta.", "Plantilla con for o tres console.log.", `// TODO tres pasos`, `["Petición","Procesamiento","Respuesta"].forEach((p,i)=>console.log(i+1,p));`),
    ex("05-url-recursos", "URL de recursos", "Almacena en constantes una URL base y un path y concaténalos.", "Template literals.", `// TODO base + path`, `const base = "https://ejemplo.es";\nconst path = "/api/alumnos";\nconsole.log(\`\${base}\${path}\`);`),
    ex("06-cliente-multiples-recursos", "Varios recursos", "Array con html y js; imprime cuántos recursos pide el cliente.", "length del array.", `const recursos = ["index.html","app.js"];\n// TODO`, `const recursos = ["index.html","app.js"];\nconsole.log("Recursos:", recursos.length);`),
    ex("07-ventajas-servidor", "Ventajas del servidor", "Imprime dos ventajas de centralizar datos en servidor.", "Seguridad y consistencia.", `// TODO dos console.log`, `console.log("Seguridad: datos no expuestos en cliente");\nconsole.log("Consistencia: una sola fuente de verdad");`),
    ex("08-comparar-php-js", "PHP vs JS en cliente", "Imprime una línea: dónde se ejecuta PHP y dónde JS del navegador.", "Servidor vs cliente.", `// TODO`, `console.log("PHP: servidor | JS DWEC: navegador del usuario");`),
    ex("09-pregunta-verdadero-falso", "Verdadero o falso", "const afirmacion=false; si es falsa imprime corrección.", "if (!afirmacion)", `const afirmacion = false;\n// TODO`, `const afirmacion = false;\nif (!afirmacion) console.log("Falso: el servidor no es el navegador");`),
    ex("10-resumen-ra1", "Resumen RA1", "Objeto con tres claves (cliente, servidor, protocolo) y console.table.", "console.table(obj)", `// TODO objeto`, `console.table({ cliente: "Navegador", servidor: "Backend", protocolo: "HTTP" });`),
  ];
}

function mkUt1Sub2() {
  return [
    ex("01-hola-script", "Hola desde script", "Imprime 'DWEC' en consola.", "console.log", `// TODO`, `console.log("DWEC");`),
    ex("02-defer-explicacion", "Explicar defer", "Imprime una frase que explique defer en una línea.", "Un console.log.", `// TODO`, `console.log("defer ejecuta el script tras parsear el HTML");`),
    ex("03-async-diferencia", "async vs defer", "Imprime en dos líneas la diferencia breve.", "Dos console.log.", `// TODO`, `console.log("async: orden impredecible");\nconsole.log("defer: orden respecto al HTML");`),
    ex("04-lista-ventajas-externo", "JS externo", "Array con 2 ventajas de fichero externo; recórrelo.", "for…of", `// TODO`, `for (const v of ["Caché","Mantenible"]) console.log(v);`),
    ex("05-ruta-script", "Ruta de script", "Constante ruta='js/app.js' e imprímela.", "const", `// TODO`, `const ruta = "js/app.js";\nconsole.log(ruta);`),
    ex("06-tipo-module", "type module", "Imprime qué implica type='module' (ámbito y defer implícito).", "ES modules.", `// TODO`, `console.log("Módulos: ámbito propio y strict mode");`),
    ex("07-evitar-inline", "Evitar inline", "Booleano inlineMalo=true; si true, imprime recomendación.", "if", `const inlineMalo = true;\n// TODO`, `const inlineMalo = true;\nif (inlineMalo) console.log("Usa ficheros .js externos");`),
    ex("08-orden-carga", "Orden de carga", "Array ['HTML','JS defer']; imprime orden con números.", "forEach", `// TODO`, `["HTML","JS defer"].forEach((e,i)=>console.log(i+1,e));`),
    ex("09-script-ubicacion", "Ubicación script", "Imprime dónde colocar script con defer (head o body).", "Ambos válidos con defer.", `// TODO`, `console.log("Con defer puede ir en <head> o final de <body>");`),
    ex("10-quiz-atributos", "Quiz atributos", "Objeto {defer:'paralelo+final HTML', async:'paralelo+inmediato'}; table.", "console.table", `// TODO`, `console.table({ defer: "paralelo+final HTML", async: "paralelo+inmediato" });`),
  ];
}

function mkUt1Sub3() {
  return [
    ex("01-log-niveles", "Niveles de log", "Usa log, warn y error con el mismo prefijo [DWEC].", "Tres llamadas.", `// TODO tres niveles`, `console.log("[DWEC] info");\nconsole.warn("[DWEC] aviso");\nconsole.error("[DWEC] error");`),
    ex("02-tabla-alumnos", "Tabla alumnos", "console.table con 2 objetos {nombre, nota}.", "Array de objetos.", `// TODO`, `console.table([{ nombre: "Ana", nota: 7 }, { nombre: "Luis", nota: 5 }]);`),
    ex("03-contador-errores", "Contador errores", "Cuenta cuántas 'e' hay en 'depuracion'.", "Bucle for sobre string.", `const palabra = "depuracion";\n// TODO`, `const palabra = "depuracion";\nlet c = 0;\nfor (const ch of palabra) if (ch === "e") c++;\nconsole.log(c);`),
    ex("04-group-consola", "Agrupar logs", "console.group y groupEnd con 2 logs dentro.", "group", `// TODO`, `console.group("Práctica");\nconsole.log("Paso 1");\nconsole.log("Paso 2");\nconsole.groupEnd();`),
    ex("05-time-tarea", "Medir tiempo", "console.time/timeEnd alrededor de un bucle 1e6.", "time label", `// TODO`, `console.time("bucle");\nfor (let i = 0; i < 1e6; i++) {}\nconsole.timeEnd("bucle");`),
    ex("06-inspeccionar-tipo", "typeof en consola", "Imprime typeof de 3 valores distintos.", "typeof", `// TODO 3 typeof`, `console.log(typeof 1, typeof "a", typeof true);`),
    ex("07-assert-ejemplo", "console.assert", "assert que 2+2===4 y otra que falle suavemente.", "console.assert", `// TODO`, `console.assert(2 + 2 === 4, "OK");\nconsole.assert(2 + 2 === 5, "No debería cumplirse");`),
    ex("08-clear-simulado", "Mensaje tras limpiar", "Imprime 'Consola lista' (simula tras clear).", "Un log.", `// TODO`, `console.log("Consola lista");`),
    ex("09-network-que-ver", "Qué ver en Network", "Imprime dos datos que muestra la pestaña Network.", "URL y status.", `// TODO`, `console.log("URL solicitada y código de estado HTTP");`),
    ex("10-checklist-devtools", "Checklist DevTools", "Array de 3 paneles útiles; imprímelos numerados.", "for", `// TODO`, `["Consola","Elements","Network"].forEach((p,i)=>console.log(i+1,p));`),
  ];
}

function mkUt1Sub4() {
  return [
    ex("01-dom-ready", "DOM listo", "Escucha DOMContentLoaded e imprime 'Listo'.", "addEventListener", `// TODO listener`, `document.addEventListener("DOMContentLoaded", () => console.log("Listo"));`),
    ex("02-titulo-pagina", "Título", "Imprime document.title.", "document.title", `// TODO`, `console.log(document.title);`),
    ex("03-crear-parrafo", "Crear párrafo", "Crea p, textContent 'Hola DWEC', añade a body.", "createElement", `// TODO`, `const p = document.createElement("p");\np.textContent = "Hola DWEC";\ndocument.body.append(p);`),
    ex("04-contar-parrafos", "Contar párrafos", "Imprime cuántos p hay en la página.", "querySelectorAll", `// TODO`, `console.log(document.querySelectorAll("p").length);`),
    ex("05-cambiar-titulo", "Cambiar título", "Asigna document.title = 'UT1 - DWEC'.", "asignación", `// TODO`, `document.title = "UT1 - DWEC";\nconsole.log(document.title);`),
    ex("06-lista-enlaces", "Enlaces", "Cuenta enlaces a con querySelectorAll.", "length", `// TODO`, `console.log("Enlaces:", document.querySelectorAll("a").length);`),
    ex("07-html-vs-js", "Separación", "Imprime una frase sobre separar HTML y JS.", "log", `// TODO`, `console.log("HTML estructura; JS comportamiento");`),
    ex("08-script-module-log", "Módulo", "Imprime 'Soy un módulo' (fichero type=module).", "log", `// TODO`, `console.log("Soy un módulo");`),
    ex("09-body-hijos", "Hijos de body", "Imprime body.children.length.", "children", `// TODO`, `console.log(document.body.children.length);`),
    ex("10-resumen-integracion-html", "Resumen", "Objeto {titulo: document.title, nodos: body.children.length}; table.", "table", `// TODO`, `console.table({ titulo: document.title, nodos: document.body.children.length });`),
  ];
}

function mkUt1Integracion() {
  return [
    ex("01-flujo-completo", "Flujo completo", "Imprime cliente→servidor→consola DevTools en 3 líneas.", "Secuencia.", `// TODO`, `console.log("1 Cliente pide");\nconsole.log("2 Servidor responde");\nconsole.log("3 Consola depura");`),
    ex("02-pagina-minima", "Página mínima", "Crea h1 'EV1' en body.", "createElement h1", `// TODO`, `const h1 = document.createElement("h1");\nh1.textContent = "EV1";\ndocument.body.append(h1);`),
    ex("03-script-defer-frase", "defer", "Log explicando defer.", "log", `// TODO`, `console.log("defer: JS tras HTML");`),
    ex("04-tabla-recursos", "Recursos", "table con 3 tipos MIME simulados.", "table", `// TODO`, `console.table([{tipo:"text/html"},{tipo:"text/css"},{tipo:"text/javascript"}]);`),
    ex("05-errores-consola", "Error controlado", "try/catch parse JSON inválido.", "try", `// TODO`, `try { JSON.parse("x"); } catch (e) { console.error(e.message); }`),
    ex("06-network-simulado", "Peticiones", "Array de URLs ficticias; log cada una.", "forEach", `// TODO`, `["/","/app.js"].forEach(u=>console.log("GET",u));`),
    ex("07-ra1-ra2", "RA1+RA2", "Objeto con ra1 y ra2 descripción corta.", "objeto", `// TODO`, `console.log({ ra1: "Cliente web", ra2: "Sintaxis JS" });`),
    ex("08-modulo-estricto", "Modo estricto", "Imprime que los módulos usan strict.", "log", `// TODO`, `console.log("Los módulos activan strict mode");`),
    ex("09-dom-listo-titulo", "DOM+título", "Al cargar, log título.", "DOMContentLoaded", `// TODO`, `document.addEventListener("DOMContentLoaded",()=>console.log(document.title));`),
    ex("10-checklist-ev1-ut1", "Checklist UT1", "5 strings con temas UT1; forEach numerado.", "forEach", `// TODO`, `["Cliente","Scripts","DevTools","HTML+JS","HTTP"].forEach((t,i)=>console.log(i+1,t));`),
  ];
}

function mkUt2Sub1() {
  return [
    ex("01-declarar-constantes", "PI", "const PI=3.14; log.", "const", `// TODO`, `const PI = 3.14;\nconsole.log(PI);`),
    ex("02-suma-variables", "Suma", "let a=2,b=3; log suma.", "let", `// TODO`, `let a = 2, b = 3;\nconsole.log(a + b);`),
    ex("03-tipo-string", "typeof string", "typeof de 'DWEC'.", "typeof", `// TODO`, `console.log(typeof "DWEC");`),
    ex("04-convertir-numero", "A número", "Number('42').", "Number", `// TODO`, `console.log(Number("42"));`),
    ex("05-booleano", "Boolean", "Boolean(1) y Boolean(0).", "Boolean", `// TODO`, `console.log(Boolean(1), Boolean(0));`),
    ex("06-template-literal", "Plantilla", "Nombre en template literal.", "backticks", `const nombre = "Ana";\n// TODO`, `const nombre = "Ana";\nconsole.log(\`Hola, \${nombre}\`);`),
    ex("07-null-undefined", "Nullish", "Compara null y undefined con ===.", "===", `// TODO`, `console.log(null === undefined);`),
    ex("08-prompt-simulado", "Entrada simulada", "const edad=18; log mayoría.", "if", `const edad = 18;\n// TODO`, `const edad = 18;\nconsole.log(edad >= 18 ? "Mayor de edad" : "Menor");`),
    ex("09-redondear", "Redondear", "Math.round(4.6).", "Math.round", `// TODO`, `console.log(Math.round(4.6));`),
    ex("10-ficha-alumno", "Ficha", "Objeto {nombre, curso}; table.", "table", `// TODO`, `console.table({ nombre: "Luis", curso: "2º DAW" });`),
  ];
}

function mkUt2Sub2() {
  return [
    ex("01-resto-division", "Resto", "17 % 5.", "%", `// TODO`, `console.log(17 % 5);`),
    ex("02-incremento", "Incremento", "let n=1; n++; log.", "++", `let n = 1;\n// TODO`, `let n = 1;\nn++;\nconsole.log(n);`),
    ex("03-comparar", "Comparar", "10 > 3.", ">", `// TODO`, `console.log(10 > 3);`),
    ex("04-and-logico", "AND", "true && false.", "&&", `// TODO`, `console.log(true && false);`),
    ex("05-or-logico", "OR", "false || true.", "||", `// TODO`, `console.log(false || true);`),
    ex("06-not", "NOT", "!false.", "!", `// TODO`, `console.log(!false);`),
    ex("07-asignacion-compuesta", "+=", "let x=5; x+=2.", "+=", `let x = 5;\n// TODO`, `let x = 5;\nx += 2;\nconsole.log(x);`),
    ex("08-ternario", "Ternario", "nota>=5 ? 'Apto' : 'No'.", "?:", `const nota = 6;\n// TODO`, `const nota = 6;\nconsole.log(nota >= 5 ? "Apto" : "No");`),
    ex("09-potencia", "Potencia", "2 ** 10.", "**", `// TODO`, `console.log(2 ** 10);`),
    ex("10-tabla-verdad", "Tabla", "table AND para TT,TF,FT,FF.", "table", `// TODO`, `console.table([{a:true,b:true,r:true},{a:true,b:false,r:false}]);`),
  ];
}

function mkUt2Sub3() {
  return [
    ex("01-aprobado", "Aprobado", "nota 7 → Aprobado.", "if", `const nota = 7;\n// TODO`, `const nota = 7;\nif (nota >= 5) console.log("Aprobado");`),
    ex("02-mayoria-edad", "Edad", "edad 20 → Mayor.", "if else", `const edad = 20;\n// TODO`, `const edad = 20;\nconsole.log(edad >= 18 ? "Mayor" : "Menor");`),
    ex("03-dia-laborable", "Día", "switch dia 2 → Martes.", "switch", `const dia = 2;\n// TODO`, `const dia = 2;\nswitch (dia) { case 2: console.log("Martes"); break; default: console.log("Otro"); }`),
    ex("04-signo-numero", "Signo", "n=-3 negativo/positivo/cero.", "if else", `const n = -3;\n// TODO`, `const n = -3;\nif (n > 0) console.log("+");\nelse if (n < 0) console.log("-");\nelse console.log("0");`),
    ex("05-nota-texto", "Calificación", "nota 9 → Sobresaliente (simplificado).", "if", `const nota = 9;\n// TODO`, `const nota = 9;\nif (nota >= 9) console.log("Sobresaliente");\nelse if (nota >= 5) console.log("Aprobado");\nelse console.log("Suspenso");`),
    ex("06-par-impar", "Par", "n=4 par o impar.", "%", `const n = 4;\n// TODO`, `const n = 4;\nconsole.log(n % 2 === 0 ? "Par" : "Impar");`),
    ex("07-menu-switch", "Menú", "opcion 3 → Salir.", "switch", `const opcion = 3;\n// TODO`, `const opcion = 3;\nswitch (opcion) { case 3: console.log("Salir"); break; default: console.log("Opción"); }`),
    ex("08-rango", "Rango", "x entre 1 y 10 inclusive.", "&&", `const x = 5;\n// TODO`, `const x = 5;\nconsole.log(x >= 1 && x <= 10);`),
    ex("09-login-simple", "Login", "user/pass correctos log OK.", "if", `const u = "admin", p = "1234";\n// TODO`, `const u = "admin", p = "1234";\nif (u === "admin" && p === "1234") console.log("OK");`),
    ex("10-clasificar-temperatura", "Temperatura", "<0 frío, <25 templado, else calor.", "if else", `const t = 30;\n// TODO`, `const t = 30;\nif (t < 0) console.log("Frío");\nelse if (t < 25) console.log("Templado");\nelse console.log("Calor");`),
  ];
}

function mkUt2Sub4() {
  return [
    ex("01-for-1-a-5", "1 a 5", "for imprime i.", "for", `// TODO`, `for (let i = 1; i <= 5; i++) console.log(i);`),
    ex("02-suma-1-10", "Suma 1-10", "Acumulador en for.", "suma", `// TODO`, `let s = 0;\nfor (let i = 1; i <= 10; i++) s += i;\nconsole.log(s);`),
    ex("03-while-contador", "While", "while < 3.", "while", `// TODO`, `let c = 0;\nwhile (c < 3) { console.log(c); c++; }`),
    ex("04-do-while", "Do while", "do…while una vez mínimo.", "do", `// TODO`, `let n = 0;\ndo { console.log("ejecutado"); n++; } while (n < 1);`),
    ex("05-tabla-del-7", "Tabla del 7", "7x1..7x10.", "for", `// TODO`, `for (let i = 1; i <= 10; i++) console.log(\`7 x \${i} = \${7 * i}\`);`),
    ex("06-pares-hasta-20", "Pares", "for pares hasta 20.", "i+=2", `// TODO`, `for (let i = 2; i <= 20; i += 2) console.log(i);`),
    ex("07-factorial-5", "Factorial 5", "1*2*3*4*5.", "for", `// TODO`, `let f = 1;\nfor (let i = 1; i <= 5; i++) f *= i;\nconsole.log(f);`),
    ex("08-recorrer-array", "Array", "['a','b','c'] for…of.", "for of", `const letras = ["a","b","c"];\n// TODO`, `for (const L of ["a","b","c"]) console.log(L);`),
    ex("09-buscar-primero", "Buscar", "Array números, primer > 10.", "for", `const nums = [3, 8, 15];\n// TODO`, `const nums = [3, 8, 15];\nfor (const n of nums) if (n > 10) { console.log(n); break; }`),
    ex("10-fizzbuzz-lite", "FizzBuzz lite", "1..15 múltiplos 3 Fizz.", "for if", `// TODO 1..15`, `for (let i = 1; i <= 15; i++) console.log(i % 3 === 0 ? "Fizz" : i);`),
  ];
}

function mkUt2Sub5() {
  return [
    ex("01-nombre-camelCase", "camelCase", "Función calcularTotal.", "function", `// TODO función`, `function calcularTotal(precio, iva = 0.21) {\n  return precio * (1 + iva);\n}\nconsole.log(calcularTotal(100));`),
    ex("02-comentario-funcion", "Documentar", "Función con comentario // que suma.", "//", `// TODO suma dos`, `/** Suma dos números */\nfunction suma(a, b) { return a + b; }\nconsole.log(suma(2, 3));`),
    ex("03-constantes-magicas", "Sin mágicos", "IVA como const 0.21.", "const", `// TODO`, `const IVA = 0.21;\nconsole.log(100 * (1 + IVA));`),
    ex("04-formato-legible", "Legible", "Variables con nombres claros min/max.", "nombres", `// TODO min max`, `const minimo = 0;\nconst maximo = 100;\nconsole.log(minimo, maximo);`),
    ex("05-arrow-suma", "Arrow", "Arrow (a,b)=>a+b.", "=>", `// TODO`, `const suma = (a, b) => a + b;\nconsole.log(suma(4, 5));`),
    ex("06-strict-ejemplo", "Igualdad", "=== vs == en 0 y false.", "===", `// TODO`, `console.log(0 == false, 0 === false);`),
    ex("07-separar-logica", "Funciones", "esPar(n) y usarla.", "function", `// TODO`, `function esPar(n) { return n % 2 === 0; }\nconsole.log(esPar(4));`),
    ex("08-plantilla-mensaje", "Plantilla", "mensaje con nombre y módulo.", "template", `// TODO`, `const nombre = "Ana";\nconsole.log(\`\${nombre} estudia DWEC\`);`),
    ex("09-codigo-limpio", "Early return", "positivo(n) return si n<0.", "return", `// TODO`, `function positivo(n) {\n  if (n < 0) return false;\n  return true;\n}\nconsole.log(positivo(5));`),
    ex("10-checklist-estilo", "Checklist", "Array 4 reglas estilo; log.", "forEach", `// TODO`, `["camelCase","const","===","comentarios"].forEach(r=>console.log("-",r));`),
  ];
}

function mkUt2Integracion() {
  return [
    ex("01-media-notas", "Media", "Array notas media.", "reduce opcional", `const notas = [7, 5, 8];\n// TODO`, `const notas = [7, 5, 8];\nconsole.log(notas.reduce((a,n)=>a+n,0)/notas.length);`),
    ex("02-mayor-nota", "Mayor", "Max en array.", "Math.max", `// TODO`, `console.log(Math.max(3, 9, 4));`),
    ex("03-fizzbuzz-30", "FizzBuzz", "1..30 reglas 3 y 5.", "for", `// TODO`, `for (let i = 1; i <= 30; i++) {\n  let m = "";\n  if (i % 3 === 0) m += "Fizz";\n  if (i % 5 === 0) m += "Buzz";\n  console.log(m || i);\n}`),
    ex("04-login-intentos", "Intentos", "3 intentos while.", "while", `// TODO`, `let i = 0;\nwhile (i < 3) { console.log("intento", i + 1); i++; }`),
    ex("05-conversion-temperatura", "C a F", "c→f fórmula.", "fórmula", `const c = 0;\n// TODO`, `const c = 0;\nconsole.log(c * 9/5 + 32);`),
    ex("06-buscar-nombre", "Buscar", "Array nombres incluye 'Ana'.", "includes", `// TODO`, `console.log(["Luis","Ana"].includes("Ana"));`),
    ex("07-switch-mes", "Mes", "mes 4 → Abril.", "switch", `// TODO`, `const mes = 4;\nswitch (mes) { case 4: console.log("Abril"); break; }`),
    ex("08-iva-precios", "IVA lista", "precios map +21%.", "map", `// TODO`, `console.log([10, 20].map(p => p * 1.21));`),
    ex("09-triangulo-asteriscos", "Triángulo", "3 líneas * crecientes.", "bucles anidados", `// TODO`, `for (let f = 1; f <= 3; f++) console.log("*".repeat(f));`),
    ex("10-resumen-sintaxis", "Resumen UT2", "table conceptos.", "table", `// TODO`, `console.table({ variables: "let/const", bucles: "for/while", condicion: "if/switch" });`),
  ];
}

function mkUt3Sub1() {
  return [
    ex("01-log-basico", "Log", "log Hola consola.", "log", `// TODO`, `console.log("Hola consola");`),
    ex("02-error-simulado", "Error", "console.error mensaje.", "error", `// TODO`, `console.error("Revisa el script");`),
    ex("03-warn", "Warn", "warn por variable no usada simulada.", "warn", `// TODO`, `console.warn("Variable reservada para más adelante");`),
    ex("04-table-modulos", "Table módulos", "table 2 módulos DAW.", "table", `// TODO`, `console.table([{ cod: "0612", nom: "DWEC" }, { cod: "0373", nom: "DAW base" }]);`),
    ex("05-group-tareas", "Group", "group 3 pasos depuración.", "group", `// TODO`, `console.group("Depuración");\n["Reproducir","Aislar","Corregir"].forEach(p=>console.log(p));\nconsole.groupEnd();`),
    ex("06-time-bucle", "Time", "time bucle pequeño.", "time", `// TODO`, `console.time("t");\nfor (let i=0;i<1e5;i++){}\nconsole.timeEnd("t");`),
    ex("07-assert", "Assert", "assert true.", "assert", `// TODO`, `console.assert(1 === 1);`),
    ex("08-trace-funcion", "Trace", "función que se llama a sí en trace (1 nivel).", "trace", `function demo() { console.trace("demo"); }\n// TODO llamar`, `function demo() { console.trace("demo"); }\ndemo();`),
    ex("09-count-simulado", "Contar", "label count manual con objeto.", "objeto", `// TODO`, `const conteo = { errores: 2 };\nconsole.log("Errores:", conteo.errores);`),
    ex("10-informe-consola", "Informe", "Resumen RA3 inicio en log.", "log", `// TODO`, `console.log("RA3: consola y objetos globales");`),
  ];
}

function mkUt3Sub2() {
  return [
    ex("01-inner-width", "Ancho", "log innerWidth.", "window", `// TODO`, `console.log(window.innerWidth);`),
    ex("02-user-agent", "User agent", "primeros 50 chars.", "slice", `// TODO`, `console.log(navigator.userAgent.slice(0, 50));`),
    ex("03-document-title", "Title", "log y cambia title.", "title", `// TODO`, `console.log(document.title);\ndocument.title = "UT3 DWEC";`),
    ex("04-location-href", "href", "log location.href.", "location", `// TODO`, `console.log(location.href);`),
    ex("05-open-cerrar-info", "open", "log que window.open abre ventana (sin abrir).", "log", `// TODO`, `console.log("window.open abre una nueva ventana");`),
    ex("06-history-length", "history", "history.length.", "history", `// TODO`, `console.log(history.length);`),
    ex("07-screen-avance", "screen", "screen.width si existe.", "screen", `// TODO`, `console.log(screen?.width ?? "N/D");`),
    ex("08-document-url", "URL doc", "document.URL.", "URL", `// TODO`, `console.log(document.URL);`),
    ex("09-comparar-window-global", "Global", "window === globalThis.", "===", `// TODO`, `console.log(window === globalThis);`),
    ex("10-ficha-navegador", "Ficha", "table ancho + título.", "table", `// TODO`, `console.table({ ancho: window.innerWidth, titulo: document.title });`),
  ];
}

function mkUt3Sub3() {
  return [
    ex("01-reference-error", "Capturar", "try usar variable no declarada.", "try", `// TODO`, `try { console.log(noExiste); } catch (e) { console.error(e.name); }`),
    ex("02-json-parse", "JSON", "try parse inválido.", "JSON.parse", `// TODO`, `try { JSON.parse("{}"); } catch (e) { console.error("JSON:", e.message); }`),
    ex("03-tipo-error", "Tipo", "log err.name en catch.", "name", `// TODO`, `try { null.foo(); } catch (e) { console.log(e.name); }`),
    ex("04-throw-custom", "Lanzar", "throw Error('Dato inválido').", "throw", `// TODO`, `try { throw new Error("Dato inválido"); } catch (e) { console.error(e.message); }`),
    ex("05-validar-numero", "Validar", "función que lance si NaN.", "isNaN", `function pedirNumero(n) {\n  // TODO\n}\npedirNumero("x");`, `function pedirNumero(n) {\n  if (Number.isNaN(Number(n))) throw new Error("No es número");\n  return Number(n);\n}\ntry { pedirNumero("x"); } catch (e) { console.error(e.message); }`),
    ex("06-stack-leer", "Stack", "catch y log stack primeras líneas.", "stack", `// TODO`, `try { throw new Error("demo"); } catch (e) { console.log(String(e.stack).split("\\n")[0]); }`),
    ex("07-depurar-bucle", "Depurar", "bucle con off-by-one corregido.", "for", `// TODO imprimir 1..3`, `for (let i = 1; i <= 3; i++) console.log(i);`),
    ex("08-mensaje-usuario", "Usuario", "error amigable sin tecnicismos.", "catch", `// TODO`, `try { JSON.parse(""); } catch { console.error("No se pudo leer el dato"); }`),
    ex("09-finally", "Finally", "try/catch/finally log 'fin'.", "finally", `// TODO`, `try { throw new Error(); } catch { console.error("Error"); } finally { console.log("fin"); }`),
    ex("10-checklist-depuracion", "Checklist", "4 pasos en array log.", "forEach", `// TODO`, `["Reproducir","Consola","Corregir","Probar"].forEach((p,i)=>console.log(i+1,p));`),
  ];
}

function mkUt3Integracion() {
  return [
    ex("01-consola-y-window", "Mix", "log ancho y título.", "ambos", `// TODO`, `console.log(window.innerWidth, document.title);`),
    ex("02-dom-listo-error", "DOM+error", "DOMContentLoaded + try.", "mix", `// TODO`, `document.addEventListener("DOMContentLoaded", () => {\n  try { JSON.parse("ok"); console.log("DOM ok"); } catch (e) { console.error(e); }\n});`),
    ex("03-tabla-entorno", "Entorno", "table navegador.", "table", `// TODO`, `console.table({ ancho: innerWidth, url: location.pathname });`),
    ex("04-crear-mensaje-dom", "DOM", "p en body mensaje error corregido.", "createElement", `// TODO`, `const p = document.createElement("p");\np.textContent = "Script sin errores de sintaxis";\ndocument.body.append(p);`),
    ex("05-funcion-segura", "Segura", "divide(a,b) evita /0.", "if", `// TODO`, `function divide(a, b) {\n  if (b === 0) throw new Error("División por cero");\n  return a / b;\n}\nconsole.log(divide(10, 2));`),
    ex("06-group-ra3", "RA3", "group logs RA3.", "group", `// TODO`, `console.group("RA3");\nconsole.log("Consola lista");\nconsole.groupEnd();`),
    ex("07-strict-mode-log", "Strict", "log módulo en strict.", "log", `// TODO`, `console.log("Este fichero es un módulo (strict)");`),
    ex("08-assert-document", "Assert", "assert body existe.", "assert", `// TODO`, `console.assert(document.body !== null, "body ok");`),
    ex("09-errores-comunes", "Errores", "lista 3 errores comunes log.", "array", `// TODO`, `["Variable no declarada","JSON inválido","Null reference"].forEach(e=>console.log("-",e));`),
    ex("10-cierre-ev1", "Cierre EV1", "mensaje fin EV1.", "log", `// TODO`, `console.log("EV1: fundamentos cliente y sintaxis listos");`),
  ];
}
