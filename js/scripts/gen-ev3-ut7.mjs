/** Genera ut7-dom. Uso: node js/scripts/gen-ev3-ut7.mjs */
import path from "node:path";
import { fileURLToPath } from "node:url";
import { writeSubtopic, writeRepaso, ten } from "./gen-dwec-lib.mjs";

const ut7 = path.join(path.dirname(fileURLToPath(import.meta.url)), "..", "ev3", "ut7-dom");

writeSubtopic(ut7, {
  id: "01-selectores",
  theory: [{
    file: "01-queryselector.js",
    title: "Selectores del DOM",
    description: "getElementById, querySelector y querySelectorAll.",
    body: `const h1 = document.querySelector("h1");\nif (h1) console.log(h1.textContent);\nconsole.log(document.querySelectorAll("p").length);`,
  }],
  exercises: ten("selector", "Selector", [
    ["querySelector('h1') y log textContent.", "querySelector", `// TODO\n`, `const h1 = document.querySelector("h1");\nif (h1) console.log(h1.textContent);`],
    ["querySelectorAll('p').length.", "querySelectorAll", `// TODO\n`, `console.log(document.querySelectorAll("p").length);`],
    ["getElementById si existe en la página.", "getElementById", `// TODO\n`, `const el = document.getElementById("app");\nconsole.log(el ? "encontrado" : "no existe");`],
    ["getElementsByClassName('item').length.", "class", `// TODO\n`, `console.log(document.getElementsByClassName("item").length);`],
    ["getElementsByTagName('li').length.", "tag", `// TODO\n`, `console.log(document.getElementsByTagName("li").length);`],
    ["Primer enlace: querySelector('a').href.", "a", `// TODO\n`, `const a = document.querySelector("a");\nif (a) console.log(a.href);`],
    ["Lista nodos: forEach en querySelectorAll('li').", "forEach", `// TODO\n`, `document.querySelectorAll("li").forEach((li, i) => console.log(i, li.textContent));`],
    ["closest('section') desde un p.", "closest", `// TODO\n`, `const p = document.querySelector("p");\nif (p) console.log(p.closest("section"));`],
    ["matches('p.intro') en un párrafo.", "matches", `// TODO\n`, `const p = document.querySelector("p");\nif (p) console.log(p.matches("p"));`],
    ["Resumen selectores.", "log", `// TODO\n`, `console.log("id, class, querySelector, querySelectorAll");`],
  ]),
});

writeSubtopic(ut7, {
  id: "02-modificar-nodos",
  theory: [{
    file: "01-crear-nodos.js",
    title: "Crear y modificar nodos",
    description: "createElement, appendChild, remove.",
    body: `const li = document.createElement("li");\nli.textContent = "Nuevo";\ndocument.body.appendChild(li);`,
  }],
  exercises: ten("nodo", "Nodo", [
    ["createElement('p') con textContent.", "createElement", `// TODO\n`, `const p = document.createElement("p");\np.textContent = "Hola DOM";\nconsole.log(p.outerHTML);`],
    ["appendChild un li a ul (crear ul si no hay).", "appendChild", `// TODO\n`, `const ul = document.createElement("ul");\nconst li = document.createElement("li");\nli.textContent = "Uno";\nul.appendChild(li);\nconsole.log(ul.children.length);`],
    ["removeChild del último li.", "remove", `// TODO\n`, `const ul = document.createElement("ul");\nul.appendChild(document.createElement("li"));\nul.removeChild(ul.lastElementChild);\nconsole.log(ul.children.length);`],
    ["textContent vs innerHTML (solo texto).", "textContent", `// TODO\n`, `const d = document.createElement("div");\nd.textContent = "<b>no es HTML</b>";\nconsole.log(d.innerHTML);`],
    ["createTextNode.", "createTextNode", `// TODO\n`, `const t = document.createTextNode("texto");\nconsole.log(t.textContent);`],
    ["insertBefore primer hijo.", "insertBefore", `// TODO\n`, `const ul = document.createElement("ul");\nconst a = document.createElement("li"); a.textContent = "A";\nconst b = document.createElement("li"); b.textContent = "B";\nul.appendChild(b);\nul.insertBefore(a, ul.firstChild);\nconsole.log(ul.firstElementChild.textContent);`],
    ["replaceChild.", "replace", `// TODO\n`, `const div = document.createElement("div");\nconst p1 = document.createElement("p"); p1.textContent = "viejo";\nconst p2 = document.createElement("p"); p2.textContent = "nuevo";\ndiv.appendChild(p1);\ndiv.replaceChild(p2, p1);\nconsole.log(div.textContent);`],
    ["cloneNode(true).", "clone", `// TODO\n`, `const ul = document.createElement("ul");\nul.appendChild(document.createElement("li"));\nconsole.log(ul.cloneNode(true).children.length);`],
    ["DocumentFragment con varios li.", "fragment", `// TODO\n`, `const frag = document.createDocumentFragment();\n["a","b"].forEach(t => { const li = document.createElement("li"); li.textContent = t; frag.appendChild(li); });\nconsole.log(frag.childElementCount);`],
    ["Resumen manipulación DOM.", "log", `// TODO\n`, `console.log("crear, insertar, eliminar nodos");`],
  ]),
});

