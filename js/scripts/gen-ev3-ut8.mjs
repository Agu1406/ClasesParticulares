/** Genera ut8-async-frameworks. Uso: node js/scripts/gen-ev3-ut8.mjs */
import path from "node:path";
import { fileURLToPath } from "node:url";
import { writeSubtopic, writeRepaso, ten } from "./gen-dwec-lib.mjs";

const ut8 = path.join(path.dirname(fileURLToPath(import.meta.url)), "..", "ev3", "ut8-async-frameworks");

writeSubtopic(ut8, {
  id: "01-sincronia-async",
  theory: [{
    file: "01-event-loop.js",
    title: "Sincronía y asincronía",
    description: "Cola de tareas y setTimeout.",
    body: `console.log("1");\nsetTimeout(() => console.log("2"), 0);\nconsole.log("3");`,
  }],
  exercises: ten("async", "Async", [
    ["Orden 1-3 con setTimeout 0.", "setTimeout", `// TODO\n`, `console.log("1");\nsetTimeout(() => console.log("2"), 0);\nconsole.log("3");`],
    ["setInterval dos ticks y clear.", "setInterval", `// TODO\n`, `let n = 0;\nconst id = setInterval(() => { console.log(++n); if (n >= 2) clearInterval(id); }, 10);`],
    ["Callback simple.", "callback", `// TODO\n`, `function hacer(cb) { cb("listo"); }\nhacer(msg => console.log(msg));`],
    ["Callback hell explicación log.", "hell", `// TODO\n`, `console.log("anidar callbacks dificulta lectura");`],
    ["Error en callback con try/catch.", "error", `// TODO\n`, `try { throw new Error("fallo"); } catch (e) { console.log(e.message); }`],
    ["requestAnimationFrame log.", "raf", `// TODO\n`, `console.log("requestAnimationFrame sincroniza con pintado");`],
    ["Bloqueo vs no bloqueo.", "log", `// TODO\n`, `console.log("sync bloquea; async delega");`],
    ["Cola microtareas Promise.", "micro", `// TODO\n`, `Promise.resolve().then(() => console.log("microtarea"));`],
    ["setTimeout delay 100 log.", "delay", `// TODO\n`, `setTimeout(() => console.log("100ms"), 100);`],
    ["Resumen async intro.", "log", `// TODO\n`, `console.log("callbacks, setTimeout, cola de tareas");`],
  ]),
});

writeSubtopic(ut8, {
  id: "02-promesas",
  theory: [{
    file: "01-promesas.js",
    title: "Promesas",
    description: "then, catch, Promise.resolve.",
    body: `Promise.resolve(42).then(n => console.log(n));\nPromise.reject(new Error("x")).catch(e => console.log(e.message));`,
  }],
  exercises: ten("promesa", "Promesa", [
    ["Promise.resolve(7).then.", "resolve", `// TODO\n`, `Promise.resolve(7).then(n => console.log(n));`],
    ["Promise.reject con catch.", "catch", `// TODO\n`, `Promise.reject(new Error("fallo")).catch(e => console.log(e.message));`],
    ["Encadenar dos then.", "chain", `// TODO\n`, `Promise.resolve(1).then(n => n + 1).then(n => console.log(n));`],
    ["finally log.", "finally", `// TODO\n`, `Promise.resolve().finally(() => console.log("finally"));`],
    ["Promise.all [1,2].", "all", `// TODO\n`, `Promise.all([Promise.resolve(1), Promise.resolve(2)]).then(v => console.log(v));`],
    ["Promise.race.", "race", `// TODO\n`, `Promise.race([Promise.resolve("rápida"), new Promise(() => {})]).then(v => console.log(v));`],
    ["new Promise executor.", "constructor", `// TODO\n`, `new Promise(r => r("ok")).then(console.log);`],
    ["async function retorna valor.", "async", `// TODO\n`, `async function f() { return 9; }\nf().then(n => console.log(n));`],
    ["await en async IIFE.", "await", `// TODO\n`, `(async () => { const n = await Promise.resolve(3); console.log(n); })();`],
    ["Resumen promesas.", "log", `// TODO\n`, `console.log("then, catch, async/await");`],
  ]),
});