writeSubtopic(ut7, {
  id: "03-atributos-y-enlaces",
  theory: [{
    file: "01-atributos-href.js",
    title: "Atributos y enlaces",
    description: "getAttribute, setAttribute, href.",
    body: `const a = document.querySelector("a");\nif (a) {\n  console.log(a.getAttribute("href"));\n  a.setAttribute("title", "Enlace");\n}`,
  }],
  exercises: ten("atributo", "Atributo", [
    ["getAttribute('href') de un enlace.", "href", `// TODO\n`, `const a = document.querySelector("a");\nif (a) console.log(a.getAttribute("href"));`],
    ["setAttribute title en enlace.", "setAttribute", `// TODO\n`, `const a = document.querySelector("a");\nif (a) { a.setAttribute("title", "Ir"); console.log(a.title); }`],
    ["hasAttribute('href').", "hasAttribute", `// TODO\n`, `const a = document.querySelector("a");\nif (a) console.log(a.hasAttribute("href"));`],
    ["removeAttribute('target').", "removeAttribute", `// TODO\n`, `const a = document.querySelector("a");\nif (a) { a.removeAttribute("target"); console.log(a.target); }`],
    ["dataset en elemento con data-id.", "dataset", `// TODO\n`, `const el = document.querySelector("[data-id]");\nif (el) console.log(el.dataset.id);`],
    ["location.href en consola.", "location", `// TODO\n`, `console.log(location.href);`],
    ["location.assign explicación (sin navegar).", "assign", `// TODO\n`, `console.log("location.assign cambia la URL");`],
    ["Crear enlace y asignar href.", "createElement", `// TODO\n`, `const a = document.createElement("a");\na.href = "#inicio";\na.textContent = "Inicio";\nconsole.log(a.href);`],
    ["id y getElementById roundtrip.", "id", `// TODO\n`, `const d = document.createElement("div");\nd.id = "demo";\ndocument.body.appendChild(d);\nconsole.log(document.getElementById("demo") === d);`],
    ["Resumen atributos.", "log", `// TODO\n`, `console.log("get/setAttribute, href, dataset");`],
  ]),
});

writeSubtopic(ut7, {
  id: "04-classlist-y-contenido",
  theory: [{
    file: "01-classlist.js",
    title: "classList",
    description: "add, remove, toggle, contains.",
    body: `const el = document.querySelector(".caja");\nif (el) {\n  el.classList.add("activo");\n  console.log(el.classList.contains("activo"));\n}`,
  }],
  exercises: ten("classlist", "ClassList", [
    ["classList.add('resaltado').", "add", `// TODO\n`, `const el = document.querySelector("p") || document.body;\nel.classList.add("resaltado");\nconsole.log(el.className);`],
    ["classList.remove('oculto').", "remove", `// TODO\n`, `const el = document.body;\nel.classList.remove("oculto");\nconsole.log("remove ok");`],
    ["classList.toggle('activo').", "toggle", `// TODO\n`, `const el = document.body;\nconsole.log(el.classList.toggle("activo"));`],
    ["classList.contains.", "contains", `// TODO\n`, `console.log(document.body.classList.contains("activo"));`],
    ["classList.replace.", "replace", `// TODO\n`, `const el = document.body;\nel.classList.replace("viejo", "nuevo");\nconsole.log(el.className);`],
    ["style.color solo si manipulas estilo.", "style", `// TODO\n`, `document.body.style.color = "navy";\nconsole.log(document.body.style.color);`],
    ["innerHTML de un div creado.", "innerHTML", `// TODO\n`, `const d = document.createElement("div");\nd.innerHTML = "<strong>DOM</strong>";\nconsole.log(d.innerHTML);`],
    ["Marcar párrafos con clase desde querySelectorAll.", "forEach", `// TODO\n`, `document.querySelectorAll("p").forEach(p => p.classList.add("marcado"));\nconsole.log(document.querySelectorAll("p.marcado").length);`],
    ["Separación HTML/CSS/JS en log.", "capas", `// TODO\n`, `console.log("HTML estructura, CSS aspecto, JS comportamiento");`],
    ["Resumen classList.", "log", `// TODO\n`, `console.log("add, remove, toggle, contains");`],
  ]),
});

writeRepaso(ut7, "05-repaso", ten("repaso-ut7", "Repaso UT7", [
    ["Selector + textContent.", "selector", `// TODO\n`, `const h = document.querySelector("h1");\nif (h) console.log(h.textContent);`],
    ["Crear ul con 2 li.", "create", `// TODO\n`, `const ul = document.createElement("ul");\n[1,2].forEach(n => { const li = document.createElement("li"); li.textContent = n; ul.appendChild(li); });\nconsole.log(ul.children.length);`],
    ["classList toggle.", "classList", `// TODO\n`, `document.body.classList.toggle("repaso");\nconsole.log(document.body.className);`],
    ["getAttribute href.", "attr", `// TODO\n`, `const a = document.querySelector("a");\nif (a) console.log(a.getAttribute("href"));`],
    ["querySelectorAll li.", "all", `// TODO\n`, `console.log(document.querySelectorAll("li").length);`],
    ["createElement + appendChild.", "append", `// TODO\n`, `const p = document.createElement("p");\np.textContent = "fin";\ndocument.body.appendChild(p);\nconsole.log("añadido");`],
    ["dataset log.", "data", `// TODO\n`, `console.log("data-* en dataset");`],
    ["RA6 checklist.", "array", `// TODO\n`, `["selectores","nodos","atributos","classList"].forEach((t,i)=>console.log(i+1,t));`],
    ["Motores navegador (visión general).", "log", `// TODO\n`, `console.log("mismo estándar DOM; diferencias menores históricas");`],
    ["Cierre UT7.", "log", `// TODO\n`, `console.log("UT7 DOM repasado");`],
  ]));

console.log("UT7 generada.");