writeSubtopic(ut8, {
  id: "03-fetch",
  theory: [{
    file: "01-fetch-get.js",
    title: "fetch",
    description: "GET y respuesta JSON.",
    body: `// fetch("https://jsonplaceholder.typicode.com/posts/1")\n//   .then(r => r.json())\n//   .then(data => console.log(data));\nconsole.log("fetch devuelve una Promise");`,
  }],
  exercises: ten("fetch", "Fetch", [
    ["fetch comentado + log explicativo.", "GET", `// TODO\n`, `console.log("fetch(url).then(r => r.json())");`],
    ["response.ok significado.", "ok", `// TODO\n`, `console.log("response.ok si status 200-299");`],
    ["response.status.", "status", `// TODO\n`, `console.log("status HTTP en response");`],
    ["headers Content-Type.", "headers", `// TODO\n`, `console.log("headers.get('Content-Type')");`],
    ["POST body JSON (log plantilla).", "POST", `// TODO\n`, `console.log('fetch(url, { method:"POST", body: JSON.stringify({}) })');`],
    ["Error de red con catch.", "catch", `// TODO\n`, `Promise.reject(new Error("red")).catch(e => console.log(e.message));`],
    ["async/await fetch simulado.", "await", `// TODO\n`, `async function demo() { return { id: 1 }; }\ndemo().then(d => console.log(d.id));`],
    ["JSON.parse vs response.json.", "json", `// TODO\n`, `console.log(JSON.parse('{"a":1}'));`],
    ["AbortController concepto.", "abort", `// TODO\n`, `console.log("AbortController cancela fetch");`],
    ["Resumen fetch.", "log", `// TODO\n`, `console.log("fetch, JSON, async/await");`],
  ]),
});

writeSubtopic(ut8, {
  id: "04-dom-y-apis",
  theory: [{
    file: "01-renderizar-datos.js",
    title: "DOM y datos de API",
    description: "Pintar datos en el documento.",
    body: `const datos = [{ t: "A" }, { t: "B" }];\nconst ul = document.createElement("ul");\ndatos.forEach(d => {\n  const li = document.createElement("li");\n  li.textContent = d.t;\n  ul.appendChild(li);\n});\nconsole.log(ul.children.length);`,
  }],
  exercises: ten("api-dom", "API+DOM", [
    ["Array a lista ul/li.", "render", `// TODO\n`, `const ul = document.createElement("ul");\n["a","b"].forEach(t => { const li = document.createElement("li"); li.textContent = t; ul.appendChild(li); });\nconsole.log(ul.children.length);`],
    ["Plantilla innerHTML con map.", "template", `// TODO\n`, `const html = [1,2].map(n => \`<li>\${n}</li>\`).join("");\nconsole.log(html);`],
    ["Vaciar contenedor textContent=''.", "clear", `// TODO\n`, `const d = document.createElement("div");\nd.textContent = "";\nconsole.log(d.childElementCount);`],
    ["Spinner: clase loading.", "loading", `// TODO\n`, `document.body.classList.add("loading");\nconsole.log("cargando…");`],
    ["Manejo error en UI log.", "error", `// TODO\n`, `console.log("mostrar mensaje de error en DOM");`],
    ["JSON a tabla console.table.", "table", `// TODO\n`, `console.table([{ id: 1, titulo: "Post" }]);`],
    ["Evento tras cargar datos.", "event", `// TODO\n`, `document.dispatchEvent(new CustomEvent("datos-listos"));\nconsole.log("datos-listos");`],
    ["Framework intro log.", "framework", `// TODO\n`, `console.log("React/Vue: componentes y estado");`],
    ["Separación fetch / render.", "capas", `// TODO\n`, `console.log("capa datos + capa vista");`],
    ["Proyecto final checklist.", "log", `// TODO\n`, `console.log("API + DOM + async");`],
  ]),
});

writeRepaso(ut8, "05-repaso", ten("repaso-ut8", "Repaso UT8", [
    ["setTimeout orden.", "async", `// TODO\n`, `console.log("a"); setTimeout(() => console.log("b"), 0);`],
    ["Promise.resolve chain.", "promise", `// TODO\n`, `Promise.resolve(1).then(n => console.log(n + 1));`],
    ["async/await.", "await", `// TODO\n`, `(async () => console.log(await Promise.resolve("ok")))();`],
    ["fetch plantilla.", "fetch", `// TODO\n`, `console.log("fetch + json + dom");`],
    ["Render ul li.", "dom", `// TODO\n`, `const u = document.createElement("ul"); u.appendChild(document.createElement("li")); console.log(u.children.length);`],
    ["catch error red.", "catch", `// TODO\n`, `Promise.reject(new Error("x")).catch(e => console.log(e.message));`],
    ["Promise.all.", "all", `// TODO\n`, `Promise.all([1,2].map(n => Promise.resolve(n))).then(console.log);`],
    ["RA7 checklist.", "array", `// TODO\n`, `["async","promesas","fetch","dom"].forEach((t,i)=>console.log(i+1,t));`],
    ["JSON API.", "json", `// TODO\n`, `console.log(JSON.stringify({ ok: true }));`],
    ["Cierre UT8 / EV3.", "log", `// TODO\n`, `console.log("UT8 y EV3 repasados");`],
  ]));

console.log("UT8 generada.");
